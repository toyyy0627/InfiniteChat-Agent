package com.myproject.infinitechatagent.job;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 在文档灌库完成后,为向量表的 text 列建立 BM25 索引。
 * PgVectorEmbeddingStore 配了 dropTableFirst(true),每次启动表都会重建,
 * 所以 BM25 索引也要每次启动重建 —— 必须排在 RagDataLoader(@Order(1)) 之后。
 */
@Component
@Order(2)
@Slf4j
public class PgBm25IndexInitializer implements CommandLineRunner {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Value("${pgvector.table}")
    private String table;

    @Override
    public void run(String... args) {
        try {
            // 1) 确保 pg_search 扩展已启用(ParadeDB 镜像自带该扩展)
            jdbcTemplate.execute("CREATE EXTENSION IF NOT EXISTS pg_search");

            // 2) 索引先删后建,保证幂等
            String indexName = table + "_bm25_idx";
            jdbcTemplate.execute("DROP INDEX IF EXISTS " + indexName);

            // 3) 对 text 列建 BM25 索引：
            //    - key_field 必须唯一且为第一列,用建表主键 embedding_id(UUID)
            //    - (text::pdb.chinese_compatible) 指定中文分字器,中英混排友好
            jdbcTemplate.execute(
                    "CREATE INDEX " + indexName + " ON " + table + " "
                            + "USING bm25 (embedding_id, (text::pdb.chinese_compatible)) "
                            + "WITH (key_field='embedding_id')"
            );
            log.info("BM25 索引创建完成: {}", indexName);
        } catch (Exception e) {
            log.error("BM25 索引创建失败,请确认使用了 ParadeDB 镜像并能启用 pg_search 扩展", e);
        }
    }
}