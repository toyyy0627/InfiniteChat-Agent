package com.myproject.infinitechatagent.rag.splitter;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.segment.TextSegment;

import java.util.ArrayList;
import java.util.List;


public class MarkdownHeadingSplitter implements DocumentSplitter {

    private final String headingPrefix;      // headingLevel=3 -> "###"
    private final int maxCharsPerSegment;    // <=0 表示不做兜底细分
    private final DocumentSplitter subSplitter;

    /**
     * @param headingLevel       按第几级标题切（3 表示 ###）
     * @param maxCharsPerSegment 单块最大字符数，超过则用 subSplitter 再切；<=0 表示不细分
     * @param subSplitter        兜底细分器，可为 null（配合 maxCharsPerSegment<=0）
     */
    public MarkdownHeadingSplitter(int headingLevel, int maxCharsPerSegment, DocumentSplitter subSplitter) {
        if (headingLevel < 1) {
            throw new IllegalArgumentException("headingLevel 必须 >= 1");
        }
        this.headingPrefix = "#".repeat(headingLevel);
        this.maxCharsPerSegment = maxCharsPerSegment;
        this.subSplitter = subSplitter;
    }

    @Override
    public List<TextSegment> split(Document document) {
        List<TextSegment> segments = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        // split("\n", -1) 保留末尾空段，避免丢内容；行尾的 \r 会在 strip() 时被清掉
        for (String line : document.text().split("\n", -1)) {
            if (isHeading(line) && current.length() > 0) {
                flush(current, document, segments);
                current.setLength(0);
            }
            current.append(line).append('\n');
        }
        flush(current, document, segments);
        return segments;
    }

    /** 恰好 headingPrefix 这么多个 # 开头（排除 #### 等更深级别）。允许行首少量空格。 */
    private boolean isHeading(String line) {
        String t = line.stripLeading();
        return t.startsWith(headingPrefix) && !t.startsWith(headingPrefix + "#");
    }

    private void flush(StringBuilder buf, Document document, List<TextSegment> out) {
        String content = buf.toString().strip();
        if (content.isEmpty()) {
            return;
        }
        if (maxCharsPerSegment > 0 && content.length() > maxCharsPerSegment && subSplitter != null) {
            // 复用文档元数据（含 file_name），让兜底细分出来的片段也带着来源信息
            out.addAll(subSplitter.split(Document.from(content, document.metadata())));
        } else {
            out.add(TextSegment.from(content, document.metadata()));
        }
    }
}