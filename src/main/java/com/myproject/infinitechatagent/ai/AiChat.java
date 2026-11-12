package com.myproject.infinitechatagent.ai;

import com.myproject.infinitechatagent.guardrail.SafeInputGuardrail;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;
import reactor.core.publisher.Flux;

@InputGuardrails({SafeInputGuardrail.class})
public interface AiChat {

//    @SystemMessage(fromResource = "system-prompt/chat-bot.txt")
//    String chat(@MemoryId String sessionId, @UserMessage String prompt);

    @SystemMessage(fromResource = "system-prompt/chat-bot.txt")
    String chat(@MemoryId Long sessionId, @UserMessage String prompt);

    @SystemMessage(fromResource = "system-prompt/chat-bot.txt")
    Flux<String> streamChat(@MemoryId Long sessionId, @UserMessage String prompt);
}
