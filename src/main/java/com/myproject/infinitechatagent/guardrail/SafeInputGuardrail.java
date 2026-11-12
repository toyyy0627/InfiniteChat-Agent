package com.myproject.infinitechatagent.guardrail;

import dev.langchain4j.guardrail.GuardrailRequestParams;
import dev.langchain4j.guardrail.InputGuardrail;
import dev.langchain4j.guardrail.InputGuardrailRequest;
import dev.langchain4j.guardrail.InputGuardrailResult;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;
import java.util.Set;

public class SafeInputGuardrail implements InputGuardrail {


    private static final Set<String> SENSITIVE_WORDS = Set.of("死", "杀");

    // 关键：重写的是 validate(InputGuardrailRequest)，不是 validate(UserMessage)
    @Override
    public InputGuardrailResult validate(InputGuardrailRequest request) {
        String rawInput = extractRawUserInput(request);

        for (String keyword : SENSITIVE_WORDS) {
            if (!keyword.isEmpty() && rawInput.contains(keyword)) {
                return fatal("提问不能包含敏感词！！！！！"); // 抛出InputGuardrailException
            }
        }
        return success();
    }

    /** 还原 RAG 增强之前的用户原始输入 */
    private String extractRawUserInput(InputGuardrailRequest request) {
        GuardrailRequestParams params = request.requestParams(); // 拿入参
        String template = params.userMessageTemplate(); // 拿用户消息模板
        if (template == null) {
            return request.userMessage().singleText(); // 兜底
        }
        Map<String, Object> vars = params.variables() == null ? Map.of() : params.variables();
        return PromptTemplate.from(template).apply(vars).text(); // 返回：“请回答用户的问题：住宿费能报销多少？”
    }

}

//InputGuardrailRequest
//│
//├─ userMessage：当前待检查的消息
//│   "请回答用户的问题：住宿费能报销多少？
//│    参考资料：住宿费每晚最多报销500元。"
//│
//└─ requestParams：这条消息的相关信息
//    ├─ userMessageTemplate：
//    │   "请回答用户的问题：{{question}}"
//    │
//    ├─ variables：
//    │   question → "住宿费能报销多少？"
//    │
//    ├─ chatMemory：聊天记忆
//    │
//    └─ augmentationResult：RAG 增强结果