package com.myproject.infinitechatagent.rag.retriever;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.scoring.ScoringModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 重排检索器（两阶段检索的第二阶段：精排）。
 *
 * 它是一个「装饰器」：把已有的粗召回检索器（这里传入 hybridContentRetriever，即 向量+BM25 的 RRF 融合）
 * 包在里面，先让它粗召回 topN 候选，再用 ScoringModel(qwen3-rerank) 对每个「查询-候选」打分，
 * 按相关性从高到低重新排序，最后截取 topK 返回。
 *
 * 为什么用装饰器而不是 langchain4j 自带的 ReRankingContentAggregator：
 * 项目里 EvalController 和 AiChatService 都是直接把 ContentRetriever 当作检索入口来用，
 * 而 ReRankingContentAggregator 属于 RetrievalAugmentor 内部的聚合环节。用装饰器可以让这两个
 * 调用点几乎不用改（只把注入的 Bean 换成本类），并且和课程里 HybridContentRetriever 的写法一脉相承。
 *
 * 关键约束：
 * - topN（粗召回条数）要明显大于 topK（精排后保留条数），给精排足够的候选空间，否则精排没什么可排的。
 * - minScore 用来砍掉相关性过低的候选（qwen3-rerank 的分数是 0~1）。
 */
@Slf4j
public class RerankingContentRetriever implements ContentRetriever {

    private final ContentRetriever baseRetriever; // 粗召回：混合检索
    private final ScoringModel scoringModel;      // 精排：qwen3-rerank
    private final int topK;                        // 精排后最终保留条数
    private final double minScore;                 // 相关性阈值，低于它的直接丢弃

    public RerankingContentRetriever(ContentRetriever baseRetriever,
                                     ScoringModel scoringModel,
                                     int topK,
                                     double minScore) {
        this.baseRetriever = baseRetriever;
        this.scoringModel = scoringModel;
        this.topK = topK;
        this.minScore = minScore;
    }

    @Override
    public List<Content> retrieve(Query query) {
        // 1) 先拿粗召回结果（混合检索已经做了 RRF 融合、去重）
        List<Content> candidates = baseRetriever.retrieve(query);
        if (candidates == null || candidates.isEmpty()) {
            return List.of();
        }
        // 只有一条时无需精排，直接返回，省一次模型调用
        if (candidates.size() == 1) {
            return candidates;
        }

        try {
            // 2) 批量打分：把候选的纯文本抽出来，交给 rerank 模型和 query 一起算相关性
            List<TextSegment> segments = new ArrayList<>(candidates.size());
            for (Content c : candidates) {
                segments.add(c.textSegment());
            }
            // ScoringModel.scoreAll 返回与 segments 顺序一一对应的分数列表
            List<Double> scores = scoringModel.scoreAll(segments, query.text()).content();

            // 3) 把 (候选, 分数) 配对，按分数从高到低排序
            List<Scored> scored = new ArrayList<>(candidates.size());
            for (int i = 0; i < candidates.size(); i++) {
                double s = (i < scores.size() && scores.get(i) != null) ? scores.get(i) : 0.0;
                scored.add(new Scored(candidates.get(i), s));
            }
            scored.sort(Comparator.comparingDouble((Scored x) -> x.score).reversed());

            // 4) 过阈值 + 截取 topK
            List<Content> result = new ArrayList<>(topK);
            for (Scored x : scored) {
                if (x.score < minScore) {
                    continue;
                }
                result.add(x.content);
                if (result.size() >= topK) {
                    break;
                }
            }

            // 兜底：如果阈值把所有候选都砍光了，至少返回分数最高的 topK，避免答案侧「无资料可用」
            if (result.isEmpty()) {
                for (Scored x : scored) {
                    result.add(x.content);
                    if (result.size() >= topK) {
                        break;
                    }
                }
                log.warn("重排 - 所有候选均低于阈值 {}，已回退为分数最高的 {} 条", minScore, result.size());
            }

            log.info("重排 - 粗召回 {} 条 / 精排后取 top-{} = {} 条 | Q: {}",
                    candidates.size(), topK, result.size(), query.text());
            return result;

        } catch (Exception e) {
            // 精排出问题不该拖垮整条链：降级为「粗召回的前 topK 条」
            log.error("重排失败(降级为粗召回前 {} 条): {}", topK, e.getMessage());
            return candidates.size() > topK ? candidates.subList(0, topK) : candidates;
        }
    }

    /** (候选内容, 相关性分数) 的临时配对结构。 */
    private static final class Scored {
        final Content content;
        final double score;

        Scored(Content content, double score) {
            this.content = content;
            this.score = score;
        }
    }
}