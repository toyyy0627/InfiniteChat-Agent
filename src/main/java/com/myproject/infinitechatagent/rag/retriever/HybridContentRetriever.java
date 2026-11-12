package com.myproject.infinitechatagent.rag.retriever;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 混合检索器：把向量检索(稠密)与 BM25 检索(稀疏)两路结果,
 * 用 RRF(Reciprocal Rank Fusion,倒数排名融合)合并后返回 top-N。
 *
 * RRF 打分：score(d) = Σ 1 / (k + rank_i(d))
 *  - rank_i 是文档 d 在第 i 路结果里的名次(从 1 开始)
 *  - k 是平滑常数(经验值 60)
 * 只用名次、不用各自的原始分,天然规避"余弦相似度"和"BM25 分"量纲不一致的问题。
 */
@Slf4j
public class HybridContentRetriever implements ContentRetriever {

    private final ContentRetriever vectorRetriever;
    private final ContentRetriever bm25Retriever;
    private final int maxResults;
    private final double rrfK;

    public HybridContentRetriever(ContentRetriever vectorRetriever,
                                  ContentRetriever bm25Retriever,
                                  int maxResults,
                                  double rrfK) {
        this.vectorRetriever = vectorRetriever;
        this.bm25Retriever = bm25Retriever;
        this.maxResults = maxResults;
        this.rrfK = rrfK;
    }

    @Override
    public List<Content> retrieve(Query query) {
        List<Content> vectorHits = vectorRetriever.retrieve(query);
        List<Content> bm25Hits = bm25Retriever.retrieve(query);

        // 用文本内容做去重键,累加两路的 RRF 分
        Map<String, Double> scoreByKey = new LinkedHashMap<>();
        Map<String, Content> contentByKey = new LinkedHashMap<>();

        accumulate(vectorHits, scoreByKey, contentByKey);
        accumulate(bm25Hits, scoreByKey, contentByKey);

        // 按融合分从高到低,取 top-maxResults
        List<Content> fused = scoreByKey.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(maxResults)
                .map(e -> contentByKey.get(e.getKey()))
                .collect(Collectors.toList());

        log.info("混合检索 - 向量 {} 条 / BM25 {} 条 / 融合去重后取 top-{} = {} 条",
                vectorHits.size(), bm25Hits.size(), maxResults, fused.size());
        return fused;
    }

    /** 把一路结果按名次累加 RRF 分；名次 i 从 0 开始,故 rank = i + 1。 */
    private void accumulate(List<Content> hits,
                            Map<String, Double> scoreByKey,
                            Map<String, Content> contentByKey) {
        for (int i = 0; i < hits.size(); i++) {
            Content content = hits.get(i);
            String key = content.textSegment().text();
            contentByKey.putIfAbsent(key, content);
            scoreByKey.merge(key, 1.0 / (rrfK + i + 1), Double::sum);
        }
    }
}