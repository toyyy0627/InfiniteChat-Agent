package com.myproject.infinitechatagent.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.pgvector.PgVectorEmbeddingStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EmbeddingStoreConfig {

    @Value("${pgvector.host}")
    private String host;

    @Value("${pgvector.port}")
    private int port;

    @Value("${pgvector.database}")
    private String database;

    @Value("${pgvector.user}")
    private String user;

    @Value("${pgvector.password}")
    private String password;

    @Value("${pgvector.table}")
    private String table;

    @Bean
    public EmbeddingStore<TextSegment> initEmbeddingStore() {

        return PgVectorEmbeddingStore.builder()
                .table(table)
                .dropTableFirst(true) // 每次启动重建
                .createTable(true)
                .host(host)
                .port(port)
                .user(user)
                .password(password)
                .dimension(1024)
                .database(database)
                .build();
    }
}