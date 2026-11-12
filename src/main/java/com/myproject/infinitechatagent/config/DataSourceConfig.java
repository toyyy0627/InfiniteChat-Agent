package com.myproject.infinitechatagent.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * BM25 检索器专用的数据源配置。
 * 复用 pgvector.* 的连接参数,单独提供 DataSource + JdbcTemplate 给 BM25 执行原生 SQL。
 * 它和 langchain4j 内部连接相互独立,只是指向同一个库、同一张表。
 * 显式声明 DataSource 后,Spring Boot 不会再因没配 spring.datasource.url 而报
 * "Failed to configure a DataSource"。
 */
@Configuration
public class DataSourceConfig {

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

    @Bean
    public DataSource pgDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://" + host + ":" + port + "/" + database);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(5);
        config.setPoolName("bm25-pool");
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource pgDataSource) {
        return new JdbcTemplate(pgDataSource);
    }
}