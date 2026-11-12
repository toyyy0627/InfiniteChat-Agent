package com.myproject.infinitechatagent;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class}) // 这个项目选择用 PostgreSQL（配合pgvector）存向量,关闭Redis向量存储的自动配置
public class InfiniteChatAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfiniteChatAgentApplication.class, args);
    }

}
