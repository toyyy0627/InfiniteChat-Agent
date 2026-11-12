package com.myproject.infinitechatagent.ai;

import com.myproject.infinitechatagent.skill.SkillTool;
import com.myproject.infinitechatagent.tool.EmailTool;
import com.myproject.infinitechatagent.tool.RagTool;
import com.myproject.infinitechatagent.tool.TimeTool;
import dev.langchain4j.community.store.memory.chat.redis.RedisChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiChatService {

    @Resource
    private ChatModel chatModel;

    @Resource
    private StreamingChatModel streamingChatModel;

    @Resource
    private McpToolProvider mcpToolProvider;

    @Resource
    private RedisChatMemoryStore redisChatMemoryStore;

    @Resource
    @Qualifier("rerankingContentRetriever")
    private ContentRetriever rerankingContentRetriever; // 小心每次都自动入库

    @Resource
    private RagTool ragTool;

    @Resource
    private EmailTool emailTool;

    @Resource
    private SkillTool skillTool;

    @Bean
    public AiChat aiChat() {

        return AiServices.builder(AiChat.class)
                .chatModel(chatModel)
                .streamingChatModel(streamingChatModel)
                .contentRetriever(rerankingContentRetriever)
                //  把技能清单追加到 @SystemMessage 读到的提示词后面，技能清单会插入到每次的上下文中
                //  transformer 跑在 @SystemMessage 解析之后，所以 AiChat 接口一行都不用改。
                .systemMessageTransformer(sm -> sm + "\n\n" + skillTool.catalog())
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .chatMemoryStore(redisChatMemoryStore)
                        .maxMessages(20)
                        .build())
                .contentRetriever(rerankingContentRetriever)
                .tools(new TimeTool(), ragTool, emailTool, skillTool)
                .toolProvider(mcpToolProvider)
                .build();

    }
}