package com.myproject.infinitechatagent.config;

import java.util.List;

import com.myproject.infinitechatagent.monitor.AiModelMonitorListener;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.QwenStreamingChatModel;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DashScopeModelConfig {

    @Value("${langchain4j.community.dashscope.chat-model.api-key}")
    private String apiKey;

    @Value("${langchain4j.community.dashscope.chat-model.model-name}")
    private String modelName;

    @Resource
    private AiModelMonitorListener aiModelMonitorListener;

    @Bean
    @Primary // 优先级
    public ChatModel chatModel() {
        return QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName(modelName)
                .listeners(List.of(aiModelMonitorListener)) // 重写bean，把监听类加进大模型
                .build();
    }

    @Bean
    @Primary
    public StreamingChatModel streamingChatModel() {
        return QwenStreamingChatModel.builder()
                .apiKey(apiKey)
                .modelName(modelName)
                .listeners(List.of(aiModelMonitorListener))
                .build();
    }
}