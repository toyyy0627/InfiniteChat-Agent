package com.myproject.infinitechatagent.config;

import java.util.Arrays;
import java.util.Map;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.http.HttpMcpTransport;
import dev.langchain4j.mcp.client.transport.http.StreamableHttpMcpTransport;
import dev.langchain4j.mcp.client.transport.stdio.StdioMcpTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpToolConfig {

    @Value("${bigmodel.api-key}")
    private String apiKey;

    @Bean
    public McpToolProvider mcpToolProvider() {

//        McpTransport searchTransport = new HttpMcpTransport.Builder()
//                .sseUrl("https://open.bigmodel.cn/api/mcp/web_search/sse?Authorization=" + apiKey.trim()) // 去掉空格并 trim
//                .build();

        // 法一：http通信
        McpTransport searchTransport = new StreamableHttpMcpTransport.Builder()
                .url("https://open.bigmodel.cn/api/mcp/web_search/mcp")  // 用能响应的那个端点，去掉 ?Authorization
                .customHeaders(ctx -> Map.of("Authorization", apiKey.trim()))
                .logRequests(true)
                .logResponses(true)
                .build();

        McpClient searchClient = new DefaultMcpClient.Builder()
                .key("BigModelSearchMcpClient")
                .transport(searchTransport)
                .build();

        // 部署到服务器，服务器上没有uvx环境
//        // 法二：本地脚本
//        McpTransport timeTransport = new StdioMcpTransport.Builder()
//                .command(Arrays.asList("uvx", "mcp-server-time", "--local-timezone=Asia/Shanghai")) // MCP命令
//                .build();
//
//        McpClient timeClient = new DefaultMcpClient.Builder()
//                .key("timeClient")
//                .transport(timeTransport)
//                .build();

        return McpToolProvider.builder()
                .mcpClients(Arrays.asList(searchClient))
                .build();
    }
}