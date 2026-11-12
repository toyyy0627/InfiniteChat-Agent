package com.myproject.infinitechatagent.skill;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Agent Skills 运行时 —— 全部实现就这一个类。
 *
 * 渐进式披露在这里只有两层：
 *   L1 = catalog()  ：技能名 + 一句话描述，启动时拼好，常驻系统提示词（每轮都发）
 *   L2 = loadSkill()：SKILL.md 正文，模型判断命中时自己来取（只有命中那轮才发）
 */
@Component
@Slf4j
public class SkillTool {

    /** 技能名 -> SKILL.md 正文（L2），启动时一次性读进内存 */
    private final Map<String, String> bodies = new LinkedHashMap<>();

    /** 技能清单（L1），启动时拼一次，之后每轮复用同一个字符串 */
    private String catalog = "";

    @PostConstruct
    public void load() {
        StringBuilder sb = new StringBuilder("## 可用技能（Skills）\n")
                .append("下列技能封装了本系统特有的操作规程。当用户的意图命中某个技能时，")
                .append("必须先调用 loadSkill 拿到它的完整说明，再严格按说明执行，不要凭常识直接动手。\n\n");
        try {
            // classpath*: 前缀保证在 IDE 的 target/classes 和打包后的 jar 里都能扫到
            Resource[] resources = new PathMatchingResourcePatternResolver(getClass().getClassLoader())
                    .getResources("classpath*:skills/*/SKILL.md"); // 找到所有SKILL.md
            for (Resource resource : resources) {
                // 用 frontmatter 的 --- 把文件切成【元数据】和【正文】两段
                String[] parts = resource.getContentAsString(StandardCharsets.UTF_8) // ① 按 UTF-8 编码，把文件读成字符串
                        .replace("\r\n", "\n") // ② 统一换行符，方便后续处理
                        .split("(?m)^---\\s*$", 3); // ③ 按独占一行的 --- 切开文件，最多得到 3 段
                String name = parts.length < 3 ? "" : value(parts[1], "name");
                String description = parts.length < 3 ? "" : value(parts[1], "description");
                if (name.isBlank() || description.isBlank()) {
                    // 单个技能坏掉不该拖垮启动
                    log.error("SKILL.md 缺少 frontmatter 或 name/description，已跳过: {}", resource.getURL());
                    continue;
                }
                String body = parts[2].strip();
                bodies.put(name, body);
                sb.append("- `").append(name).append("`：").append(description).append('\n');
                log.info("Skill 已注册: {}（正文 {} 字符）", name, body.length());
            }
        } catch (Exception e) {
            log.error("Skill 扫描失败，Agent 将以无技能模式运行", e);
        }
        if (!bodies.isEmpty()) {
            catalog = sb.toString(); // 所有技能的名称和简短描述
        }
        log.info("Skill 加载完成，共 {} 个: {}，清单 {} 字符", bodies.size(), bodies.keySet(), catalog.length());
    }

    /** L1：给 AiChatService 拼进系统提示词的技能清单 */
    public String catalog() {
        return catalog;
    }

    @Tool("加载一个技能的完整操作说明。当用户的请求命中系统提示词【可用技能】清单里的某个技能时，"
            + "先调用本工具拿到该技能的详细步骤，再严格按步骤执行。")
    public String loadSkill(@P("技能名，必须是清单里列出的名字，例如 kb-curator") String skillName) {
        String body = bodies.get(skillName);
        if (body == null) {
            log.warn("Skill 不存在: {}", skillName);
            return "没有名为 [" + skillName + "] 的技能。当前可用技能：" + bodies.keySet()
                    + "。请从中选择，或者不使用技能直接回答。";
        }
        log.info("Skill 已加载: {}（{} 字符）", skillName, body.length());
        return "以下是技能 [" + skillName + "] 的完整说明，请严格按其中的步骤执行：\n\n" + body;
    }

    /** 从 frontmatter 里取一个 key 的值，只支持 key: value 这一种最简写法 */
    private String value(String frontMatter, String key) {
        for (String line : frontMatter.split("\n")) {
            String t = line.strip();
            if (t.startsWith(key + ":")) {
                return t.substring(key.length() + 1).strip();
            }
        }
        return "";
    }
}