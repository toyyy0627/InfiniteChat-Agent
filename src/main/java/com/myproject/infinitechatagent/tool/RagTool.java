package com.myproject.infinitechatagent.tool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RagTool {

    @Resource
    private EmbeddingStoreIngestor embeddingStoreIngestor;

    /** 复用线上那条两阶段检索链路（混合检索 + rerank 精排），查重标准和回答时完全一致 */
    @Resource
    @Qualifier("rerankingContentRetriever")
    private ContentRetriever contentRetriever;

    @Value("${rag.docs-path}")
    private String docsPath;

    /**
     * skill新增：让模型能主动查知识库。
     * AiServices 的 RAG 是框架自动注入的，模型全程被动接收、没法自己再发起一次检索；
     * kb-curator 技能第 1 步要求"入库前先查重"，就得靠这个工具。
     */
    @Tool("在知识库里检索与给定问题最相近的已有条目。用于入库前查重，或需要确认知识库里到底有没有某条内容时。")
    public String searchKnowledge(@P("要检索的核心问题或关键词，不要传用户整段原话") String query) {
        if (query == null || query.isBlank()) {
            return "检索关键词不能为空。";
        }
        try {
            List<Content> contents = contentRetriever.retrieve(Query.from(query));
            log.info("Tool 调用: 知识库查重 - Q: {} | 命中 {} 条", query, contents.size());
            if (contents.isEmpty()) {
                return "知识库中没有检索到相近条目，可视为新知识。";
            }
            String hits = contents.stream()
                    .map(c -> c.textSegment().text())
                    .collect(Collectors.joining("\n\n--------\n\n"));
            return "检索到 " + contents.size() + " 条相近内容，请判断是重复、冲突还是无关：\n\n" + hits;
        } catch (Exception e) {
            log.error("知识库查重失败: {}", query, e);
            return "知识库检索失败：" + e.getMessage() + "。请如实告知用户，不要在没查重的情况下直接入库。";
        }
    }

    /**
     * 定义工具方法。
     * 大模型会根据 @Tool 的描述和参数名来决定何时调用。
     */
    @Tool("当用户想要保存问答对、知识点或者向知识库添加新信息时调用此工具。将问题、答案和目标文件名作为参数。")
    public String addKnowledgeToRag(String question, String answer, String fileName) {
        log.info("Tool 调用: 正在保存知识 - Q: {}, file: {}", question, fileName);

        // 0. 兜底校验：SKILL.md 让模型别写 ### 开头的行，这里兜住它没照做的情况。
        //    注意是 return 一句话而不是抛异常 —— 把失败当作反馈交还给模型，它自己改完重试，对话不中断。
        if ((question + "\n" + answer).lines().anyMatch(line -> line.stripLeading().startsWith("###"))) {
            return "保存失败：问题或答案里不能有以 ### 开头的行，它会被切分器当成新块的起点，把这条知识劈成两半。"
                    + "请改写成「三个井号」这类文字表述后重新调用。";
        }

        // 1. 格式化内容（### Q. 对齐 Test.md 里已有的 200 条，块首字面串统一，BM25 才好命中）
        String formattedContent = String.format("### Q. %s\n\nA：%s", question, answer);

        // 2. 处理文件名 (防止没写后缀)
        if (fileName == null || fileName.isBlank()) {
            fileName = "InfiniteChat.md"; // 默认文件
        }
        if (!fileName.endsWith(".md")) {
            fileName = fileName + ".md";
        }

        // 3. 写入物理文件
        boolean writeSuccess = appendToFile(formattedContent, fileName);
        if (!writeSuccess) {
            return "保存失败：无法写入本地文件系统，请检查日志。";
        }

        // 4. 存入向量数据库
        try {
            // 设置来源元数据
            Metadata metadata = Metadata.from("file_name", fileName);

            // 创建文档并 Embedding
            Document document = Document.from(formattedContent, metadata);
            embeddingStoreIngestor.ingest(document);

            log.info("Tool 执行成功: 知识已同步至 RAG");
            return "成功！已将该知识点保存到文档 [" + fileName + "] 并同步至向量数据库。";
        } catch (Exception e) {
            log.error("RAG - 向量化失败", e);
            return "文件写入成功，但向量数据库更新失败：" + e.getMessage();
        }
    }

    /**
     * 辅助方法：追加写入文件
     */
    private synchronized boolean appendToFile(String content, String fileName) {
        try {
            // 拼接完整路径
            Path filePath = Paths.get(docsPath, fileName);
            
            // 如果文件不存在，先创建
            if (!Files.exists(filePath)) {
                if (filePath.getParent() != null) {
                    Files.createDirectories(filePath.getParent());
                }
                Files.createFile(filePath);
                log.info("Tool created new file: {}", filePath.toAbsolutePath());
            }

            // 加换行符
            String textToAppend = "\n\n" + content;

            Files.writeString(
                    filePath,
                    textToAppend,
                    StandardOpenOption.APPEND // 追加到文件末尾，保留原内容
            );
            return true;
        } catch (IOException e) {
            log.error("RAG Tool - 写入文件失败: {}", e.getMessage(), e);
            return false;
        }
    }
}