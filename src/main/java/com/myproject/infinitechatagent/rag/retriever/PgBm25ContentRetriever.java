package com.myproject.infinitechatagent.rag.retriever;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

/**
 * 基于 PostgreSQL(ParadeDB pg_search) 的 BM25 稀疏检索器。
 * 直接对 langchain4j 写入的向量表(text 列)做 BM25 全文检索,
 * 与向量检索共用同一张表、同一批数据,天然不需要额外同步。
 */
@Slf4j
public class PgBm25ContentRetriever implements ContentRetriever {

    private final JdbcTemplate jdbcTemplate;
    private final String table;
    private final int maxResults;

    public PgBm25ContentRetriever(JdbcTemplate jdbcTemplate, String table, int maxResults) {
        this.jdbcTemplate = jdbcTemplate;
        this.table = table;
        this.maxResults = maxResults;
    }

    @Override
    public List<Content> retrieve(Query query) {
        String question = query.text();
        if (question == null || question.isBlank()) {
            return Collections.emptyList();
        }

        // paradedb.match('text', ?)：用 text 列的分词器(chinese_compatible)把问题切词,
        // 命中任一 token 即为候选；paradedb.score(embedding_id) 是该行的 BM25 得分。
        // 用占位符 ? 传入问题,天然规避注入与特殊字符解析问题。
        String sql = "SELECT text, paradedb.score(embedding_id) AS score "
                + "FROM " + table + " "
                + "WHERE embedding_id @@@ paradedb.match('text', ?) "
                + "ORDER BY score DESC "
                + "LIMIT ?";

        try {
            List<Content> contents = jdbcTemplate.query(
                    sql,
                    // text 里已含灌库时前置的 file_name,与向量检索返回文本一致,保证 RRF 能正确去重
                    (rs, rowNum) -> Content.from(rs.getString("text")),
                    question, maxResults
            );
            log.info("BM25 检索 - Q: {} | 命中 {} 条", question, contents.size());
            return contents;
        } catch (Exception e) {
            // BM25 出问题不应拖垮整条链：降级为空,让向量检索兜底
            log.error("BM25 检索失败(降级为空结果): {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}