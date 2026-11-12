# -*- coding: utf-8 -*-
"""
RAG 评测脚本（Ragas + 通义千问 Qwen）—— 千言项目

数据来源：test_dataset.json（每条含 question + reference）。脚本包含三块设计：

  1) 【正 / 负样本分离】test_dataset 里，标准答案为“拒答话术”的题视为**负样本**
     （答案本就不在知识库里，考察模型会不会老实拒答、而不是瞎编）。
     - ragas 四指标（忠实度 / 答案相关性 / 上下文精确率（本项目以标准答案为参照计算） / 上下文召回率）**只在正样本上计算**。
       原因：负样本没有“相关片段”可供排序，其 precision/recall 没有意义；而一句通用拒答会被
       ragas 的 answer_relevancy 判 0，纯属度量假象，会把均分拖低。

  2) 【拒答相关指标】单独成区，不混进上面四项：
     - 负样本拒答准确率  = 负样本里“正确拒答”的比例（越高越好，理想 100%）。
     - 正样本误拒率      = 正样本里“本该回答却拒答”的比例（越低越好，指向真实漏检）。

  3) 【Hit Rate@K】检索命中率，仅在正样本上算。
     定义：top-K 召回片段中，只要有一片“含到答案内容”，该题就算命中。
     Hit@K = 命中题数 / 正样本题数。K 取值不超过检索器的 maxResults(=5)。
     ——判定“片段是否含答案”用的是**文本覆盖代理法**（见 context_hits_answer），
       因为接口只返回片段文本、没有金标准 chunk id。该方法与 ragas 上下文召回率强相关
       （召回=0 的题 Hit@5 为 0；召回=1 的题 Hit@5 接近 1）。
       局限：极短、且措辞被打散的事实型答案偶有低估，属已知误差、跨实验一致，不影响横向对比。
       若要最高保真，可把 context_hits_answer 换成一次 LLM 裁判调用（见函数内注释）。

工作流：
  1. 把 Test.md 放到 src/main/resources/docs/ 下（知识库，启动时自动灌入向量库）
  2. 以 dev 环境启动 Spring Boot（EvalController 生效），默认 http://localhost:10010/api/eval/rag
  3. export DASHSCOPE_API_KEY=sk-xxxx
  4. 先小样本： SAMPLE_SIZE=15 python ragas_eval.py
     再全量：   SAMPLE_SIZE=all python ragas_eval.py
     ⚠️ 全量才含全部负样本，拒答准确率才有意义；小样本抽样可能抽不到负样本。

产出：
  - 控制台分区打印：ragas 四指标(正样本) / Hit@K / 拒答相关 / 最需关注的题
  - ragas_result.csv：每题明细（列名中文，含样本类型、拒答评估、Hit@K、综合分）

注意：ragas 对 langchain 版本极其敏感，务必用 requirements.txt 里锁定的版本。
"""
import os
import re
import json
import random
import requests
from difflib import SequenceMatcher

import numpy as np
import pandas as pd

from langchain_openai import ChatOpenAI, OpenAIEmbeddings
from ragas import EvaluationDataset, evaluate
from ragas.dataset_schema import SingleTurnSample
from ragas.llms import LangchainLLMWrapper
from ragas.embeddings import LangchainEmbeddingsWrapper
from ragas.run_config import RunConfig
# 用小写预置实例，跨 0.2.x 小版本最稳；llm/embeddings 由 evaluate() 统一注入
from ragas.metrics import faithfulness, answer_relevancy, context_precision, context_recall

# ==================== 配置 ====================
EVAL_ENDPOINT = os.getenv("EVAL_ENDPOINT", "http://localhost:10010/api/eval/rag")

# 抽样条数：先用小样本（如 15）验证管道 + 控制花费；填 "all" 或 0 表示跑全部
_ss = os.getenv("SAMPLE_SIZE", "15").strip().lower()
SAMPLE_SIZE = 0 if _ss in ("all", "0", "") else int(_ss)

# DashScope 的 OpenAI 兼容接口：直接复用项目里的 Qwen key
#   国内(北京) https://dashscope.aliyuncs.com/compatible-mode/v1
#   新加坡     https://dashscope-intl.aliyuncs.com/compatible-mode/v1
#   美国       https://dashscope-us.aliyuncs.com/compatible-mode/v1
DASHSCOPE_API_KEY = os.environ["DASHSCOPE_API_KEY"]
DASHSCOPE_BASE_URL = "https://dashscope.aliyuncs.com/compatible-mode/v1"

# —— 拒答话术特征：与 EvalController 严格提示词里“查不到就拒答”的输出、以及负样本标准答案保持一致 ——
# 拒答标准答案是「根据现有资料无法回答。」，取其稳定子串「无法回答」做特征即可，实测无误伤。
REFUSAL_PHRASE = os.getenv("REFUSAL_PHRASE", "无法回答")

# —— Hit Rate@K 配置 ——
HIT_K_LIST = [1, 3, 5]      # K 不要超过检索器 maxResults(=5)
HIT_CONTIG_THR = 0.60       # 分支1：最长连续重叠 / 较短串长度 的阈值
HIT_NGRAM_THR = 0.85        # 分支2：参考答案字符三元组落在该片段的比例 阈值

# 裁判模型 qwen3-max，向量模型 text-embedding-v4（与线上保持一致）
judge_llm = LangchainLLMWrapper(ChatOpenAI(
    model="qwen3-max",
    api_key=DASHSCOPE_API_KEY,
    base_url=DASHSCOPE_BASE_URL,
    temperature=0,            # 裁判要稳定
))
judge_embeddings = LangchainEmbeddingsWrapper(OpenAIEmbeddings(
    model="text-embedding-v4",
    api_key=DASHSCOPE_API_KEY,
    base_url=DASHSCOPE_BASE_URL,
    check_embedding_ctx_length=False,
))

# ==================== 工具函数 ====================
def _norm(s: str) -> str:
    """归一化：去掉所有空白/标点/下划线，仅保留字母数字与汉字，转小写。"""
    return re.sub(r"[\s\W_]+", "", str(s)).lower()

def _trigrams(s: str, n: int = 3) -> set:
    """字符 n 元组集合（默认三元组），用于捕捉“关键事实散落”的命中。"""
    s = _norm(s)
    if len(s) < n:
        return {s} if s else set()
    return {s[i:i + n] for i in range(len(s) - n + 1)}

def is_refusal(text: str) -> bool:
    """模型答案 / 标准答案 是否为拒答。"""
    return REFUSAL_PHRASE in str(text)

def is_negative_sample(item: dict) -> bool:
    """判断 test_dataset 条目是否为负样本：优先看显式标记，否则看标准答案是否为拒答话术。"""
    if item.get("is_negative") is True or item.get("type") == "negative":
        return True
    return is_refusal(item.get("reference", ""))

def context_hits_answer(reference: str, context: str) -> bool:
    """
    判定单个召回片段是否“含到答案内容”。文本覆盖代理法（混合两条分支，命中其一即算）：
      分支1（连续重叠）：参考答案与片段的最长公共连续子串 / 较短串长度 >= HIT_CONTIG_THR
                        —— 抓“整段答案落在某一片里”的情况（含被切块截断的情形）。
      分支2（三元组覆盖）：参考答案的字符三元组，有 >= HIT_NGRAM_THR 落在该片段里
                        —— 抓“版本号等关键事实散落在片段中、但措辞被打散”的情况。
    ⚠️ 想要最高保真，可整体替换为一次 LLM 裁判：
        用 judge_llm 问“下面这段资料是否包含回答该问题所需的信息？只答 是/否”，
        对 top-K 逐片判定。更准但更贵（正样本数 × K 次额外调用）。此处默认用免费的确定性代理法。
    """
    r, c = _norm(reference), _norm(context)
    if not r or not c:
        return False
    # 分支1：最长连续重叠
    m = SequenceMatcher(None, r, c).find_longest_match(0, len(r), 0, len(c))
    if m.size / min(len(r), len(c)) >= HIT_CONTIG_THR:
        return True
    # 分支2：三元组覆盖
    gr = _trigrams(reference)
    if gr and len(gr & _trigrams(context)) / len(gr) >= HIT_NGRAM_THR:
        return True
    return False

def hit_at_k(reference: str, contexts: list, k: int) -> int:
    """top-K 里只要有一片命中答案 → 1，否则 0。"""
    for c in (contexts or [])[:k]:
        if context_hits_answer(reference, c):
            return 1
    return 0

# ==================== 1. 读测试集 ====================
with open("test_dataset.json", "r", encoding="utf-8") as f:
    test_dataset = json.load(f)

if SAMPLE_SIZE and SAMPLE_SIZE < len(test_dataset):
    random.seed(42)                       # 固定种子，保证每次抽到同一批，结果可比
    test_dataset = random.sample(test_dataset, SAMPLE_SIZE)

n_neg_planned = sum(is_negative_sample(x) for x in test_dataset)
n_pos_planned = len(test_dataset) - n_neg_planned
print(f"本次评测题量：{len(test_dataset)}  （正样本 {n_pos_planned} / 负样本 {n_neg_planned}）\n")
if n_neg_planned == 0:
    print("⚠️ 本次没有负样本：拒答准确率将显示 N/A。想评测抗幻觉能力请在测试集中加入负样本，"
          "或用 SAMPLE_SIZE=all 跑全量。\n")

# ==================== 2. 逐条打 Java 评测接口，收集 answer + contexts ====================
rows, failed = [], []
for i, item in enumerate(test_dataset, 1):
    question = item["question"]
    reference = item["reference"]         # 标准答案（正样本=真答案；负样本=拒答话术）
    neg = is_negative_sample(item)
    try:
        resp = requests.post(EVAL_ENDPOINT, json={"question": question}, timeout=180)
        resp.raise_for_status()
        data = resp.json()
        answer = data.get("answer", "")
        contexts = data.get("contexts", []) or []
        rows.append({
            "question": question,
            "reference": reference,
            "answer": answer,
            "contexts": contexts,
            "is_negative": neg,
            "refused": is_refusal(answer),
        })
        tag = "负样本" if neg else "正样本"
        print(f"[{i}/{len(test_dataset)}] OK  [{tag}] 命中上下文 {len(contexts)} 条  | {question}")
    except Exception as e:
        failed.append((question, str(e)))
        print(f"[{i}/{len(test_dataset)}] 失败：{question}  ->  {e}")

if failed:
    print(f"\n⚠️ {len(failed)} 条采集失败（已跳过），检查项目是否启动、接口是否可达")
if not rows:
    raise SystemExit("没有任何可评测样本，退出。")

pos_rows = [r for r in rows if not r["is_negative"]]
neg_rows = [r for r in rows if r["is_negative"]]

# ==================== 3. ragas 四指标：只跑正样本 ====================
ragas_metric_by_q = {}   # question -> {faithfulness, answer_relevancy, context_precision, context_recall}
if pos_rows:
    pos_samples = [
        SingleTurnSample(
            user_input=r["question"],
            response=r["answer"],
            retrieved_contexts=r["contexts"],
            reference=r["reference"],
        )
        for r in pos_rows
    ]
    eval_dataset = EvaluationDataset(samples=pos_samples)
    metrics = [faithfulness, answer_relevancy, context_precision, context_recall]

    print("\n开始评测（仅正样本，每题背后有多次裁判模型调用，请耐心等待）...")
    result = evaluate(
        dataset=eval_dataset,
        metrics=metrics,
        llm=judge_llm,
        embeddings=judge_embeddings,
        run_config=RunConfig(max_workers=4),   # 并发调小些，避免触发 DashScope 限流
    )
    rdf = result.to_pandas()

    # 兼容不同小版本的列名，按“关键子串”定位四项指标列
    def _find_col(df, key):
        for col in df.columns:
            if key in col:
                return col
        return None
    col_f = _find_col(rdf, "faithfulness")
    col_r = _find_col(rdf, "answer_relevancy")
    col_p = _find_col(rdf, "context_precision")
    col_c = _find_col(rdf, "context_recall")
    qcol = _find_col(rdf, "user_input") or "user_input"

    for _, rr in rdf.iterrows():
        ragas_metric_by_q[rr[qcol]] = {
            "faithfulness": pd.to_numeric(rr.get(col_f), errors="coerce") if col_f else np.nan,
            "answer_relevancy": pd.to_numeric(rr.get(col_r), errors="coerce") if col_r else np.nan,
            "context_precision": pd.to_numeric(rr.get(col_p), errors="coerce") if col_p else np.nan,
            "context_recall": pd.to_numeric(rr.get(col_c), errors="coerce") if col_c else np.nan,
        }

# ==================== 4. Hit@K + 综合分：写回每条正样本 ====================
for r in rows:
    m = ragas_metric_by_q.get(r["question"], {})
    r["faithfulness"] = m.get("faithfulness", np.nan)
    r["answer_relevancy"] = m.get("answer_relevancy", np.nan)
    r["context_precision"] = m.get("context_precision", np.nan)
    r["context_recall"] = m.get("context_recall", np.nan)
    if r["is_negative"]:
        for k in HIT_K_LIST:
            r[f"hit@{k}"] = np.nan
        r["composite"] = np.nan
    else:
        for k in HIT_K_LIST:
            r[f"hit@{k}"] = hit_at_k(r["reference"], r["contexts"], k)
        vals = [r["faithfulness"], r["answer_relevancy"], r["context_precision"], r["context_recall"]]
        vals = [v for v in vals if pd.notna(v)]
        r["composite"] = float(np.mean(vals)) if vals else np.nan

# ==================== 5. 拒答相关指标 ====================
# 负样本拒答准确率：负样本里“正确拒答”的比例（越高越好）
if neg_rows:
    neg_correct = sum(r["refused"] for r in neg_rows)
    refusal_accuracy = neg_correct / len(neg_rows)
    neg_leaked = [r for r in neg_rows if not r["refused"]]   # 该拒没拒 → 幻觉风险
else:
    neg_correct = 0
    refusal_accuracy = None
    neg_leaked = []
# 正样本误拒率：正样本里“本该回答却拒答”的比例（越低越好）
if pos_rows:
    pos_over = [r for r in pos_rows if r["refused"]]
    over_refusal_rate = len(pos_over) / len(pos_rows)
else:
    pos_over = []
    over_refusal_rate = None

# ==================== 6. 打印报告 ====================
def _mean(rows_, key):
    vals = [r[key] for r in rows_ if pd.notna(r.get(key, np.nan))]
    return float(np.mean(vals)) if vals else float("nan")

print("\n" + "=" * 64)
print("            Ragas 评测结果  （取值 0~1，越高越好）")
print("=" * 64)
print(f"  正样本 {len(pos_rows)} 题（ragas 四指标只在这些题上计算）")
print(f"  负样本 {len(neg_rows)} 题（不参与四指标，单独看下方“拒答相关”）\n")
print(f"  忠实度        {_mean(pos_rows,'faithfulness'):.4f}   —— 答案是否忠于召回内容、不编造（防幻觉）")
print(f"  答案相关性    {_mean(pos_rows,'answer_relevancy'):.4f}   —— 答案是否切题、直接回应问题")
print(f"  上下文精确率  {_mean(pos_rows,'context_precision'):.4f}   —— 召回片段是否相关、相关的是否排在前面")
print(f"  上下文召回率  {_mean(pos_rows,'context_recall'):.4f}   —— 该召回的关键信息是否都召回了")

print("\n" + "-" * 64)
print("  检索命中率 Hit Rate@K （仅正样本；top-K 里有一片含答案即命中）")
print("-" * 64)
for k in HIT_K_LIST:
    print(f"  Hit@{k}        {_mean(pos_rows, f'hit@{k}'):.4f}")

print("\n" + "-" * 64)
print("  拒答相关 （单独统计，不并入上面指标）")
print("-" * 64)
if refusal_accuracy is None:
    print("  负样本拒答准确率   N/A（本次无负样本）")
else:
    print(f"  负样本拒答准确率   {refusal_accuracy:.4f}  （{neg_correct}/{len(neg_rows)} 正确拒答，越高越好，理想 1.0）")
    if neg_leaked:
        print(f"    ⚠ 有 {len(neg_leaked)} 道负样本没拒答（存在幻觉风险）：")
        for r in neg_leaked:
            print(f"      · {r['question']}  ->  {r['answer']}")
if over_refusal_rate is None:
    print("  正样本误拒率       N/A（本次无正样本）")
else:
    print(f"  正样本误拒率       {over_refusal_rate:.4f}  （{len(pos_over)}/{len(pos_rows)} 本该答却拒答，越低越好；这些就是真实漏检）")
    for r in pos_over:
        print(f"      · {r['question']}  | 召回{len(r['contexts'])}条 Hit@5={int(r.get('hit@5',0))}")

# 最需要关注的题（正样本里综合分最低）
scored = [r for r in pos_rows if pd.notna(r.get("composite", np.nan))]
scored.sort(key=lambda r: r["composite"])
if scored:
    print("\n最需要关注的题（正样本综合分最低，建议优先排查）：")
    for r in scored[:5]:
        print(f"  · 综合 {r['composite']:.3f}  | {r['question']}")

# ==================== 7. 写明细 CSV ====================
def _eval_label(r):
    if r["is_negative"]:
        return "✓正确拒答" if r["refused"] else "✗漏拒(幻觉风险)"
    return "✗误拒(应答却拒答)" if r["refused"] else "正常回答"

out = []
for r in rows:
    row = {
        "问题": r["question"],
        "样本类型": "负样本" if r["is_negative"] else "正样本",
        "拒答评估": _eval_label(r),
        "召回上下文": r["contexts"],
        "模型答案": r["answer"],
        "标准答案": r["reference"],
        "忠实度": r["faithfulness"],
        "答案相关性": r["answer_relevancy"],
        "上下文精确率": r["context_precision"],
        "上下文召回率": r["context_recall"],
    }
    for k in HIT_K_LIST:
        row[f"命中@{k}"] = r.get(f"hit@{k}", np.nan)
    row["综合分"] = r.get("composite", np.nan)
    out.append(row)

pd.DataFrame(out).to_csv("ragas_result.csv", index=False, encoding="utf-8-sig")
print("\n每条明细已保存到 ragas_result.csv（列名中文，Excel 直接打开可逐题看分）")