package com.myproject.infinitechatagent.config;

import dev.langchain4j.community.model.dashscope.QwenScoringModel;
import dev.langchain4j.model.scoring.ScoringModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 重排（Rerank）模型配置。
 *
 * 用百炼平台的 qwen3-rerank 做二阶段精排：粗召回（向量 + BM25，RRF 融合）先捞回一批候选，
 * 再交给这个交叉编码器逐条给「查询-候选」打分，把最相关的顶到最前。
 *
 * ScoringModel 是 langchain4j 对「打分/重排模型」的统一抽象；QwenScoringModel 是
 * langchain4j-community 里对接 DashScope(百炼) TextReRank 的实现，自 1.17.0-beta27 起提供。
 */
@Configuration
public class RerankModelConfig {

    // 复用项目里同一把百炼 key（chat-model 已配置好，直接取用即可）
    @Value("${langchain4j.community.dashscope.chat-model.api-key}")
    private String apiKey;

    // 重排模型名，默认 qwen3-rerank（gte-rerank 于 2026-05-30 下线，官方推荐迁到 qwen3-rerank）
    @Value("${rerank.model-name:qwen3-rerank}")
    private String rerankModelName;

    @Bean
    public ScoringModel scoringModel() {
        return QwenScoringModel.builder()
                .apiKey(apiKey)
                .modelName(rerankModelName)
                .build();
    }
}