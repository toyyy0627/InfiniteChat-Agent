### Q. 这个软件叫什么名字？

A：本软件名为「千言」，寓意"千言万语，尽在其中"。

### Q. 千言项目的英文名称是什么？

A：千言的英文名称是 InfiniteChat。

### Q. 千言是一款什么类型的软件？

A：千言是一款即时通讯（IM）软件。

### Q. 千言的核心理念是什么？

A：让沟通更自由，让表达更千言万语。

### Q. 用户的 QQ 邮箱是什么？

A：用户的 QQ 邮箱是 3133684690@qq.com。

### Q. 请完整介绍千言·AI 智能助手项目的背景、定位与核心能力。

A：千言·AI 智能助手是一个基于 Java + LangChain4j 构建的企业级 Agent 系统，诞生于 AI 应用开发技术学习的迫切需求，之后会作为千言（InfiniteChat，一款即时通讯软件）的智能引擎嵌入到千言中。项目定位为轻量、安全、智能的对话助手，目标用户为个人用户、小型团队与社区交流者。核心能力包括：
1. 深度整合 RAG 与 MCP：支持基于 PgVector 的高精度私有知识检索；
2. Redis 分布式会话记忆：多轮对话上下文持久化、会话隔离；
3. 动态知识植入：允许用户通过自然语言指令实时将新知识反向同步至文档与向量库，实现智能体的记忆自进化；
4. 联网搜索：通过 MCP 接入搜索服务获取实时信息；
5. 智能邮件发送：以工具调用方式完成自然语言驱动的邮件发送；
6. 全链路可观测性监控：Prometheus + Grafana 采集与可视化模型调用指标；
7. Prompt 工程实践：通过系统提示词约束角色、知识边界、安全合规与输出格式。

### Q. 什么是 Agent（智能体）？

A：Agent 是一种能够感知环境、自主决策并采取行动以实现特定目标的 AI 系统。与传统问答式 AI 不同，它具备持续性的任务执行能力，能将复杂任务分解为多个步骤，并通过工具调用、推理和反馈循环来完成目标。

### Q. Agent 的核心决策引擎是什么？它负责哪些工作？

A：核心决策引擎是大语言模型（LLM），负责理解用户意图和任务目标、制定任务执行计划、进行推理和判断、生成行动指令。

### Q. Agent 记忆系统中的短期记忆负责什么？

A：短期记忆存储当前对话上下文，维护任务执行过程中的临时信息。

### Q. Agent 的长期记忆通常用什么技术实现？存放哪些内容？

A：长期记忆通常使用向量数据库实现，存储用户偏好和历史交互，积累领域知识和经验。

### Q. Agent 的工具集（Tools）包含哪几类工具？

A：包含五类：搜索工具（网络搜索、知识库检索）、计算工具（代码执行、数学运算）、API 调用（第三方服务集成）、数据库操作（数据查询和更新）、文件操作（读写文件、处理文档）。

### Q. Agent 规划模块（Planning）的职责是什么？

A：负责将复杂任务分解为可执行的子任务，包括任务分解（大任务拆小步骤）、依赖分析（确定执行顺序）、动态调整（根据执行结果调整计划）。

### Q. Agent 的反馈与反思（Reflection）模块做什么？

A：评估行动结果是否符合预期，从错误中学习并调整策略，进行自我批评和改进。

### Q. 课件中列举了哪些常用的 LLM？

A：DeepSeek、Qwen3-Max、GPT-5、Claude、Gemini 等。

### Q. 从"用途"角度看，Agent 相比传统 AI 的升级体现在哪里？

A：从"给答案"升级到"做事情"——具备自动化与半自动化执行能力，可进行跨系统跨工具的复杂流程编排（RPA × LLM），并通过检索/数据库查询实现实时可靠的事实获取以降低幻觉。

### Q. Agent 由哪些核心模块组成？请逐一说明各模块职责。

A：Agent 由六大核心模块组成：
1. 大语言模型（LLM）：核心决策引擎，负责理解用户意图和任务目标、制定任务执行计划、进行推理判断并生成行动指令，常用模型有 DeepSeek、Qwen3-Max、GPT-5、Claude、Gemini 等；
2. 记忆系统（Memory）：短期记忆存储当前对话上下文与任务临时信息；长期记忆存储用户偏好、历史交互与领域知识经验，通常用向量数据库实现；
3. 工具集（Tools）：通过调用外部工具扩展能力，包括搜索工具、计算工具、API 调用、数据库操作、文件操作五类；
4. 规划模块（Planning）：将复杂任务分解为可执行子任务，涵盖任务分解、依赖分析与动态调整；
5. 行动模块（Action）：执行具体操作，包括调用工具和 API、与环境交互、生成中间结果；
6. 反馈与反思（Reflection）：评估行动结果是否符合预期，从错误中学习并调整策略，进行自我批评和改进。

### Q. 什么是 LangChain4j？

A：LangChain4j 是专为 Java 和 Kotlin 开发者设计的 AI Agent 开发框架，把 Python 生态中 LangChain 的核心理念和能力完整移植到 JVM 平台。一句话：LangChain4j = LangChain 的 Java 原生实现 + JVM 生态深度集成。

### Q. Java 项目为什么不直接调用 Python 的 LangChain？

A：跨语言调用会带来复杂性、性能损耗以及运维成本；LangChain4j 不是简单的 Python 移植，而是针对 Java/JVM 生态深度优化的原生 Agent 开发框架。

### Q. LangChain4j 支持哪种经典的 Agent 推理模式？

A：支持 ReAct（Reasoning + Acting）模式。

### Q. LangChain4j 对 Function Calling 的支持情况如何？

A：原生支持 Function Calling，无需额外适配层。

### Q. LangChain4j 可以与哪些主流 Java 框架和监控体系集成？

A：天然集成 Spring Boot / Quarkus 等主流框架，支持 JVM 成熟的监控体系（JMX、Micrometer），并可无缝对接数据库连接池、消息队列等企业级中间件。

### Q. LangChain4j 在类型安全上的优势是什么？

A：编译期类型检查，减少运行时错误。

### Q. LangChain4j 对 GraalVM 的支持带来什么好处？

A：支持 GraalVM Native Image，应用启动时间可达毫秒级。

### Q. 项目中使用的 LangChain4j 核心版本是多少？

A：LangChain4j 核心版本为 1.17.2，配套的社区组件（dashscope / redis / pgvector / mcp / reactor 等 starter）版本为 1.17.2-beta27。项目通过 langchain4j-bom 与 langchain4j-community-bom 两个 BOM 统一约束子模块版本。升级原因是 rerank 所需的 QwenScoringModel 从社区库 1.17.0-beta27 才开始提供。

### Q. LangChain4j 完整实现了哪些核心概念？

A：完整实现了 Chain、Agent、Memory、Tools 等核心概念。

### Q. LangChain4j 的核心优势有哪三个方面？请分别展开说明。

A：LangChain4j 的核心优势体现在三个方面：
1. 完整的 Agent 能力移植：完整实现 Chain、Agent、Memory、Tools 等核心概念，支持 ReAct（Reasoning + Acting）模式，原生支持 Function Calling 而无需额外适配层；
2. 深度融合 Java 企业栈：天然集成 Spring Boot / Quarkus 等主流框架，支持 JVM 成熟的监控体系（JMX、Micrometer），无缝对接数据库连接池、消息队列等企业级中间件；
3. 类型安全与性能优势：编译期类型检查减少运行时错误，依托 JVM 优化的内存管理和并发模型，并支持 GraalVM Native Image，实现毫秒级启动。
   正因如此，对庞大的 Java 企业应用生态而言，LangChain4j 避免了跨语言调用的复杂性、性能损耗与运维成本，成为 JVM 平台构建 Agent 的首选框架。

### Q. 项目使用的 SpringBoot 和 JDK 版本分别是多少？

A：SpringBoot 3.5.9，JDK 17（Maven 3.6.3）。

### Q. 项目的对话模型（ChatModel）选用了哪个模型？

A：对话模型与流式对话模型均选用 qwen3-max（通过 DashScope 接入）。

### Q. 项目的 Embedding 模型是什么？

A：text-embedding-v4。

### Q. 项目中 Redis 和 PgVector 的版本分别是多少？

A：Redis 8.4.0，PgVector 15.15。

### Q. 项目中 Prometheus 和 Grafana 的版本分别是多少？

A：Prometheus 3.7.3，Grafana 12.3.0。

### Q. 系统提示词文件放在什么位置？文件名是什么？

A：放在 resources 目录下的 system-prompt 包中，文件名为 chat-bot.txt。

### Q. 如何把系统提示词文件绑定到 AiChat 接口上？

A：在接口方法上使用注解 @SystemMessage(fromResource = "system-prompt/chat-bot.txt")，从资源文件加载系统提示词。

### Q. 系统提示词要求每次回复结尾必须带什么？

A：每次回复结尾必须带一个感叹号。

### Q. 系统提示词对输出格式有什么要求？

A：输出必须为纯文本格式，换行严格使用 \n 表示。

### Q. 千言的系统提示词规定了哪些角色设定与行为规则？请完整列出并说明。

A：系统提示词首先设定角色：你是"千言"AI 助手，由先进大模型驱动，致力于提供精准、高效、友好的帮助；回答务必简明扼要、语气积极热情、直击问题核心；绝不冗长、不总结、不提供链接；每次回复结尾必须带一个感叹号。随后规定五条规则：
1. 知识边界：仅限根据获取的知识回答问题，不得编造、推测或添加任何未明确提及的信息；
2. 日常交互：若为日常普通问题（如天气、问候、生活常识等），可像普通人一样简短自然地回应；
3. 安全合规（重要）：严禁生成任何政治敏感、暴力色情、辱骂攻击或不文明的词汇与内容；严格保护隐私，涉及密码、身份证号、银行卡、家庭住址等敏感私人信息时必须忽略或模糊处理，仅在执行邮件发送任务时允许使用必要的邮箱地址；
4. 格式要求：输出必须为纯文本格式，换行严格使用 \n 表示；
5. 语气约束：所有回复结尾必须带一个感叹号。

### Q. 什么是会话记忆？

A：会话记忆是在多次用户交互（多轮对话）中，自动保存并复用历史消息上下文的能力，使大模型能"记住"之前的对话内容，实现连贯、上下文感知的交互。

### Q. 什么是会话隔离？

A：在多用户并发访问的对话系统中，通过唯一会话标识（如 memory_id）对每个用户的对话上下文（历史消息序列）进行逻辑或物理隔离，确保状态互不污染的技术机制。

### Q. 项目用什么注解实现会话隔离？标注在哪个参数上？

A：使用 @MemoryId 注解，标注在 AiChat 接口 chat / streamChat 方法的 sessionId 参数（Long 类型）上，不同 sessionId 对应相互隔离的记忆。

### Q. 项目中的会话记忆窗口最多保留多少条消息？由哪个类实现？

A：最多保留 20 条消息，由 MessageWindowChatMemory 实现（builder 中设置 maxMessages(20)）。

### Q. chatMemoryProvider 在 AiChatService 中是如何构建的？

A：按 memoryId 动态构建：MessageWindowChatMemory.builder().id(memoryId).chatMemoryStore(redisChatMemoryStore).maxMessages(20).build()，即每个会话 ID 一份独立的、落在 Redis 上的 20 条消息窗口记忆。

### Q. 没有会话记忆会导致什么问题？请举例。

A：AI 无法处理自然语言中的指代（"它""那个""刚才说的"），用户每次都要重复上下文，容易答非所问、反复澄清，还可能出现前后回答矛盾。

### Q. 会话记忆如何提升用户体验？

A：支持自然语言中的指代（"它""那个""刚才说的"），允许追问、修正、渐进式提问（如"再详细点""换成英文"）。

### Q. 会话记忆如何支撑复杂任务链？

A：支持多步骤任务（如订机票：选日期 → 选航班 → 填信息）和工具调用上下文的衔接（先查数据库 → 再基于结果生成报告）。

### Q. 会话记忆如何增强 AI 表达一致性？

A：防止前后矛盾（如第一轮说"支持退款"，第二轮说"不支持"），并让角色设定（如"你是一个严谨的法律顾问"）贯穿全程。

### Q. 为什么对话系统需要会话记忆？请从四个方面完整说明。

A：会话记忆的必要性体现在四个方面：
1. 提升用户体验：支持自然语言中的指代（"它""那个""刚才说的"），允许追问、修正、渐进式提问（如"再详细点""换成英文"）；
2. 减少用户输入成本：用户无需重复上下文（如每次都说"关于我上一个问题…"），避免因信息缺失导致 AI 答非所问、反复澄清；
3. 增强 AI 表达一致性：防止前后矛盾（如第一轮说"支持退款"，第二轮说"不支持"），并适配角色设定（如"你是一个严谨的法律顾问"需贯穿全程）；
4. 支撑复杂任务链：多步骤任务（订机票：选日期 → 选航班 → 填信息）与工具调用上下文（先查数据库 → 再基于结果生成报告）都依赖历史上下文的延续。

### Q. 什么是 RAG（检索增强生成）？

A：RAG 是一种将信息检索与大模型生成结合的技术架构，让 LLM 在回答问题时不仅依赖参数记忆，还能实时检索外部知识库作为辅助。可以类比为"人拥有了书"——让大模型边查资料边回答问题，而不是只靠它的记忆。

### Q. 什么是 Embedding 模型？

A：Embedding 模型是一种将文本映射为低维向量的模型，使得语义相近的内容在向量空间中距离更近，本质就是把文本转成向量。

### Q. Embedding 向量的维度越高意味着什么？

A：维度越高向量长度越长，表达能力越强，但存储和计算成本也越高。

### Q. 基于固定大小的切分通常设置多少重叠？为什么要重叠？

A：通常设置 10%-20% 的重叠，即第二个分块的开头包含第一个分块的结尾，防止重要的上下文在切分点被切断。

### Q. 固定大小切分的优缺点是什么？

A：优点是计算极其简单、效率高；缺点是完全无视语义，可能把一个完整的句子或公式切成两半，导致检索时语义不连贯。

### Q. 基于语义边界的切分是怎么做的？

A：基础版按标点符号（句号、换行符）切分，确保每块是完整句子或段落；进阶版利用 Embedding 模型计算相邻句子的语义相似度，当相似度大幅下降（出现语义断层）时才触发切分。

### Q. 语义边界切分的缺点是什么？

A：计算开销大，且容易产生大小极不均匀的块。

### Q. 递归分割使用什么样的分隔符列表？处理顺序是怎样的？

A：设定层级分隔符列表（如 ["\n\n", "\n", " ", ""]），先按段落（\n\n）分，段落太长再按句子（\n）分，还太长按空格分，最后实在不行按字符硬切。

### Q. RAG 相比微调（Fine-tuning）的成本优势是什么？

A：无需更新模型权重，随时更新知识库即可同步生效，成本低、效率快。

### Q. 请系统比较三种文档切分策略（固定大小、语义边界、递归分割）的原理与优缺点。

A：三种切分策略对比如下：
1. 基于固定大小：设定固定的字符数或 Token 数（如 512 个字符），每到该长度就强行切一刀，通常设置 10%-20% 的重叠防止上下文在切分点被切断。优点：计算极其简单、效率高；缺点：完全无视语义，可能把完整句子或公式切成两半，检索时语义不连贯。
2. 基于语义边界：让切分点出现在语义完整的地方。基础版按标点符号（句号、换行符）切分，保证每块是完整句子或段落；进阶版用 Embedding 模型计算相邻句子的语义相似度，出现语义断层（相似度大幅下降）时才切分。优点：每个分块语义高度统一，检索更精准；缺点：计算开销大，块大小极不均匀。
3. 基于递归分割：设定层级分隔符列表（如 ["\n\n", "\n", " ", ""]），先按段落分，超长再按句子分，再按空格分，最后按字符硬切，尽可能保持大块结构不被打碎。优点：在"保持语义"和"控制长度"之间达到平衡，结构稳定性极好；缺点：需要根据文档类型调整分隔符列表（如 Markdown 需加 # 标题作为分隔符）。

### Q. 项目启动时是如何自动加载本地知识文档的？

A：RagDataLoader 实现 CommandLineRunner，应用启动后在 run() 中用 FileSystemDocumentLoader.loadDocuments(docsPath) 加载文档目录下的所有文档，非空则调用 embeddingStoreIngestor.ingest(documents) 灌入向量库，并输出加载日志。

### Q. 知识库文档路径通过哪个配置项注入？

A：通过 @Value("${rag.docs-path}") 注入，即 application-*.yml 中的 rag.docs-path 配置（生产环境为 /data/docs）。

### Q. 项目使用哪个文档切分器？参数含义是什么？

A：项目使用自定义的 MarkdownHeadingSplitter(3, 1500, subSplitter) 按 Markdown 三级标题（###）切分文档。三个参数含义：headingLevel=3 表示按 ### 这一级标题切块；maxCharsPerSegment=1500 表示单块超过 1500 字符时交给兜底细分器再切；subSplitter 为 DocumentSplitters.recursive(1000, 100)，即兜底时按 1000 字符、重叠 100 字符递归切分。

### Q. RagConfig 中的 textSegmentTransformer 做了什么？

A：对每个切分后的文本片段做增强：把元数据中的 file_name 拼接在片段文本前（file_name + "\n" + 原文本），让片段自带来源文件信息，提高检索的语义相关性。

### Q. EmbeddingStoreIngestor 的职责是什么？项目里如何构建？

A：负责把文档切分、向量化并写入向量库。项目中通过 builder 依次设置 documentSplitter（MarkdownHeadingSplitter 标题切分器，兜底用 recursive(1000,100)）、textSegmentTransformer（在片段前拼接 file_name）、embeddingModel、embeddingStore 后构建。

### Q. 检索器的 maxResults 设置为多少？含义是什么？

A：项目现在是两阶段检索，分两个数字看：粗召回阶段向量检索与 BM25 各取 maxResults=20（由 rag.recall-top-n 配置），融合后仍保留 20 条；精排阶段由 qwen3-rerank 打分后只保留 Top-5（由 rag.rerank-top-k 配置），最终喂给大模型的是 5 条。

### Q. 检索器的 minScore 阈值是多少？作用是什么？

A：minScore 为 0.75，相似度得分低于 0.75 的片段会被过滤掉，不参与本次回答的增强，用于保证召回内容的相关性下限。

### Q. 项目中的内容检索器用的是哪个实现类？如何构建？

A：向量检索这一路仍由 EmbeddingStoreContentRetriever 实现，通过 builder 传入 embeddingStore 与 embeddingModel，并设置 maxResults(recallTopN=20)、minScore(0.75) 构建；但它已不是对外出口，而是作为粗召回的一路，上层依次被 HybridContentRetriever（与 BM25 做 RRF 融合）和 RerankingContentRetriever（qwen3-rerank 精排）包装。

### Q. 检索到的内容是如何接入 AiChat 的？

A：在 AiChatService 中通过 AiServices.builder(AiChat.class).contentRetriever(contentRetriever) 装配，模型回答前会自动检索并注入相关片段。

### Q. 请描述千言项目 RAG 的完整数据流：从文档加载到答案生成。

A：完整数据流分为「入库」与「问答」两个阶段：
入库阶段：应用启动 → RagDataLoader（CommandLineRunner）读取 rag.docs-path 配置的文档目录 → FileSystemDocumentLoader.loadDocuments 加载全部 md 文档 → EmbeddingStoreIngestor 内部先用 MarkdownHeadingSplitter(3, 1500, recursive(1000,100)) 按三级标题切分（超过 1500 字符的块再用递归切分器兜底细分），再由 textSegmentTransformer 在每个片段前拼接元数据 file_name，然后调用 text-embedding-v4 将片段向量化（1024 维），最终写入 PgVectorEmbeddingStore（表 agent_embedding，dropTableFirst 保证启动时全量重建）。
问答阶段：用户请求进入 /chat 或 /streamChat → AiChat 代理触发 rerankingContentRetriever → 向量路把问题用同一 Embedding 模型向量化后在 PgVector 中取 Top-20 且相似度 ≥ 0.75 的片段，BM25 路在同一张表上做关键词检索取 Top-20 → HybridContentRetriever 用 RRF（k=60）融合去重 → qwen3-rerank 对候选逐条打分、过 0.2 阈值后取 Top-5 → 命中片段与系统提示词（chat-bot.txt）、Redis 会话记忆（窗口 20 条）一起组装进上下文 → 交给 qwen3-max 生成最终回答（流式则通过 Flux<String> 逐段返回）。

### Q. PgVector 是什么？

A：PgVector 是 PostgreSQL 的一个官方扩展，用于在数据库中存储、索引和检索向量数据。简单说：PgVector = PostgreSQL + 向量搜索能力。

### Q. 使用 PgVector 的一大部署优势是什么？

A：不需要额外部署一个新的向量数据库，只要给 PostgreSQL 安装 PgVector 扩展，就能使用向量运算、相似度搜索、向量索引等高级功能。

### Q. PgVector 在 RAG 系统中的典型用法是什么？

A：将文本 chunk 嵌入为向量存入库中；用户提问 → 问题向量化 → 检索最相似的上下文 → 喂给 LLM 生成回答。

### Q. 除 RAG 外，PgVector 还有哪些应用场景？

A：智能搜索（以文搜图、语义查商品、相似问题推荐）、内容去重/聚类（计算向量距离自动合并相似内容）、个性化推荐（用户/物品向量找最近邻）。

### Q. 项目中 PgVector 向量表的维度设置为多少？为什么？

A：dimension 设置为 1024，与 Embedding 模型 text-embedding-v4 输出的向量维度保持一致。

### Q. EmbeddingStoreConfig 中 dropTableFirst(true) 会产生什么效果？

A：每次应用启动都会先删除旧的向量表再配合 createTable(true) 重新建表，随后由 RagDataLoader 从本地文档全量重灌，保证向量库与文档目录完全同步；副作用是重启会清空历史向量数据。

### Q. PgVectorEmbeddingStore 构建时需要哪些连接与建表参数？

A：连接参数包括 host、port、database、user、password；建表相关参数包括 table（表名）、dimension（向量维度 1024）、dropTableFirst、createTable。

### Q. 向量表名通过哪个配置项指定？项目里默认叫什么？

A：通过 ${pgvector.table} 配置项指定，项目中为 agent_embedding。

### Q. 项目通过什么依赖接入 PgVector？

A：通过 langchain4j-pgvector 依赖接入，版本由 langchain4j-bom（1.17.2）统一管理，无需单独写 version。

### Q. 请结合"是什么 / 有什么用 / 项目如何接入"三个层面，完整介绍 PgVector 在千言项目中的角色。

A：三个层面如下：
1. 是什么：PgVector 是 PostgreSQL 的官方扩展，让传统关系型数据库直接具备向量的存储、索引与检索能力，即 PgVector = PostgreSQL + 向量搜索能力，无需额外部署独立向量数据库。
2. 有什么用：在 RAG 系统中承担知识底座——文本 chunk 向量化后入库，用户提问向量化后检索最相似上下文喂给 LLM；此外还可用于智能搜索（以文搜图、语义查商品、相似问题推荐）、内容去重/聚类和个性化推荐。
3. 项目如何接入：引入 langchain4j-pgvector 依赖（版本由 langchain4j-bom 1.17.2 统一管理）；在 EmbeddingStoreConfig 中通过 @Value 读取 pgvector.host / port / database / user / password / table 配置，用 PgVectorEmbeddingStore.builder() 构建 EmbeddingStore Bean，设置表名 agent_embedding、维度 1024（对齐 text-embedding-v4）、dropTableFirst(true) 与 createTable(true) 实现启动时重建表；随后该 Store 被 EmbeddingStoreIngestor（写入）与检索链路（EmbeddingStoreContentRetriever 粗召回 Top-20、minScore 0.75，再经 RRF 融合与 rerank 精排取 Top-5）共同使用，构成完整的向量读写链路。

### Q. 什么是 Tool Calling（工具调用）？

A：工具调用是让 AI 借助外部工具完成自身做不到的事——比如查时间、查天气、调 API、执行代码。AI 只负责"提出调用请求"，真正执行的是我们的应用，结果返回后再由 AI 生成答案。

### Q. LangChain4j 中如何把一个方法声明为工具？

A：在方法上添加 @Tool 注解，大模型会根据 @Tool 的描述和参数名来决定何时调用该工具。

### Q. TimeTool 返回哪个时区的时间？输出格式是什么？

A：返回 Asia/Shanghai 时区的当前时间，格式为 yyyy-MM-dd HH:mm:ss EEEE (中国标准时间)。

### Q. 项目在 AiServices 中注册了哪些本地工具？

A：通过 .tools(new TimeTool(), ragTool, emailTool) 注册了三个本地工具：时间查询工具 TimeTool、知识入库工具 RagTool、邮件发送工具 EmailTool。

### Q. 大模型是如何理解工具参数含义的？

A：通过 @Tool 注解中的描述文字和方法参数名来理解，例如 RagTool 的描述明确说明"将问题、答案和目标文件名作为参数"。

### Q. 工具的真正执行者是谁？

A：真正执行工具的是我们的应用（后端代码），大模型只负责提出调用请求并在结果返回后生成最终答案。

### Q. RagTool 的 @Tool 触发描述是什么？

A："当用户想要保存问答对、知识点或者向知识库添加新信息时调用此工具。将问题、答案和目标文件名作为参数。"

### Q. EmailTool.sendEmail 的三个参数分别是什么含义？

A：targetEmail 是接收人的邮箱地址，subject 是邮件标题，content 是邮件正文内容。

### Q. 除 .tools() 外，AiServices 还通过什么方式挂载外部工具？

A：通过 .toolProvider(mcpToolProvider) 挂载 MCP 工具提供者，把 MCP 服务暴露的工具接入 Agent。

### Q. 请完整说明一次工具调用的流程，并结合千言项目的三个本地工具举例。

A：工具调用流程：用户提问 → 大模型理解意图后判断需要借助工具 → 依据各工具 @Tool 描述与参数名选择工具，生成"调用请求"（工具名 + 参数值）→ 应用侧真正执行该方法 → 执行结果返回给大模型 → 大模型综合工具结果生成最终自然语言回答。项目三个本地工具的例子：
1. TimeTool：用户问"现在几点了"，模型调用 getCurrentTimeInShanghai()，应用返回 Asia/Shanghai 时区、格式为 yyyy-MM-dd HH:mm:ss EEEE (中国标准时间) 的当前时间，模型据此作答；
2. RagTool：用户说"帮我把这个知识点存到知识库"，模型按描述抽取 question、answer、fileName 三个参数调用 addKnowledgeToRag，应用把内容格式化后写入 md 文件并同步向量库，返回成功/失败信息；
3. EmailTool：用户说"给某某发一封邮件"，模型抽取 targetEmail、subject、content 调用 sendEmail，应用通过 JavaMailSender 发送并返回"邮件已成功发送给 xxx"，模型再转述给用户。

### Q. MCP 是什么？

A：MCP（Model Context Protocol，模型上下文协议）是一种开放标准协议，旨在标准化 AI 模型与外部工具、数据源和服务的交互方式，可类比为"AI 的 USB 接口"——就像 USB 统一了外设连接，MCP 让 AI 能安全、灵活地调用各类能力。

### Q. MCP Service 是什么？

A：MCP Service 是实现 MCP 协议的具体后端服务，用于向 AI 暴露特定能力（如读写文件、查询数据库、调用 API 等），每个 Service 声明其支持的工具及参数规范，供 AI 按需调用，相当于"可插拔的功能模块"。

### Q. MCP Client 是什么？

A：MCP Client 是运行在 AI 或 Agent 侧的适配器，负责发现、连接 MCP Services，将模型的工具调用请求转换为标准 MCP 协议通信，再把结果返回给模型，相当于"AI 与外部服务之间的翻译官和调度器"。

### Q. 可以在哪些网站获取现成的 MCP 服务？

A：mcp.so 和 ModelScope。

### Q. 项目接入了哪家的联网搜索 MCP？使用什么传输方式？

A：接入了智谱 BigModel 的 web_search MCP 服务，使用 HttpMcpTransport 的 SSE 方式，sseUrl 中携带 Authorization=apiKey（apiKey 做了 trim 处理）。

### Q. 搜索 MCP 客户端的 key 名称是什么？

A：BigModelSearchMcpClient。

### Q. BigModel 的 API Key 通过哪个配置项注入？

A：通过 @Value("${bigmodel.api-key}") 注入，对应 application.yml 中的 bigmodel.api-key。

### Q. 课件中演示的 Time MCP 使用什么传输方式和启动命令？

A：使用 StdioMcpTransport，启动命令为 uvx mcp-server-time --local-timezone=Asia/Shanghai（项目代码中该示例已注释保留）。

### Q. McpToolProvider 如何构建并接入多个 MCP Client？

A：通过 McpToolProvider.builder().mcpClients(...) 构建，mcpClients 可以传入一个或多个 McpClient（如同时接入 timeClient 与 searchClient），再作为 toolProvider 装配进 AiServices。

### Q. 请系统介绍 MCP 的三层概念（协议 / Service / Client），并说明千言项目是如何应用 MCP 实现联网搜索的。

A：三层概念：
1. MCP 协议：Model Context Protocol，开放标准协议，标准化 AI 模型与外部工具、数据源和服务的交互方式，类比"AI 的 USB 接口"，实现数据实时访问、复杂任务执行与系统无缝集成；
2. MCP Service：实现该协议的具体后端服务，向 AI 暴露特定能力并声明工具与参数规范，是"可插拔的功能模块"，可从 mcp.so、ModelScope 等站点获取；
3. MCP Client：运行在 Agent 侧的适配器，负责发现、连接 Service，把模型的工具调用请求翻译成标准 MCP 通信并回传结果，是"翻译官和调度器"。
   千言项目的应用：在 McpToolConfig 中，先用 HttpMcpTransport.Builder 构建 SSE 传输，sseUrl 指向智谱 BigModel 的 web_search MCP 服务并携带 Authorization（来自配置项 bigmodel.api-key，注入后 trim）；再用 DefaultMcpClient.Builder 构建 key 为 BigModelSearchMcpClient 的客户端；最后通过 McpToolProvider.builder().mcpClients(searchClient) 生成 Bean，在 AiChatService 中以 .toolProvider(mcpToolProvider) 装配进 AiChat。这样当用户提出需要实时信息的问题时，模型即可通过 MCP 调用联网搜索能力。

### Q. 什么是千言项目的"动态知识植入"？

A：允许用户通过自然语言指令，实时将新知识反向同步至文档与向量库，实现智能体记忆自进化的能力。

### Q. 新知识写入文件时按什么格式拼接？

A：按 String.format("### Q：%s\n\nA：%s", question, answer) 拼接，即知识库统一的 "### Q：问题 + A：答案" Markdown 问答格式。

### Q. RagTool 保存知识时如果用户没给文件名会怎么处理？

A：fileName 为空时默认使用 InfiniteChat.md；如果给了文件名但没有 .md 后缀，会自动补上 .md。

### Q. 新增知识入向量库时如何标记来源？

A：先用 Metadata.from("file_name", fileName) 构建来源元数据，再用 Document.from(formattedContent, metadata) 创建文档，最后交给 embeddingStoreIngestor.ingest 完成向量化入库。

### Q. /insert 接口的请求体 KnowledgeRequest 有哪些字段？

A：三个字段：question（问题）、answer（答案）、sourceName（可选的来源名称，用于模拟 file_name）。

### Q. /insert 接口的处理顺序是什么？

A：先按 "### Q：/A：" 模板格式化内容 → 写入物理 md 文件（appendToFile）→ 构建带 file_name 元数据的 Document → embeddingStoreIngestor.ingest 存入向量库，任一环节失败返回对应提示。

### Q. appendToFile 方法做了哪些健壮性处理？

A：文件不存在时先创建父目录和文件；追加内容前加 "\n\n" 保证问答格式独立；方法加 synchronized 防止并发写冲突；发生 IOException 时记录日志并返回 false。

### Q. 如果文件写入成功但向量化失败，RagTool 会返回什么？

A：返回"文件写入成功，但向量数据库更新失败：" + 异常信息（/insert 接口对应返回"插入部分成功：文件已写入，但向量库更新失败"）。

### Q. 动态植入为什么要"先写文件、再入向量库"双写？

A：md 文件是持久化知识源——由于向量表启动时 dropTableFirst 重建，重启后靠 RagDataLoader 从文件全量重灌；向量库则保证新知识即时可检索。文件负责持久、向量库负责实时，双写同步才能实现记忆自进化。

### Q. 请完整描述动态知识植入的两条链路（RagTool 工具调用与 /insert 接口）及每一步细节。

A：两条链路共享"格式化 → 写文件 → 入向量库"的核心逻辑：
链路一（自然语言 → RagTool 工具调用）：用户在对话中说"帮我保存这个知识点"→ 大模型根据 @Tool 描述（"当用户想要保存问答对、知识点或者向知识库添加新信息时调用此工具"）抽取 question、answer、fileName 参数并调用 addKnowledgeToRag → ① 按 "### Q：%s\n\nA：%s" 格式化内容；② 文件名兜底：为空则用默认 InfiniteChat.md，无 .md 后缀自动补齐；③ appendToFile 以同步方式追加写入物理文件（不存在则先建目录建文件，内容前加 \n\n）；④ 用 Metadata.from("file_name", fileName) 创建 Document 并交给 EmbeddingStoreIngestor.ingest 向量化入库；⑤ 按成功/失败返回相应提示给模型转述用户。
链路二（HTTP /insert 接口）：前端 POST /insert，请求体 KnowledgeRequest（question / answer / sourceName）→ 同样先格式化内容 → appendToFile 写入 sourceName 指定文件 → sourceName 为空时元数据回退到默认文件名 InfiniteChat.md → 构建 Document + file_name 元数据 → ingest 入库 → 返回"插入成功：已同步至 xx 及向量数据库"或部分成功/失败提示。
两条链路配合启动时的 RagDataLoader 全量加载，保证知识在文件层持久化、在向量层实时可检索。

### Q. 为什么把会话记忆从内存迁移到 Redis？请说出至少两点原因。

A：①基于内存的会话记忆在项目重启后会丢失；②每个会话都在内存中维护记忆容易出现 OOM；③Redis 是内存数据库，读写对话记忆性能更高；④MySQL 中历史对话数据包含其他业务字段，不适合直接交给 Agent。

### Q. 接入 Redis 会话记忆需要引入哪个依赖？

A：dev.langchain4j 的 langchain4j-community-redis-spring-boot-starter，版本由 langchain4j-community-bom（1.17.2-beta27）统一管理。

### Q. RedisChatMemoryStoreConfig 绑定哪个配置前缀？包含哪些属性？

A：通过 @ConfigurationProperties(prefix = "spring.data.redis") 绑定，包含 host、port、password、ttl 四个属性。

### Q. RedisChatMemoryStore 构建时 user 参数设置为什么？

A：user 设置为 "default"。

### Q. 会话记忆在 Redis 中的 TTL 配置是多少？

A：ttl 为 3600（秒），即会话记忆保留 1 小时。

### Q. RedisChatMemoryStore 是如何接入会话记忆体系的？

A：在 chatMemoryProvider 中作为存储后端传入：MessageWindowChatMemory.builder().chatMemoryStore(redisChatMemoryStore)，使 20 条窗口记忆落在 Redis 而非 JVM 内存。

### Q. 为什么不直接用 MySQL 存对话记忆？

A：MySQL 中的历史对话数据会包含其他业务字段，不适合直接交给 Agent，且读写性能不如内存数据库 Redis。

### Q. 使用纯内存记忆在多会话场景下有什么隐患？

A：每个会话都在内存中维护对话记忆，会话多了容易出现 OOM 问题，且重启后全部丢失。

### Q. 引入 Redis 相关依赖后，课件提醒要在启动类上做什么排除？

A：要在启动类上排除 RedisEmbeddingStore（的自动配置），避免 Redis 被自动装配为向量存储，与 PgVector 冲突。

### Q. 请从"为什么用 Redis"与"项目如何实现"两方面，完整说明基于 Redis 的分布式会话记忆方案。

A：为什么用 Redis：①原先基于内存的会话记忆在项目重启后会丢失；②每个会话都在内存中维护记忆，并发会话多时容易 OOM；③Redis 是内存数据库，读写对话记忆性能更高；④MySQL 的历史对话表混有其他业务字段，不适合直接交给 Agent 使用。
项目如何实现：①POM 引入 langchain4j-community-redis-spring-boot-starter（版本由 langchain4j-community-bom 1.17.2-beta27 统一管理）；②YML 在 spring.data.redis 下配置 host、port、password、ttl（3600 秒）等；③编写 RedisChatMemoryStoreConfig，用 @ConfigurationProperties(prefix = "spring.data.redis") 绑定属性，并通过 RedisChatMemoryStore.builder().host(host).port(port).password(password).ttl(ttl).user("default").build() 注册 Bean；④在 AiChatService 的 chatMemoryProvider 中把该 Store 传给 MessageWindowChatMemory（id 为 @MemoryId 的 sessionId，maxMessages 20），实现"窗口在应用层、存储在 Redis 层"的分布式会话记忆；⑤同时在启动类上排除 RedisEmbeddingStore 自动配置，避免与 PgVector 向量库冲突。最终效果：会话按 sessionId 隔离、重启不丢、多实例可共享、1 小时自动过期。

### Q. Guardrail 是什么？

A：Guardrail（护轨）是一套嵌入在 LLM/AI Agent 全流程中的安全与合规控制机制——通过在输入、推理、工具调用及输出等关键环节设置规则校验与行为约束，确保 Agent 始终在业务规则、法律法规与系统安全边界内可靠运行。

### Q. Guardrail 能防范哪些典型风险？

A：防止 Prompt 注入、越权操作、敏感信息泄露与幻觉输出。

### Q. 项目的输入护轨类叫什么？实现了哪个接口？

A：SafeInputGuardrail，实现 dev.langchain4j.guardrail.InputGuardrail 接口，重写 validate(UserMessage) 方法。

### Q. SafeInputGuardrail 中定义了哪些敏感词？

A：用 Set.of 定义了两个敏感词："死" 和 "杀"。

### Q. 用户输入命中敏感词时护轨返回什么？

A：返回 fatal("提问不能包含敏感词！！！！！")，校验以致命失败终止，本次请求不会继续交给模型。

### Q. 护轨校验通过时 validate 返回什么？

A：返回 success()，请求正常继续。

### Q. 护轨是如何绑定到 AiChat 上的？

A：在 AiChat 接口上添加注解 @InputGuardrails({SafeInputGuardrail.class})，接口内所有对话方法的用户输入都会先经过该护轨校验。

### Q. validate 方法的入参是什么？如何取出用户输入文本？

A：入参是 UserMessage，通过 userMessage.singleText() 取出用户输入的文本，再逐一比对敏感词。

### Q. ErrorCode 中与敏感词相关的错误码是什么？

A：SENSITIVE_WORD_ERROR(40003, "包含敏感词，请求被拒绝")。

### Q. 请介绍 Guardrail 的概念与价值，以及千言项目输入护轨的完整实现与生效链路。

A：概念与价值：Guardrail（护轨）是嵌入 LLM/Agent 全流程的安全与合规控制机制，在输入、推理、工具调用、输出等关键环节设置规则校验与行为约束，防止 Prompt 注入、越权操作、敏感信息泄露与幻觉输出，确保 Agent 在业务规则、法律法规与系统安全边界内可靠运行——既赋能自主性，又守住底线。
项目实现：SafeInputGuardrail 实现 InputGuardrail 接口；类中用 Set.of("死", "杀") 维护敏感词集合；validate(UserMessage) 中通过 singleText() 取出用户输入，遍历敏感词做 contains 匹配，命中即返回 fatal("提问不能包含敏感词！！！！！")，全部未命中则返回 success()。
生效链路：AiChat 接口上标注 @InputGuardrails({SafeInputGuardrail.class}) → 用户请求进入 /chat 或 /streamChat → AiServices 生成的代理在把消息交给模型前先执行护轨校验 → 校验失败请求被拦截（对应业务错误码 SENSITIVE_WORD_ERROR 40003"包含敏感词，请求被拒绝"），校验通过才继续走记忆、检索与模型生成流程，从入口处保证了对话安全。

### Q. Prometheus 是什么？

A：Prometheus（普罗米修斯）是一个开源的时序数据库和监控告警系统，负责抓取（Pull）、存储指标数据，并提供强大的查询语言 PromQL。

### Q. Prometheus 采集指标采用什么模型？

A：采用 Pull（拉取）模型，由 Prometheus 主动抓取被监控端暴露的指标端点。

### Q. Grafana 是什么？

A：Grafana 是一个开源的可观测性与数据可视化平台，主要用于查询、可视化、分析和告警来自多种数据源的时间序列数据（如指标、日志、追踪等）。

### Q. 项目接入监控需要引入哪两个依赖？

A：spring-boot-starter-actuator 和 micrometer-registry-prometheus。

### Q. management 配置暴露了哪些端点？

A：暴露 health、info、prometheus 三个端点（management.endpoints.web.exposure.include: health,info,prometheus），health 端点 show-details 为 always。

### Q. 项目自定义了哪四个 AI 模型监控指标？

A：ai_model_requests_total（请求数）、ai_model_errors_total（错误数）、ai_model_tokens_total（Token 用量）、ai_model_response_duration_seconds（响应耗时）。

### Q. Token 用量指标通过什么 tag 区分类型？

A：通过 token_type 标签区分（如输入 Token 与输出 Token），计数时按 tokenCount 增量累加。

### Q. 指标收集器为什么用 ConcurrentHashMap + computeIfAbsent 缓存 Counter/Timer？

A：同一组 userId/sessionId/modelName（及 token_type）标签的指标对象只需注册一次，computeIfAbsent 在并发场景下安全地"取或建"，避免重复向 MeterRegistry 注册同名指标并减少对象创建开销。

### Q. 课件部署示例中 Grafana 的初始登录账号密码是什么？

A：账号 admin，密码 admin123（容器启动时通过 GF_SECURITY_ADMIN_PASSWORD=admin123 指定）。

### Q. 请完整介绍千言项目的可观测性方案：Prometheus + Grafana + 四大指标 + 采集链路。

A：整体方案分四层：
1. 指标暴露层：引入 spring-boot-starter-actuator 与 micrometer-registry-prometheus，YML 中 management.endpoints.web.exposure.include 暴露 health、info、prometheus 端点，应用以 Prometheus 格式对外提供 /actuator/prometheus 指标。
2. 指标定义层：AiModelMetricsCollector 基于 MeterRegistry 定义四个核心指标——ai_model_requests_total（按 status 记录请求开始/成功等状态）、ai_model_errors_total（错误计数）、ai_model_tokens_total（带 token_type 标签区分输入/输出 Token 用量）、ai_model_response_duration_seconds（Timer 记录响应耗时）；各指标用 ConcurrentHashMap + computeIfAbsent 按标签组合缓存，避免重复注册。
3. 采集触发层：AiModelMonitorListener 实现 ChatModelListener 并注册到 QwenChatModel / QwenStreamingChatModel 的 listeners 中：onRequest 记录 started 状态并把开始时间存入 attributes（key 为 request_start_time）；onResponse 计算耗时、从 chatResponse().metadata().tokenUsage() 读取输入/输出/总 Token，依次上报成功状态、耗时与 Token 指标并打印日志；onError 上报错误指标。用户与会话维度信息由 MonitorContext（userId、sessionId）经 MonitorContextHolder（ThreadLocal）在 Controller 层注入。
4. 存储可视化层：Docker 部署 Prometheus 3.7.3（Pull 模型抓取应用指标端点）与 Grafana 12.3.0（初始账号 admin/admin123），Grafana 以 Prometheus 为数据源创建 Dashboard，对请求量、错误率、Token 消耗与耗时进行可视化监控。

### Q. MonitorContext 中记录哪些信息？

A：记录 userId 与 sessionId 两个字段，通过 builder 方式构建。

### Q. MonitorContextHolder 的作用是什么？

A：它是基于 ThreadLocal 的监控上下文持有器，提供设置（setContext）、获取（getContext）与清除（clearContext）当前线程监控上下文的能力，把 Controller 层的用户/会话信息传递给模型监听器。

### Q. AiModelMonitorListener 实现了哪个接口？关注哪些回调？

A：实现 ChatModelListener 接口，关注 onRequest（请求发出）、onResponse（响应成功）、onError（请求失败）三个回调。

### Q. 请求开始时间通过什么 key 在监听器上下文属性中传递？

A：通过常量 START_TIME_KEY，值为 "request_start_time"，onRequest 存入、onResponse 取出计算耗时。

### Q. onResponse 中从哪里获取 Token 用量？

A：从 responseContext.chatResponse().metadata().tokenUsage() 获取，包含 inputTokenCount、outputTokenCount、totalTokenCount。

### Q. 监控监听器是如何挂到模型上的？

A：在 DashScopeModelConfig 中构建 QwenChatModel / QwenStreamingChatModel 时通过 .listeners(List.of(aiModelMonitorListener)) 注册。

### Q. /chat 接口是如何设置与清理监控上下文的？

A：方法开始时 MonitorContextHolder.setContext(MonitorContext.builder().userId(...).sessionId(...).build())，调用 aiChat.chat 得到结果后执行 MonitorContextHolder.clearContext() 再返回。

### Q. 流式接口为什么用 Flux.defer 包裹并在 doFinally 里清理上下文？

A：Flux.defer 保证在订阅发生时才设置 ThreadLocal 上下文，使上下文绑定到实际执行的线程；doFinally 在流以任意信号（完成/错误/取消）结束时清理上下文，避免响应式场景下的 ThreadLocal 泄漏与串号。

### Q. 请求成功时监听器会记录哪些内容？

A：上报 recordRequest("success") 请求状态、recordResponseTime 响应耗时、recordTokenUsage 输入/输出 Token 用量，并输出包含用户、会话、模型、耗时、Tokens 的成功日志。

### Q. 请说明一次 /chat 请求的监控数据流转：从 Controller 设置上下文到指标进入 Prometheus。

A：完整流转如下：①请求进入 AiChatController 的 /chat，先用请求体中的 userId、sessionId 构建 MonitorContext，并通过 MonitorContextHolder.setContext 存入当前线程的 ThreadLocal；②调用 aiChat.chat 触发模型请求，注册在 QwenChatModel 上的 AiModelMonitorListener.onRequest 被回调——从 MonitorContextHolder 取出用户/会话信息，记录 ai_model_requests_total{status="started"}，并把当前时间以 request_start_time 为 key 存入 attributes（同时也可将监控上下文存入 attributes 供后续回调使用）；③模型返回后 onResponse 回调：用开始时间计算耗时上报 ai_model_response_duration_seconds，记录 ai_model_requests_total{status="success"}，从 chatResponse().metadata().tokenUsage() 读取输入/输出 Token 并按 token_type 标签上报 ai_model_tokens_total，同时打印结构化成功日志；若失败则 onError 上报 ai_model_errors_total；④Controller 在返回前调用 clearContext 清理 ThreadLocal；⑤上述指标由 Micrometer 汇聚到 /actuator/prometheus 端点，Prometheus 按 Pull 模型周期性抓取入库，Grafana 以 Prometheus 为数据源在 Dashboard 中展示请求量、错误、耗时与 Token 消耗曲线。

### Q. 邮件功能需要引入什么依赖？

A：spring-boot-starter-mail。

### Q. 项目的 SMTP 服务器与端口是如何配置的（以 QQ 邮箱为例）？

A：spring.mail.host 为 smtp.qq.com，port 为 587。

### Q. spring.mail.password 应该填什么？

A：填 SMTP 授权码（不是邮箱登录密码）。

### Q. 邮件配置中开启了哪些安全传输属性？

A：mail.smtp.auth: true 与 mail.smtp.starttls.enable: true，即开启 SMTP 认证与 STARTTLS 加密传输。

### Q. EmailTool 用什么发送邮件？构造了什么消息对象？

A：注入 JavaMailSender 发送；构造 SimpleMailMessage，依次 setFrom（发件人）、setTo（收件人）、setSubject（标题）、setText（正文）后调用 mailSender.send。

### Q. 发件人地址从哪里读取？为什么这样设计？

A：通过 @Value("${spring.mail.username}") 从配置文件读取，避免在代码中硬编码发件账号。

### Q. EmailTool 的 @Tool 描述是什么？

A："向特定用户发送电子邮件。"

### Q. 邮件发送成功和失败分别返回什么？

A：成功返回"邮件已成功发送给 " + targetEmail；失败捕获异常并返回"邮件发送失败: " + 异常信息，同时记录错误日志。

### Q. 系统提示词对邮箱等隐私信息的例外规定是什么？

A：涉及敏感私人信息必须忽略或模糊处理，但"仅在执行邮件发送任务时，允许使用必要的邮箱地址"。

### Q. 请完整描述"智能邮件发送"能力的实现：依赖、配置、工具代码与一次自然语言发信的执行流程。

A：实现分四部分：
1. 依赖：POM 引入 spring-boot-starter-mail。
2. 配置：application.yml 中 spring.mail 配置 host: smtp.qq.com、port: 587、username（发件账号）、password（SMTP 授权码），并开启 properties.mail.smtp.auth: true 与 starttls.enable: true 保证认证与加密传输。
3. 工具代码：EmailTool 标注 @Component，注入 JavaMailSender，发件人通过 @Value("${spring.mail.username}") 读取避免硬编码；@Tool("向特定用户发送电子邮件。") 修饰的 sendEmail(targetEmail, subject, content) 中构造 SimpleMailMessage 并 setFrom/setTo/setSubject/setText，调用 mailSender.send 发送，成功返回"邮件已成功发送给 xxx"，异常时记录日志并返回失败原因；该工具在 AiChatService 中经 .tools(..., emailTool) 注册。
4. 执行流程：用户说"帮我给 xxx@qq.com 发一封主题为……的邮件"→ 模型依据 @Tool 描述与参数名抽取 targetEmail、subject、content 并发起工具调用（系统提示词允许邮件任务使用必要邮箱地址）→ 应用执行 sendEmail 真正发信 → 返回结果交回模型 → 模型向用户播报发送成功或失败。

### Q. 项目使用什么接口实现流式对话模型？具体实现类是什么？

A：使用 StreamingChatModel 接口，项目中的具体实现是通义千问的 QwenStreamingChatModel。

### Q. 接入流式输出需要引入哪个响应式适配依赖？版本是多少？

A：langchain4j-reactor，版本由 langchain4j-bom（1.17.2）统一管理。

### Q. AiChat 中流式方法的签名是什么？

A：Flux<String> streamChat(@MemoryId Long sessionId, @UserMessage String prompt)，与同步 chat 方法一样绑定同一份系统提示词并按 sessionId 隔离会话记忆。

### Q. YML 中流式模型是如何配置的？

A：在 langchain4j.community.dashscope 下的 streaming-chat-model 节点配置 model-name: qwen3-max 与 api-key。

### Q. AiServices 中同步与流式模型是如何同时装配的？

A：链式调用 .chatModel(chatModel) 与 .streamingChatModel(streamingChatModel) 同时传入两个模型，同一个 AiChat 代理即可提供同步与流式两种对话能力。

### Q. /streamChat 接口的请求方式与返回类型是什么？

A：POST 方式，接收 ChatRequest 请求体，返回 Flux<String> 流式响应。

### Q. ChatRequest 包含哪三个字段？

A：sessionId（Long，会话 ID）、userId（Long，用户 ID）、prompt（String，用户输入）。

### Q. 流式对话与同步对话共享哪些能力？为什么？

A：共享同一份系统提示词（同一 fromResource 绑定）、同一套会话记忆（@MemoryId + Redis）、同一个内容检索器与同一条工具链（TimeTool/RagTool/EmailTool/MCP），因为二者由同一个 AiServices.builder 装配、同属一个 AiChat 代理，只是返回形态不同。

### Q. 流式接口中监控上下文是在什么时机设置与清理的？

A：在 Flux.defer 的工厂函数里、即订阅发生时调用 MonitorContextHolder.setContext 设置；通过 .doFinally(signal -> MonitorContextHolder.clearContext()) 在流以任意信号结束时清理。

### Q. 请完整说明把同步 chat 升级为流式 streamChat 需要做的全部改动点。

A：升级共涉及五处改动：
1. 模型配置：application.yml 的 langchain4j.community.dashscope 下新增 streaming-chat-model 节点，配置 model-name: qwen3-max 与 api-key，使框架自动装配 QwenStreamingChatModel。
2. 依赖引入：POM 新增 langchain4j-reactor（版本由 langchain4j-bom 1.17.2 统一管理），为 AiServices 提供 Flux 返回类型的响应式适配能力。
3. 接口扩展：AiChat 中新增 Flux<String> streamChat(@MemoryId Long sessionId, @UserMessage String prompt) 方法，沿用同一 @SystemMessage 系统提示词、同一护轨与同一会话隔离方式。
4. 服务装配：AiChatService 构建 AiServices 时在 .chatModel(chatModel) 之外追加 .streamingChatModel(streamingChatModel)，注入流式模型 Bean，检索器、记忆提供者与工具链全部复用。
5. 控制层：AiChatController 新增 POST /streamChat，返回 Flux<String>；先用请求体的 userId/sessionId 构建 MonitorContext，再用 Flux.defer 包裹——订阅时 setContext 绑定 ThreadLocal，调用 aiChat.streamChat 后通过 doFinally 在流结束（完成/错误/取消任意信号）时 clearContext，保证响应式场景下监控上下文不泄漏。
   完成后客户端即可逐 token 接收生成内容，边生成边显示，大幅降低首字延迟，而记忆、RAG、工具调用等能力与同步接口完全一致。

### Q. 什么是提示词工程（Prompt Engineering）？

A：提示词工程是通过精心设计输入文本（Prompt），引导大语言模型生成高质量、符合预期输出的技术。

### Q. 课件给出的高质量输出核心公式是什么？

A：高质量输出 = 清晰的角色设定 + 充分的上下文 + 精确的任务指令 + 严格的格式约束。

### Q. CO-STAR 框架各字母分别代表什么？

A：C-Context（上下文）、O-Objective（目标）、S-Style（风格）、T-Tone（语气）、A-Audience（受众）、R-Response（响应格式），用于构建结构化提示词。

### Q. 角色设定技巧的作用是什么？课件示例中设定的角色是？

A：给 AI 一个明确的身份能显著提升其在特定领域的表现；示例将 AI 设定为"深耕 Java 生态 10 年的资深架构师"。

### Q. 少样本提示（Few-Shot）一般建议给几个例子？

A：给模型 1-3 个示例，让它模仿示例的格式与风格输出。

### Q. 激发思维链（CoT）常用的关键词是什么？

A："请逐步思考并给出逻辑步骤："，引导模型先推理再作答。

### Q. 系统提示词中的"知识边界"规则要求什么？

A：仅根据已获取的知识回答问题，不得编造或推测信息；知识库中没有的内容应如实告知用户。

### Q. 系统提示词中的"日常交互"规则允许什么？

A：允许对天气、问候等普通日常问题做简短、自然的回应，不必强行关联知识库。

### Q. 系统提示词"安全合规"部分包含哪两大类要求？

A：一是内容安全——拒绝违法违规、暴力等不当内容；二是隐私保护——敏感私人信息须忽略或模糊处理，仅在执行邮件发送任务时允许使用必要的邮箱地址。

### Q. 请系统介绍提示词工程：定义、核心公式、CO-STAR 框架与三个实用技巧，并说明千言项目是如何落地的。

A：定义：提示词工程是通过精心设计输入文本引导 LLM 生成高质量、符合预期输出的技术，是低成本提升模型表现的首选手段。
核心公式：高质量输出 = 清晰的角色设定 + 充分的上下文 + 精确的任务指令 + 严格的格式约束。
CO-STAR 框架：从 Context（上下文）、Objective（目标）、Style（风格）、Tone（语气）、Audience（受众）、Response（响应格式）六个维度结构化地组织提示词，保证信息完整、指令明确。
三个实用技巧：①角色设定——给 AI 明确身份（如"深耕 Java 生态 10 年的资深架构师"）可显著提升特定领域表现；②少样本提示——提供 1-3 个示例让模型模仿格式与风格；③思维链——用"请逐步思考并给出逻辑步骤："引导模型先推理后结论，提升复杂问题的准确率。
千言项目落地：resources/system-prompt/chat-bot.txt 按上述方法编写系统提示词——先做角色设定（千言 AI 智能助手，千言 IM 的智能引擎），再给出行为规则：知识边界（仅依据已获取知识作答、不编造）、日常交互（普通问题简短自然回应）、安全合规（拒绝不当内容；隐私信息忽略或模糊处理，仅邮件任务允许使用必要邮箱地址）、格式约束（纯文本输出、换行严格用 \n）与语气约束（每条回复结尾必须使用感叹号），并通过 @SystemMessage(fromResource = "system-prompt/chat-bot.txt") 绑定到 AiChat 接口，让每次对话都在该提示词约束下进行。

### Q. 服务的端口与上下文路径是什么？

A：端口 10010，context-path 为 /api，即接口统一以 /api 为前缀。

### Q. 同步对话接口的路径、请求方式与返回类型是什么？

A：POST /chat（完整路径 /api/chat），接收 ChatRequest 请求体，返回 String 完整回答。

### Q. CorsConfig 是如何配置跨域的？

A：实现 WebMvcConfigurer，addMapping("/**") 对所有路径生效，allowCredentials(true) 允许携带凭证，用 allowedOriginPatterns("*") 匹配任意来源（避免 allowedOrigins("*") 与凭证模式冲突），放行 GET/POST/PUT/DELETE/OPTIONS 方法。

### Q. Dockerfile 使用什么基础镜像？为什么？

A：eclipse-temurin:17-jre——只含 JRE 不含完整 JDK，镜像更轻量，且与项目的 JDK 17 编译目标匹配。

### Q. 容器的时区是如何设置的？

A：通过 ENV TZ=Asia/Shanghai 并将 /usr/share/zoneinfo/Asia/Shanghai 链接到 /etc/localtime，保证日志与 TimeTool 输出为中国时区。

### Q. 容器启动脚本中 cp -rn /init-docs/* /data/docs/ 的作用是什么？

A：把镜像内备份的初始知识库文档恢复到挂载目录 /data/docs；-n 参数保证不覆盖已存在的同名文件，避免运行期通过动态知识植入新增的内容在重启时丢失。

### Q. Dockerfile 为什么创建固定 UID 1001 的用户运行应用？

A：以固定 UID 1001 的 appuser 非 root 运行提升安全性；固定 UID 便于宿主机对挂载卷（如 /data/docs）按相同 UID 授权，配合 chown 保证容器内外文件权限对齐。

### Q. 生产环境激活哪个 profile？知识库文档路径是什么？

A：application.yml 中 spring.profiles.active: prod 激活生产配置；prod 配置中 rag.docs-path 为 /data/docs。

### Q. 项目的统一异常处理体系由哪些类组成？

A：BusinessException（自定义业务异常）、ErrorCode（错误码枚举）、GlobalExceptionHandler（@RestControllerAdvice 全局捕获）、ThrowUtils（条件抛异常工具），配合 BaseResponse 与 ResultUtils 输出统一响应格式。

### Q. 请描述千言项目从打包到容器化部署的完整链路与运行时行为。

A：完整链路如下：
1. 打包：Maven（3.6.3）执行打包，由 spring-boot-maven-plugin 产出可执行 fat jar。
2. 镜像构建：Dockerfile 以 eclipse-temurin:17-jre 为基础镜像；设置 ENV TZ=Asia/Shanghai 并链接 zoneinfo 保证中国时区；COPY jar 进镜像；COPY docs 到 /init-docs 作为初始知识库备份；创建固定 UID 1001 的非 root 用户 appuser 并 chown 相关目录；EXPOSE 10010 声明服务端口；USER appuser 切换运行身份。
3. 启动行为：容器入口脚本先执行 cp -rn /init-docs/* /data/docs/，把初始文档恢复到挂载卷且不覆盖已有文件（保护动态植入的新知识），再启动 jar。
4. 运行时：spring.profiles.active: prod 激活生产配置，rag.docs-path 指向 /data/docs；RagDataLoader（CommandLineRunner）在启动时从该目录加载全部 md 文档，经切分、向量化后写入 PgVector（dropTableFirst 先清后建，保证向量库与文档一致）；服务在 10010 端口、/api 前缀下对外提供 /chat、/streamChat、/insert 接口；Actuator 暴露 /actuator/prometheus 供 Prometheus 抓取，配合 Grafana 完成可观测；Redis 承载会话记忆。挂载卷 + 不覆盖复制 + 启动重灌向量库的组合，使容器可随时销毁重建而知识不丢失。

### Q. 什么是 Agent Skill？

A：Skill 是封装了特定业务逻辑、可被 Agent 动态检索调用的模块化执行单元，可以类比为"岗位 SOP + 专属工具箱"——把某类任务的操作规程与配套资源打包给 AI 使用。

### Q. Skill 的"渐进式披露"机制是什么？有什么好处？

A：Skill 的元数据（名称、描述）常驻上下文供 AI 判断是否需要，而正文与资源按需加载；好处是大幅节省 Token，让 Agent 可以挂载大量 Skill 而不撑爆上下文。

### Q. 一个 Skill 包通常由哪些部分组成？

A：必需的 SKILL.md（元数据 + 指令文档），可选的 scripts/（脚本）、references/（参考文档）与 assets/（资源文件）。

### Q. 课件中提到可以从哪里获取现成的 Skills？

A：skillsmp.com/zh 与 github.com/anthropics/skills。

### Q. 大模型通用智力与 Skill 的关系是什么？

A：大模型提供通用智力（理解、推理、生成），Skill 提供领域专业能力（流程、规范、工具），二者结合才能可靠完成真正的专业任务。

### Q. "千言"这个项目名有什么寓意？

A：取自"千言万语尽在其中"——寓意即使有千言万语，也能通过千言顺畅传达。

### Q. 千言 IM 的目标用户是哪些？

A：个人用户、小型团队和社区交流者。

### Q. 千言·AI 智能助手与千言 IM 是什么关系？

A：智能助手是基于 Java + LangChain4j 构建的企业级 Agent 系统，后续将作为智能引擎嵌入到千言 IM（山羊算法独立开发的即时通讯软件）中，为其提供 AI 对话与智能服务能力。

### Q. AiServices.builder 装配 AiChat 时传入了哪些组件？

A：共六类：chatModel（QwenChatModel）、streamingChatModel（QwenStreamingChatModel）、contentRetriever（RAG 检索器）、chatMemoryProvider（基于 Redis 的 MessageWindowChatMemory，窗口 20 条）、tools（new TimeTool()、ragTool、emailTool）以及 toolProvider（mcpToolProvider，接入 BigModel 联网搜索）。

### Q. 请对千言·AI 智能助手做一次全景总结：项目定位、技术选型与八大核心能力。

A：项目定位：千言·AI 智能助手是基于 Java + LangChain4j 的企业级 AI Agent 系统，将作为智能引擎嵌入千言 IM（"千言万语尽在其中"，山羊算法独立开发，面向个人用户、小型团队与社区交流者），提供私域知识问答与智能服务。
技术选型：SpringBoot 3.5.9 + JDK 17 + Maven 3.6.3 为工程底座；LangChain4j 1.17.2（社区 starter 1.17.2-beta27，经 BOM 统一管理）为 Agent 框架；对话与流式模型均为通义千问 qwen3-max，Embedding 为 text-embedding-v4（1024 维）；PgVector 15.15 作向量库、Redis 8.4.0 作会话存储；Prometheus 3.7.3 + Grafana 12.3.0 构成监控栈；eclipse-temurin:17-jre 容器化部署于 10010 端口 /api 路径。
八大核心能力：
1. 私域知识 RAG：启动时 RagDataLoader 加载 md 文档，MarkdownHeadingSplitter(3,1500) 按标题切分、拼接 file_name 元数据后向量化入 PgVector；检索走「向量 + BM25 混合召回 Top-20 → RRF 融合 → qwen3-rerank 精排 Top-5」的两阶段链路。
2. 分布式会话记忆：MessageWindowChatMemory(20) + RedisChatMemoryStore，@MemoryId 按 sessionId 隔离，TTL 3600 秒。
3. 工具调用：TimeTool（上海时区时间）、RagTool（保存知识）、EmailTool（发送邮件）经 .tools() 注册，模型按 @Tool 描述自主调用。
4. MCP 联网搜索：HttpMcpTransport SSE 接入智谱 BigModel web_search，经 McpToolProvider 挂载，赋予实时联网能力。
5. 动态知识植入：RagTool 与 /insert 接口双链路，把新知识同步写入物理文件与向量库，实现自我进化记忆。
6. 输入护轨：SafeInputGuardrail 拦截敏感词（"死"/"杀"），从入口保障对话安全。
7. 流式输出：langchain4j-reactor + QwenStreamingChatModel，/streamChat 返回 Flux<String>，逐 token 推送降低首字延迟。
8. 全链路可观测：四大自定义指标（请求/错误/Token/耗时）经 ChatModelListener 采集、ThreadLocal 传递用户会话维度，Actuator 暴露给 Prometheus，Grafana 可视化。
   整体架构上，AiServices.builder 将模型、检索器、记忆、工具与 MCP 统一装配为 AiChat 代理，Controller 提供 /chat、/streamChat、/insert 三个入口，配合统一异常处理、CORS 与 Docker 化部署，构成一套可运行、可监控、可进化的完整企业级 Agent。

### Q. Milvus 是什么？

A：Milvus 是一款开源的分布式向量数据库，由 Zilliz 主导开发，专为大规模向量相似度检索设计，支持十亿级向量的存储与查询。

### Q. Milvus 的架构有什么特点？

A：Milvus 采用存储与计算分离的架构，由 Proxy、Query Node、Data Node、Index Node 等组件构成，各组件可独立扩缩容。

### Q. Milvus 适合什么场景？

A：Milvus 适合向量规模在千万级以上、需要水平扩展和高并发查询的生产场景，例如以图搜图、推荐召回、大规模语料检索。

### Q. Milvus 的部署成本如何？

A：Milvus 单机模式部署简单，但集群模式依赖 etcd、MinIO、Pulsar 等外部组件，运维复杂度明显高于嵌入式方案。

### Q. Milvus 的查询能力如何？

A：Milvus 支持标量字段过滤与向量检索的混合查询，可以先用布尔表达式筛选分区再做近邻搜索。

### Q. Qdrant 是什么？

A：Qdrant 是用 Rust 编写的开源向量数据库，主打低延迟与内存效率，提供 REST 与 gRPC 两套接口。

### Q. Qdrant 的架构有什么特点？

A：Qdrant 以 Collection 为组织单位，每个 Collection 包含带 payload 的向量点，payload 可作为过滤条件参与检索。

### Q. Qdrant 适合什么场景？

A：Qdrant 适合需要复杂元数据过滤的检索场景，其过滤器与向量索引是耦合执行的，避免了先检索后过滤造成的召回不足。

### Q. Qdrant 的部署成本如何？

A：Qdrant 提供单二进制与 Docker 镜像，无外部依赖，中小规模场景下部署成本很低。

### Q. Qdrant 支持哪些向量量化方式？

A：Qdrant 支持标量量化与乘积量化，可以把向量压缩到原体积的四分之一以下，用少量精度换取显著的内存节省。

### Q. Weaviate 是什么？

A：Weaviate 是一款开源向量搜索引擎，内置模块化的向量化能力，可以在写入时自动调用外部模型生成向量。

### Q. Weaviate 的架构有什么特点？

A：Weaviate 使用 GraphQL 作为主要查询接口，数据以 Class 和 Property 组织，天然支持对象之间的交叉引用。

### Q. Weaviate 适合什么场景？

A：Weaviate 适合希望把向量化流程收敛到数据库侧、减少应用层代码的团队。

### Q. Weaviate 对混合检索的支持如何？

A：Weaviate 原生提供稀疏与稠密融合的混合检索接口，可以通过一个 alpha 参数调节两者权重。

### Q. Chroma 是什么？

A：Chroma 是一款轻量级开源向量数据库，主打易用性，几行 Python 代码即可完成建库、写入与检索。

### Q. Chroma 适合什么场景？

A：Chroma 适合原型验证、教学演示和单机小规模应用，不建议直接用于高并发生产环境。

### Q. Chroma 的数据是怎么存储的？

A：Chroma 支持纯内存模式与本地持久化模式，持久化时把索引与元数据落到本地目录。

### Q. FAISS 是什么？

A：FAISS 是 Meta 开源的向量相似度检索库，它是一个库而非数据库，不提供网络服务、权限管理和持久化元数据。

### Q. FAISS 提供哪些索引类型？

A：FAISS 提供暴力检索、倒排聚类、量化压缩和图结构等多种索引形态，可以按精度与速度的权衡自由组合。

### Q. FAISS 适合什么场景？

A：FAISS 适合作为更上层系统的检索内核嵌入使用，很多向量数据库的底层检索能力就构建在它之上。

### Q. FAISS 有什么局限？

A：FAISS 本身不管理原始文档，只返回向量的编号与距离，业务方需要自己维护编号到内容的映射。

### Q. Pinecone 是什么？

A：Pinecone 是一款商业化的托管向量数据库，用户无需关心底层运维，按用量付费。

### Q. Pinecone 适合什么场景？

A：Pinecone 适合不希望自建基础设施、愿意用成本换运维投入的团队。

### Q. Pinecone 有什么局限？

A：Pinecone 是闭源托管服务，数据需要出网，对数据合规要求严格的场景不适用。

### Q. Elasticsearch 的向量检索能力如何？

A：Elasticsearch 从 8.x 起提供 dense_vector 字段与 kNN 检索，可以在同一个索引里同时做全文检索与向量检索。

### Q. Elasticsearch 适合什么场景？

A：Elasticsearch 适合本来就有 ES 集群、希望复用现有基础设施补充向量能力的团队。

### Q. Elasticsearch 有什么局限？

A：Elasticsearch 的向量检索在超大规模下的性能与资源占用通常不及专用向量数据库。

### Q. LanceDB 是什么？

A：LanceDB 是基于 Lance 列式存储格式的嵌入式向量数据库，可以直接在对象存储上做向量检索。

### Q. LanceDB 适合什么场景？

A：LanceDB 适合数据湖场景，把向量数据和结构化数据放在同一套存储里统一管理。

### Q. Vespa 是什么？

A：Vespa 是 Yahoo 开源的大规模检索与推荐引擎，同时支持结构化检索、文本检索、向量检索和在线机器学习推理。

### Q. Vespa 适合什么场景？

A：Vespa 适合需要在检索阶段就执行复杂排序模型的大型搜索与推荐系统。

### Q. LangChain 是什么？

A：LangChain 是 Python 与 JavaScript 生态中应用最广的大模型应用开发框架，提供模型抽象、提示词模板、链式编排、记忆与工具集成等组件。

### Q. LangChain 的核心抽象有哪些？

A：LangChain 的核心抽象包括 Model、Prompt、Chain、Memory、Tool、Retriever 和 Agent，通过表达式语言把这些组件串联成可组合的管道。

### Q. LangChain 常被诟病的地方是什么？

A：LangChain 被诟病抽象层次过多、版本迭代激进导致接口不稳定，简单场景下直接调用模型 API 反而更清晰。

### Q. LlamaIndex 是什么？

A：LlamaIndex 是专注于检索增强场景的框架，在文档加载、索引构建和查询引擎方面提供了比通用框架更丰富的开箱能力。

### Q. LlamaIndex 的核心概念有哪些？

A：LlamaIndex 的核心概念包括 Document、Node、Index、Retriever 和 QueryEngine，围绕「把数据变成可查询的索引」组织。

### Q. LangGraph 是什么？

A：LangGraph 用有向图描述智能体的执行流程，节点是计算步骤、边是状态转移，天然支持循环、分支与人工介入。

### Q. LangGraph 适合什么场景？

A：LangGraph 适合流程复杂、需要显式控制状态流转和支持中途暂停恢复的智能体应用。

### Q. AutoGen 是什么？

A：AutoGen 是微软开源的多智能体协作框架，通过让多个具备不同角色的智能体互相对话来完成复杂任务。

### Q. AutoGen 适合什么场景？

A：AutoGen 适合可以被拆解为多角色协作的任务，例如一个负责写代码、一个负责评审、一个负责执行验证。

### Q. CrewAI 是什么？

A：CrewAI 以「团队」为隐喻组织多智能体，用角色、目标和任务三要素描述每个成员，强调流程编排的可读性。

### Q. Semantic Kernel 是什么？

A：Semantic Kernel 是微软推出的面向 .NET、Java 和 Python 的大模型编排 SDK，核心概念是把提示词和原生代码统一抽象成可组合的技能插件。

### Q. Spring AI 是什么？

A：Spring AI 是 Spring 官方推出的大模型应用开发框架，把模型调用、向量存储和检索增强封装成符合 Spring 编程习惯的组件与自动配置。

### Q. Spring AI 有什么特点？

A：Spring AI 深度绑定 Spring Boot 的自动配置与依赖注入体系，对已有 Spring 技术栈的团队上手成本很低。

### Q. Haystack 是什么？

A：Haystack 是 deepset 开源的检索增强与问答框架，以 Pipeline 为核心抽象，把检索、排序、生成等组件按图连接。

### Q. Dify 是什么？

A：Dify 是开源的大模型应用开发平台，提供可视化编排界面、提示词管理、数据集管理与 API 发布能力，降低非工程角色的使用门槛。

### Q. MetaGPT 是什么？

A：MetaGPT 把软件公司的标准作业流程编码进多智能体协作中，让不同角色的智能体按产品、架构、开发、测试的顺序推进任务。

### Q. 什么是 HyDE 检索方法？

A：HyDE 的全称是 Hypothetical Document Embeddings。它先让大模型针对用户问题生成一段假设性的答案，再用这段答案的向量去检索，从而缓解问题与文档在表述风格上的差异。

### Q. HyDE 有什么缺点？

A：HyDE 需要额外一次大模型调用，增加延迟与成本；如果模型生成的假设答案偏离事实，反而会把检索引向错误方向。

### Q. 什么是 Query2Doc？

A：Query2Doc 让大模型把简短查询扩写成一段伪文档，再把原查询与伪文档拼接后检索，本质上是通过扩充查询的信息量来提升召回。

### Q. 什么是多查询检索（Multi-Query Retrieval）？

A：多查询检索让大模型把一个用户问题改写成若干个语义等价但表述不同的查询，分别检索后合并去重，用查询侧的多样性弥补单次检索的偏差。

### Q. 什么是 Step-Back Prompting？

A：Step-Back Prompting 先让模型把具体问题抽象成更上位的原理性问题，检索到背景知识后再回来回答原问题，适合需要概念铺垫的复杂提问。

### Q. 什么是 RAPTOR 检索结构？

A：RAPTOR 对文档块做递归聚类并逐层生成摘要，形成一棵树；检索时可以在不同抽象层级上匹配，既能命中细节也能命中全局脉络。

### Q. 什么是 GraphRAG？

A：GraphRAG 先从语料中抽取实体与关系构建知识图谱，再基于图结构做社区检测与摘要，检索时沿图游走获取上下文，擅长回答需要跨文档聚合的全局性问题。

### Q. GraphRAG 的主要代价是什么？

A：GraphRAG 的图构建阶段需要对全量语料做实体关系抽取，大模型调用量大、构建成本高，且图谱随语料更新需要重建或增量维护。

### Q. 什么是 Self-RAG？

A：Self-RAG 训练模型输出反思标记，自主判断当前是否需要检索、检索到的内容是否相关、生成的答案是否有依据，把检索决策交给模型自己。

### Q. 什么是 CRAG（Corrective RAG）？

A：CRAG 在检索之后加入一个轻量评估器判断检索质量，质量差时触发查询改写或联网搜索作为补救，属于检索结果的纠错机制。

### Q. 什么是父子块检索（Parent-Child Retrieval）？

A：父子块检索用小块做向量匹配以保证精度，命中后返回它所属的大块作为上下文以保证完整性，兼顾检索准确率与上下文充分性。

### Q. 什么是句子窗口检索（Sentence Window Retrieval）？

A：句子窗口检索以单句为检索单元，命中后把该句前后若干句一并取出作为上下文，是父子块思路的一种轻量实现。

### Q. 什么是上下文检索（Contextual Retrieval）？

A：上下文检索在切块时让大模型为每个块生成一段说明它在全文中位置与作用的前缀，再拼接后向量化，用以缓解块脱离原文后语义丢失的问题。

### Q. 什么是 MMR（最大边际相关性）？

A：MMR 在排序时同时考虑候选与查询的相关性以及候选之间的冗余度，通过一个权重参数在相关性和多样性之间取舍，避免返回一堆内容雷同的块。

### Q. 什么是稀疏检索？

A：稀疏检索用高维稀疏向量表示文本，每一维对应词表中的一个词，典型代表是 TF-IDF 与 BM25，优势是对专有名词、编号等字面串命中精准。

### Q. 什么是稠密检索？

A：稠密检索用低维稠密向量表示文本语义，通过近邻搜索匹配，优势是能命中表述不同但语义相近的内容，劣势是对罕见专名不敏感。

### Q. TF-IDF 的基本思想是什么？

A：TF-IDF 认为一个词在当前文档中出现越频繁、在整个语料中出现越稀少，就越能代表这篇文档，两个因子相乘得到该词的权重。

### Q. BM25 相比 TF-IDF 改进了什么？

A：BM25 引入词频饱和机制，避免某个词重复出现无限抬高得分；同时加入文档长度归一化，避免长文档因为词多而占优。

### Q. BM25 中的 k1 参数控制什么？

A：k1 控制词频饱和的速度，值越大词频对得分的边际贡献衰减越慢，常用取值在 1.2 到 2.0 之间。

### Q. BM25 中的 b 参数控制什么？

A：b 控制文档长度归一化的强度，取 0 表示完全不做长度归一化，取 1 表示完全归一化，常用默认值为 0.75。

### Q. 什么是倒排索引？

A：倒排索引把「文档到词」的映射反转为「词到文档列表」的映射，查询时直接取出包含查询词的文档列表求交，是全文检索的基础数据结构。

### Q. 什么是近似最近邻搜索（ANN）？

A：近似最近邻搜索放弃精确找出距离最近的向量，通过索引结构把搜索范围限制在一小部分候选上，用可控的召回损失换取数量级的速度提升。

### Q. 暴力检索（Flat）在什么情况下反而更合适？

A：当向量总量较小时，暴力检索遍历全量计算距离的开销可以接受，且能保证百分之百的召回，此时构建近似索引反而得不偿失。

### Q. 什么是乘积量化（PQ）？

A：乘积量化把高维向量切成若干子段，每段独立聚类成码本，用码本编号代替原始浮点数存储，能把内存占用压缩一个数量级。

### Q. 什么是标量量化？

A：标量量化把每一维的浮点数映射到更低精度的整数表示，例如从 32 位浮点压到 8 位整数，实现简单且精度损失通常可接受。

### Q. 向量检索中的余弦相似度和欧氏距离有什么区别？

A：余弦相似度只看向量方向不看长度，适合文本语义匹配；欧氏距离同时受方向和长度影响，适合向量模长本身有意义的场景。

### Q. 什么是内积（点积）相似度？

A：内积同时受向量夹角与模长影响，当向量已做归一化时内积与余弦相似度等价，未归一化时长向量会天然占优。

### Q. 为什么很多检索系统会对向量做归一化？

A：归一化把所有向量的模长统一为 1，使内积运算等价于余弦相似度，既简化了计算又避免模长差异干扰语义匹配。

### Q. 什么是召回率（Recall）？

A：召回率衡量所有应该被找到的相关内容中，实际被检索出来的比例，反映系统「有没有漏」。

### Q. 什么是精确率（Precision）？

A：精确率衡量检索返回的结果中真正相关的比例，反映系统「返回的准不准」。

### Q. 什么是 MRR（平均倒数排名）？

A：MRR 取每个查询第一个正确结果排名的倒数再求平均，第一名得 1 分、第二名得 0.5 分，特别关注首个正确答案的位置。

### Q. 什么是 NDCG？

A：NDCG 是归一化折损累积增益，它给不同位置的结果赋予随排名递减的权重，并按理想排序归一化，适合评价多级相关性的排序质量。

### Q. 什么是 MAP（平均精度均值）？

A：MAP 对每个查询计算各个相关结果位置上的精确率并取平均得到平均精度，再对所有查询求均值，综合反映排序与召回的整体质量。

### Q. 检索系统里的 Recall@K 和 Hit@K 有什么区别？

A：Recall@K 计算前 K 个结果覆盖了多少比例的相关内容，Hit@K 只判断前 K 个里有没有至少一个相关内容，是一个 0 或 1 的指标。

### Q. 什么是查询改写（Query Rewriting）？

A：查询改写在检索前把用户的原始表述转换成更适合检索的形式，常见操作包括补全省略的主语、消解代词指代、拆分复合问题。

### Q. 多轮对话中为什么需要查询改写？

A：多轮对话里用户常用代词指代前文，例如「它是什么时候发布的」，检索器只拿到当前这句话就缺少主语，必须先把指代补全成完整实体才能检索到正确内容。

### Q. 什么是检索结果的去重？

A：去重指在融合多路检索结果时识别并合并指向同一原始片段的重复项，通常用文档主键而非正文字符串作为判重依据，避免因空白或格式差异导致漏判。

### Q. 为什么粗召回阶段不宜设置过高的相似度阈值？

A：粗召回的目标是尽量不漏，过滤工作应交给后续精排环节；阈值过高会让候选池过小，后续精排无从选择，也会破坏多路融合对完整排名列表的假设。

### Q. 什么是两阶段检索？

A：两阶段检索先用低成本方法从全库粗召回一批候选，再用高成本高精度的模型对这批候选精排，兼顾速度与效果。

### Q. 什么是 RRF（倒数排名融合）？

A：RRF 把多路检索结果按名次而非分数融合，每一路对某文档的贡献是一个常数与其名次之和的倒数，避免不同检索路的分数量纲不可比的问题。

### Q. RRF 公式里的常数 k 起什么作用？

A：常数 k 用来平滑排名靠前项的权重差距，k 越大头部名次之间的分差越小，常用经验取值为 60。

### Q. 相比加权求和，RRF 的优势是什么？

A：加权求和要求先把不同检索路的分数归一化到同一量纲并调权重，既麻烦又对分布变化敏感；RRF 只用名次，天然免疫量纲差异。

### Q. 什么是双编码器（Bi-Encoder）？

A：双编码器把查询和文档分别独立编码成向量，再计算向量相似度。因为文档向量可以离线预先算好，所以支持大规模检索。

### Q. 什么是交叉编码器（Cross-Encoder）？

A：交叉编码器把查询和文档拼接后一起送进模型，让两者在每一层充分交互后直接输出相关性分数，精度高但无法预计算。

### Q. 为什么交叉编码器不能用于全库检索？

A：交叉编码器输出的分数是查询与文档这一对共同算出来的，不是文档自身的属性，换一个查询就必须重算，因此全库打分的开销随库规模线性增长，不可承受。

### Q. 重排序（Rerank）在检索链路中处于什么位置？

A：重排序位于粗召回之后、生成之前，负责把粗召回给出的一批候选按与查询的真实相关性重新排序，并截取靠前的若干条送入生成环节。

### Q. 重排序能解决什么问题？

A：重排序主要解决排序质量问题：粗召回往往能把相关内容捞进候选池，但未必排在最前面，重排序把真正相关的内容顶到前面，提升送入模型的上下文质量。

### Q. 什么是 ColBERT？

A：ColBERT 采用延迟交互机制，为查询和文档的每个 token 分别保留向量，检索时做 token 级的最大相似度匹配，在精度与效率之间取折中。

### Q. 什么是 SPLADE？

A：SPLADE 用预训练模型生成稀疏的词权重表示，输出可以直接放进倒排索引，兼具稀疏检索的可解释性与神经模型的语义能力。

### Q. Embedding 模型的向量维度越高越好吗？

A：维度越高通常表达能力越强，但存储与计算成本同步上升，检索延迟增加，且超过一定维度后收益递减，需要按语料规模与精度要求权衡。

### Q. 什么是对比学习在 Embedding 训练中的作用？

A：对比学习通过拉近正样本对的向量距离、推远负样本对的距离来训练编码器，是当前主流文本 Embedding 模型的核心训练范式。

### Q. 什么是难负样本（Hard Negative）？

A：难负样本指与查询表面相似但实际不相关的样本，用它们训练能让模型学到更细致的区分边界，比随机负样本效果显著更好。

### Q. Embedding 模型的最大输入长度受什么限制？

A：受模型的上下文窗口限制，超出部分会被截断。因此入库前的切块长度应当控制在模型窗口之内，否则尾部内容不会参与向量计算。

### Q. 为什么中文短文本的余弦相似度普遍偏高？

A：中文短文本共享大量高频字词，且句子越短语义空间的区分度越低，因此即使内容不同余弦值也常常落在较高区间，绝对数值不宜跨语言横向比较。

### Q. 什么是 Matryoshka 表示学习？

A：Matryoshka 表示学习让同一个模型输出的向量在被截断到较低维度后仍然保持可用，从而支持按场景在精度与成本之间灵活取舍。

### Q. 检索时查询和文档需要用同一个 Embedding 模型吗？

A：必须用同一个模型或同一族的配套模型，否则两者的向量空间不一致，相似度计算没有意义。

### Q. 什么是非对称检索？

A：非对称检索指查询与文档在长度和风格上差异很大的场景，例如短问题匹配长文档，部分 Embedding 模型会为查询和文档提供不同的指令前缀来适配这种差异。

### Q. Transformer 架构的核心机制是什么？

A：Transformer 的核心是自注意力机制，它让序列中每个位置都能直接与其他所有位置交互，摆脱了循环网络对序列长度的顺序依赖，从而支持大规模并行训练。

### Q. 什么是多头注意力？

A：多头注意力把注意力计算拆成若干组并行执行，每组在不同的子空间里关注不同的语义关系，最后拼接融合，比单头能捕捉更丰富的依赖模式。

### Q. 什么是位置编码？

A：自注意力本身对输入顺序不敏感，位置编码为每个位置注入位置信息，让模型能区分词序。常见实现有正弦位置编码与旋转位置编码。

### Q. 什么是旋转位置编码 RoPE？

A：RoPE 通过对查询和键向量做与位置相关的旋转变换来注入位置信息，具有良好的相对位置感知能力和一定的长度外推潜力。

### Q. 什么是 Tokenizer？

A：Tokenizer 负责把原始文本切分成模型词表中的单元并映射为编号，常见算法包括 BPE、WordPiece 和 SentencePiece。

### Q. 中文文本的 token 数量大致如何估算？

A：中文在多数主流词表下大约一个汉字对应一到两个 token，具体比例取决于词表设计，估算时按一个汉字约一点五个 token 计比较稳妥。

### Q. 什么是上下文窗口？

A：上下文窗口指模型单次推理能处理的最大 token 数量，包含输入提示词和生成内容，超出部分必须截断或另想办法压缩。

### Q. 什么是 KV Cache？

A：KV Cache 把已生成 token 的键值向量缓存下来，避免每生成一个新 token 都重算全部历史，是自回归推理加速的关键手段，代价是显存占用随序列增长。

### Q. 什么是模型量化？

A：量化把模型权重从高精度浮点降到低精度表示，例如降到 8 位或 4 位整数，显著减少显存占用与带宽压力，代价是一定程度的精度损失。

### Q. 什么是知识蒸馏？

A：知识蒸馏用一个能力更强的教师模型指导小模型训练，让小模型在保持较小体积的同时逼近教师模型的表现。

### Q. 什么是 MoE 混合专家架构？

A：MoE 把前馈层拆成多个专家网络，每个 token 只激活其中少数几个专家，从而在总参数量很大的同时保持单次推理的计算量可控。

### Q. 什么是模型幻觉？

A：幻觉指模型生成了看似合理但与事实或给定材料不符的内容，根源在于模型本质是在做概率续写而非事实查询。

### Q. 检索增强为什么能缓解幻觉？

A：检索增强把外部权威材料放进上下文，并要求模型基于材料作答，把开放式生成约束成有依据的归纳，从而降低编造的空间。

### Q. 什么是 SFT 有监督微调？

A：SFT 用人工标注的指令与回答对继续训练基座模型，使其学会遵循指令、按期望的风格作答。

### Q. 什么是 RLHF？

A：RLHF 是基于人类反馈的强化学习，先用人类偏好数据训练奖励模型，再用强化学习优化语言模型使其输出更符合人类偏好。

### Q. 什么是 DPO？

A：DPO 是直接偏好优化，跳过显式训练奖励模型的步骤，直接用偏好数据对语言模型做优化，流程比 RLHF 更简洁稳定。

### Q. 什么是 LoRA 微调？

A：LoRA 冻结原模型权重，只在旁路插入低秩矩阵进行训练，可训练参数量大幅下降，显存需求低，且多个 LoRA 适配器可以按需切换。

### Q. RAG 和微调应该怎么选？

A：知识频繁更新、需要溯源、语料规模大时优先选 RAG；需要改变模型的表达风格、输出格式或掌握无法用文本检索表达的隐性能力时才考虑微调，两者也可以组合使用。

### Q. 什么是长上下文外推？

A：长上下文外推指让模型处理超过训练时见过的序列长度，常见手段包括位置编码插值与继续预训练，但外推后有效注意力质量往往会下降。

### Q. 什么是「中间迷失」现象？

A：研究发现当上下文很长时，模型对开头和结尾的信息利用较好，对中间位置的信息容易忽略，因此重要材料应尽量放在上下文的两端。

### Q. 什么是流式输出？

A：流式输出指模型每生成一部分内容就立即返回给客户端，而不是等全部生成完再返回，能显著降低用户感知到的首字延迟。

### Q. 服务端推送流式内容常用什么协议？

A：常用 Server-Sent Events，它基于 HTTP 长连接单向推送文本事件，实现简单且天然支持断线重连，适合只需服务端到客户端单向流的场景。

### Q. 什么是结构化输出？

A：结构化输出指约束模型按指定的 JSON Schema 或语法生成内容，便于程序直接解析，常见实现方式包括提示词约束、函数调用和约束解码。

### Q. 什么是函数调用（Function Calling）？

A：函数调用让模型在需要外部能力时不直接作答，而是输出一个包含函数名与参数的结构化请求，由应用层执行后把结果回传给模型继续推理。

### Q. 模型是如何知道每个工具参数含义的？

A：应用层会把工具的名称、用途描述和每个参数的类型与说明一并作为工具定义发给模型，模型据此判断何时调用以及如何填参。

### Q. 什么是 ReAct 范式？

A：ReAct 让模型交替输出思考与行动：先推理下一步该做什么，再调用工具获取观察结果，如此循环直到得出最终答案，是工具型智能体最经典的推理模式。

### Q. 什么是思维树（Tree of Thoughts）？

A：思维树让模型在每一步生成多个候选思路并对它们评估打分，像搜索一样在思路空间中回溯与剪枝，适合需要探索的规划类问题。

### Q. 什么是自洽性（Self-Consistency）？

A：自洽性对同一问题采样多条推理路径，取出现次数最多的答案作为最终结果，用多数投票抵消单条推理链的偶然错误。

### Q. 什么是少样本提示？

A：少样本提示在指令中给出若干输入输出示例，让模型从示例中归纳出任务的格式与判断标准，通常给三到五个效果较好。

### Q. 什么是零样本提示？

A：零样本提示只给任务描述不给示例，依赖模型自身的指令遵循能力完成任务，简洁但对复杂格式要求的任务稳定性较差。

### Q. 提示词中角色设定的作用是什么？

A：角色设定通过限定模型的身份与专业背景，收敛它的用词风格、知识范围和回答视角，让输出更贴近特定场景的期望。

### Q. 什么是提示词注入攻击？

A：提示词注入指攻击者在用户输入或外部数据中夹带指令，诱导模型忽略原有的系统约束转而执行攻击者的意图。

### Q. 如何防范提示词注入？

A：常见做法包括把用户输入与系统指令用明确的分隔标记隔离、对输入做敏感模式检测、在输出侧再做一次合规校验，以及最小化模型可调用的高危工具权限。

### Q. 什么是输入护轨与输出护轨？

A：输入护轨在请求进入模型前对用户内容做合规与安全校验，输出护轨在模型返回后对生成内容再做一次检查，两者共同构成安全防线。

### Q. 为什么系统提示词不宜写得过长？

A：系统提示词在每一轮对话中都会随上下文重新发送，长度直接乘以对话轮数转化为成本；同时过长的指令会稀释模型对关键约束的注意力。

### Q. 什么是渐进式披露？

A：渐进式披露指只把简短的能力索引常驻上下文，详细的操作说明在真正需要时才按需加载，用以在能力覆盖面与上下文开销之间取得平衡。

### Q. 什么是提示词模板？

A：提示词模板把提示词中固定的骨架与可变的槽位分离，运行时用实际数据填充槽位，便于复用、版本管理和批量测试。

### Q. 如何让模型在缺少依据时拒绝回答？

A：在系统提示词中显式给出知识边界约束，要求模型只依据提供的材料作答，材料中没有的信息必须明确说明无法回答，并在检索侧配合阈值过滤减少无关材料的干扰。

### Q. 什么是分隔符技巧？

A：分隔符技巧用成对的标记把不同性质的内容包裹起来，例如把检索到的材料与用户问题分开，帮助模型准确区分哪部分是指令、哪部分是数据。

### Q. CO-STAR 框架包含哪些要素？

A：CO-STAR 框架包含背景、目标、风格、语气、受众和响应格式六个要素，用于系统化地组织一段结构完整的提示词。

### Q. 什么是 BLEU 指标？

A：BLEU 通过比较生成文本与参考文本之间的 n-gram 重合度来评分，最早用于机器翻译，对语义等价但用词不同的表述惩罚过重。

### Q. 什么是 ROUGE 指标？

A：ROUGE 系列以召回为导向统计生成文本对参考文本的 n-gram 覆盖情况，常用于摘要任务评估。

### Q. 为什么大模型评测越来越依赖模型作为裁判？

A：传统基于词面重合的指标无法衡量语义等价与推理正确性，用能力更强的模型作为裁判打分与人类判断的一致性更高，代价是评测本身需要消耗模型调用。

### Q. 模型裁判有什么已知偏差？

A：模型裁判存在位置偏好、长度偏好和自我偏好等已知偏差，例如倾向于给更长的答案或与自己风格接近的答案更高分数，需要通过打乱顺序和多次采样缓解。

### Q. 什么是忠实度指标？

A：忠实度衡量生成答案中的每个论断是否都能在给定的上下文中找到依据，用来检测模型有没有编造上下文之外的内容。

### Q. 什么是答案相关性指标？

A：答案相关性衡量答案是否切题、是否直接回应了问题，常见实现是让模型从答案反推出可能的问题，再计算反推问题与原问题的语义相似度。

### Q. 什么是上下文精确率？

A：上下文精确率衡量检索到的片段中相关内容的比例，并且考虑相关片段是否排在靠前位置，反映检索结果的排序质量。

### Q. 什么是上下文召回率？

A：上下文召回率衡量标准答案所需的关键信息是否都被检索出来了，反映检索环节有没有遗漏。

### Q. 评测集中为什么要放负样本？

A：负样本是知识库中确实没有答案的问题，用来检验系统会不会强行编造，衡量拒答能力，通常占测试集总量的一成左右比较合适。

### Q. 什么是误拒率？

A：误拒率指知识库中明明有答案、系统却回答无法回答的比例，它与拒答准确率是一对需要同时观察的指标，只看其一容易被单边优化误导。

### Q. 评测样本量太小会有什么问题？

A：样本量小则指标的置信区间宽，小幅度的差异无法与随机波动区分，容易把噪声当成改进；一般来说样本量越小，能可靠检出的最小差异就越大。

### Q. 什么是配对显著性检验？

A：配对显著性检验在同一批样本上比较两个系统，只统计结果发生变化的样本，比独立比较更敏感，二分类指标常用 McNemar 检验。

### Q. 什么是消融实验？

A：消融实验逐个移除或替换系统中的某个组件，观察指标变化以量化该组件的贡献，是证明「某项优化确实有效」的标准方法。

### Q. 链式消融与正交消融有什么区别？

A：链式消融每一步在上一步基础上叠加，只能看到累积效果；正交消融独立开关每个组件，才能隔离出单个组件的净贡献，代价是实验组合数量更多。

### Q. 什么是指标饱和？

A：指标饱和指某项指标已经逼近理论上限，此后无论系统如何改进数值都几乎不动，该指标便失去了区分能力，需要通过提高任务难度让它重新变得敏感。

### Q. ArrayList 和 LinkedList 的区别是什么？

A：ArrayList 底层是动态数组，随机访问是常数时间但中间插入删除需要搬移元素；LinkedList 底层是双向链表，插入删除快但随机访问需要遍历。实际业务中 ArrayList 适用面广得多。

### Q. HashMap 的底层结构是什么？

A：HashMap 底层是数组加链表，当单个桶内节点数超过阈值且数组长度足够时链表会转成红黑树，把最坏查找复杂度从线性降到对数级。

### Q. HashMap 为什么线程不安全？

A：多线程并发扩容或写入时可能出现数据覆盖与结构破坏，早期版本的头插法扩容甚至会形成环形链表导致死循环，并发场景应使用 ConcurrentHashMap。

### Q. ConcurrentHashMap 是如何保证并发安全的？

A：现代实现用 CAS 加 synchronized 锁住单个桶的头节点，只在发生哈希冲突时才加锁，锁粒度细，并发读完全无锁。

### Q. 什么是 fail-fast 机制？

A：集合在迭代过程中如果检测到结构被修改会立即抛出并发修改异常，通过一个修改计数器实现，目的是尽早暴露问题而不是产生不可预期的结果。

### Q. String、StringBuilder 和 StringBuffer 有什么区别？

A：String 不可变，每次拼接都产生新对象；StringBuilder 可变且非线程安全，性能最好；StringBuffer 可变且方法加了同步，适合多线程共享的极少数场景。

### Q. Java 的 == 和 equals 有什么区别？

A：== 比较的是引用地址或基本类型的值，equals 是对象自己定义的相等语义，重写 equals 时必须同时重写 hashCode 以维持哈希容器的契约。

### Q. 为什么重写 equals 必须重写 hashCode？

A：哈希容器先用 hashCode 定位桶再用 equals 比较，如果两个相等的对象哈希值不同就会落到不同的桶里，导致查找不到已经存入的元素。

### Q. 什么是不可变对象？

A：不可变对象创建后状态不再改变，天然线程安全，可以自由共享和缓存。实现要点是字段私有且终态、不暴露可变内部引用、类本身不可被继承。

### Q. Java 中的深拷贝和浅拷贝有什么区别？

A：浅拷贝只复制对象本身，内部引用仍指向同一批子对象；深拷贝会递归复制所有层级的对象，两份数据完全独立。

### Q. 什么是泛型擦除？

A：Java 泛型只在编译期做类型检查，运行时类型参数被擦除为原始类型，因此无法在运行时获取泛型的实际类型参数，也不能直接创建泛型数组。

### Q. 什么是自动装箱与拆箱？

A：自动装箱把基本类型转换成对应的包装类对象，拆箱则相反。频繁装箱会产生大量临时对象，在循环与集合运算的热点路径上需要留意。

### Q. Integer 缓存机制是怎么回事？

A：包装类对小范围整数做了对象缓存，落在缓存范围内的相同数值装箱后是同一个对象，超出范围则是不同对象，这也是不能用 == 比较包装类数值的原因。

### Q. 什么是 try-with-resources？

A：try-with-resources 让实现了自动关闭接口的资源在语句块结束时自动释放，无论是否发生异常，比手写 finally 关闭更简洁也更不容易遗漏。

### Q. 受检异常与非受检异常有什么区别？

A：受检异常必须在方法签名上声明或就地捕获，编译器强制处理；非受检异常继承自运行时异常，编译器不强制，通常表示程序缺陷而非可恢复的外部状况。

### Q. 什么是 Java Stream？

A：Stream 提供对集合的声明式操作，通过中间操作链与终端操作组合完成过滤、映射、归约，中间操作是惰性的，只有遇到终端操作才真正执行。

### Q. Stream 的 map 和 flatMap 有什么区别？

A：map 对每个元素做一对一转换，flatMap 把每个元素展开成一个流再拼接成一个整体流，常用于把嵌套集合拉平。

### Q. 什么是 Optional？

A：Optional 是一个可能为空的值容器，用来在类型层面表达「可能没有」，引导调用方显式处理空值，减少空指针异常，但不建议用作字段或方法参数。

### Q. 什么是 Java Record？

A：Record 是用于承载不可变数据的紧凑类声明，编译器自动生成构造器、访问器、equals、hashCode 和 toString，适合作数据传输对象。

### Q. 什么是密封类（sealed class）？

A：密封类显式限定哪些类可以继承它，使继承关系在编译期完全可知，便于与模式匹配配合做穷尽性检查。

### Q. 什么是虚拟线程？

A：虚拟线程是由运行时调度的轻量级线程，创建成本极低，阻塞时会自动让出底层载体线程，非常适合高并发的阻塞式 IO 场景。

### Q. synchronized 和 ReentrantLock 有什么区别？

A：synchronized 是语言关键字，加解锁由运行时自动完成；ReentrantLock 是类库实现，支持可中断获取、超时获取、公平锁和多个条件变量，灵活但必须手动释放。

### Q. 什么是 volatile 关键字？

A：volatile 保证变量的可见性与禁止指令重排序，但不保证复合操作的原子性，适合状态标志位这类单写多读的场景。

### Q. 什么是 CAS？

A：CAS 是比较并交换，它在硬件层面原子地完成「若当前值等于预期值则更新」的操作，是无锁并发的基础，但存在 ABA 问题和自旋开销。

### Q. 什么是线程池的核心参数？

A：线程池的关键参数包括核心线程数、最大线程数、空闲存活时间、任务队列和拒绝策略，队列容量与最大线程数的搭配决定了流量突增时的行为。

### Q. 为什么不建议用无界队列的线程池？

A：无界队列会让任务无限堆积，最大线程数形同虚设，内存持续增长直至溢出，且故障时难以感知，生产环境应使用有界队列配合明确的拒绝策略。

### Q. 什么是 ThreadLocal？

A：ThreadLocal 为每个线程维护一份独立的变量副本，常用于传递请求级上下文。在线程池场景下必须在任务结束时清理，否则会污染下一个复用该线程的任务。

### Q. ThreadLocal 为什么可能造成内存泄漏？

A：ThreadLocalMap 的键是弱引用而值是强引用，键被回收后值仍挂在线程上，线程长期存活时这些值无法释放，因此使用后必须显式移除。

### Q. 什么是 CompletableFuture？

A：CompletableFuture 提供了组合式的异步编程能力，可以串联、并联多个异步任务并统一处理异常，比裸用 Future 的阻塞式获取灵活得多。

### Q. 什么是 JVM 的类加载过程？

A：类加载依次经历加载、验证、准备、解析和初始化五个阶段，其中准备阶段为静态变量分配内存并设零值，初始化阶段才执行静态代码块与赋值。

### Q. 什么是双亲委派模型？

A：类加载器收到加载请求时先委派给父加载器，父加载器无法完成才自己尝试，这样保证核心类库不会被应用代码替换，维持了类型体系的安全与一致。

### Q. JVM 的堆内存是如何划分的？

A：堆通常划分为新生代与老年代，新生代又分为一个 Eden 区和两个 Survivor 区，对象优先在 Eden 分配，多次存活后晋升到老年代。

### Q. 什么是垃圾回收的可达性分析？

A：可达性分析从一组根对象出发遍历引用链，无法从根到达的对象判定为可回收。根集合包括栈上局部变量、静态字段和常量引用等。

### Q. 什么是 Stop The World？

A：垃圾回收的某些阶段需要暂停全部应用线程以保证一致性快照，这段暂停就是 Stop The World，暂停时长直接影响服务的响应延迟。

### Q. G1 垃圾回收器的特点是什么？

A：G1 把堆划分成大量等大的区域，按回收收益优先处理垃圾最多的区域，并支持设置期望的最大暂停时间，适合大堆且对延迟有要求的服务。

### Q. 什么是内存溢出与内存泄漏的区别？

A：内存溢出是申请内存时已无可用空间而抛出错误；内存泄漏是对象已无业务用途却仍被引用无法回收，泄漏长期累积往往最终导致溢出。

### Q. 什么是反射？

A：反射允许程序在运行时获取类的结构信息并动态创建对象、调用方法、访问字段，是框架实现依赖注入与动态代理的基础，代价是性能开销和绕过编译期检查。

### Q. 什么是动态代理？

A：动态代理在运行时生成代理类，把对目标方法的调用转发到统一的处理器，从而在不修改原代码的前提下织入横切逻辑，是面向切面编程的常见实现方式。

### Q. 什么是注解处理器？

A：注解处理器在编译期扫描源码中的注解并生成额外的源文件，很多样板代码消除类库就是靠它在编译期自动生成方法实现的。

### Q. Java 中的 SPI 机制是什么？

A：SPI 通过在指定目录下声明接口的实现类全限定名，让运行时能够动态发现并加载实现，是很多框架实现可插拔扩展的标准做法。

### Q. 什么是控制反转（IoC）？

A：控制反转把对象的创建与依赖装配的控制权从业务代码交给容器，业务代码只声明需要什么，由容器负责提供，从而降低组件之间的耦合。

### Q. 什么是依赖注入？

A：依赖注入是控制反转的具体实现方式，容器把被依赖的对象通过构造器、Setter 或字段注入给使用方，常见推荐做法是构造器注入。

### Q. 为什么推荐构造器注入？

A：构造器注入能保证依赖在对象构建完成时就已就绪且可以声明为终态字段，天然支持不可变性，也便于在单元测试中直接传入替身对象。

### Q. Bean 的默认作用域是什么？

A：默认作用域是单例，容器中该类型只维护一个实例并被所有依赖方共享，因此单例 Bean 中不应保存请求级的可变状态。

### Q. Bean 的生命周期包含哪些阶段？

A：依次是实例化、属性填充、各类感知接口回调、初始化前后置处理、执行初始化方法、投入使用，容器关闭时执行销毁回调。

### Q. 什么是面向切面编程（AOP）？

A：面向切面编程把日志采集、事务、权限这类横切关注点从业务逻辑中抽离，通过切点表达式声明在哪些方法上织入，避免重复代码散落各处。

### Q. AOP 的常见通知类型有哪些？

A：常见通知包括前置通知、后置通知、返回通知、异常通知和环绕通知，其中环绕通知能力最强，可以完全控制目标方法是否执行以及返回值。

### Q. 声明式事务是如何生效的？

A：声明式事务基于动态代理，代理对象在调用目标方法前后开启与提交事务。因此同类内部方法直接调用不会经过代理，事务注解会失效。

### Q. 事务传播行为有哪些常见取值？

A：常见取值包括加入当前事务、新开独立事务、以非事务方式执行、嵌套事务等，用于描述一个事务方法被另一个事务方法调用时的行为。

### Q. 事务在什么情况下不会回滚？

A：默认只有运行时异常和错误会触发回滚，受检异常需要显式声明；此外异常被捕获后没有重新抛出，或方法未经过代理，事务同样不会回滚。

### Q. 什么是条件装配？

A：条件装配根据类路径上是否存在某个类、配置项是否满足某个值等条件决定是否注册 Bean，是自动配置能够按需生效的核心机制。

### Q. 自动配置是如何工作的？

A：启动时扫描依赖中声明的自动配置类清单，逐个按条件判断是否生效，生效的配置类再按条件注册各自的 Bean，从而实现引入依赖即可用。

### Q. 什么是配置属性绑定？

A：配置属性绑定把配置文件中某个前缀下的键值批量映射到一个 Java 对象的字段上，支持松散命名匹配、类型转换和校验注解。

### Q. 多环境配置是如何组织的？

A：通过 profile 机制把不同环境的差异项拆到独立的配置文件中，启动时激活对应的 profile，公共配置放在主配置文件里共享。

### Q. 什么是全局异常处理？

A：全局异常处理通过一个统一的通知类拦截控制器抛出的异常，转换成规范的响应结构返回，避免异常堆栈直接暴露给调用方，也避免每个接口重复写捕获逻辑。

### Q. 什么是拦截器与过滤器的区别？

A：过滤器属于 Servlet 规范，作用于请求进入应用的最外层；拦截器由框架管理，能拿到具体的处理器方法信息，也能使用容器中的 Bean。

### Q. 什么是跨域资源共享（CORS）？

A：浏览器出于同源策略限制跨域请求，CORS 通过服务端返回一组响应头声明允许哪些来源、方法和请求头访问资源，从而有条件地放开限制。

### Q. 为什么允许携带凭证时不能把允许来源设为通配符？

A：携带凭证意味着跨域请求会带上 Cookie，此时若允许任意来源访问，任何网站都能以用户身份调用接口，因此规范要求必须显式列出具体来源。

### Q. 什么是 Actuator 端点？

A：Actuator 提供一组运维端点用于查看应用健康状态、配置属性、指标数据等，生产环境应只暴露必要端点并做好访问控制。

### Q. 什么是响应式编程？

A：响应式编程以异步数据流为核心，通过声明式的操作符组合处理流上的元素，配合背压机制协调生产与消费速度，适合高并发的 IO 密集型场景。

### Q. 阻塞式与响应式栈可以混用吗？

A：可以但需谨慎，在响应式链路中执行阻塞调用会占用有限的事件循环线程，必须切换到专门的弹性调度器上执行，否则会拖垮整个服务的吞吐。

### Q. 什么是数据库索引？

A：索引是为加速查询建立的额外数据结构，用空间与写入开销换取查询速度，常见形态是平衡树，能把全表扫描降为对数级查找。

### Q. 什么是回表？

A：当二级索引上的信息不足以满足查询时，需要再拿主键回到主索引取完整行数据，这个过程称为回表，可以通过覆盖索引避免。

### Q. 什么是覆盖索引？

A：覆盖索引指查询所需的全部字段都包含在索引中，无需回表即可返回结果，是常见的查询优化手段。

### Q. 什么是最左前缀原则？

A：复合索引按字段顺序组织，查询条件必须从最左字段开始连续匹配才能用上索引，跳过前面的字段会导致索引失效。

### Q. 什么情况下索引会失效？

A：对索引列使用函数或运算、隐式类型转换、以通配符开头的模糊匹配、以及优化器判断全表扫描更划算时，索引都可能不被使用。

### Q. 什么是事务的 ACID 特性？

A：原子性保证操作要么全成功要么全回滚，一致性保证事务前后数据满足约束，隔离性保证并发事务互不干扰，持久性保证提交后的数据不会丢失。

### Q. 什么是脏读、不可重复读和幻读？

A：脏读是读到别的事务未提交的修改，不可重复读是同一事务内两次读同一行结果不同，幻读是同一查询条件两次返回的行数不同。

### Q. 什么是 MVCC？

A：多版本并发控制为每行数据保留多个版本，读操作访问符合可见性规则的历史版本，从而实现读不阻塞写、写不阻塞读。

### Q. 什么是 PostgreSQL 的 VACUUM？

A：由于多版本机制会留下不再可见的旧行版本，VACUUM 负责回收这些死元组占用的空间并更新统计信息，长期不执行会导致表膨胀与查询变慢。

### Q. PostgreSQL 的 GIN 索引适合什么场景？

A：GIN 是通用倒排索引，适合一个字段包含多个可检索元素的场景，例如数组包含查询、JSONB 键值查询和全文检索。

### Q. PostgreSQL 的 GiST 索引适合什么场景？

A：GiST 是通用搜索树框架，适合几何数据、范围类型和全文检索等无法用普通比较运算排序的数据类型。

### Q. PostgreSQL 的 BRIN 索引适合什么场景？

A：BRIN 为每个数据块范围保存摘要信息，索引体积极小，适合按插入顺序天然有序的超大表，例如按时间递增的日志类数据。

### Q. 什么是 JSONB 类型？

A：JSONB 以二进制形式存储 JSON，支持键值索引和丰富的操作符，读取和查询性能优于文本形式的 JSON，代价是写入时需要解析开销。

### Q. EXPLAIN 和 EXPLAIN ANALYZE 有什么区别？

A：EXPLAIN 只输出优化器估算的执行计划，EXPLAIN ANALYZE 会真正执行语句并给出实际耗时与行数，便于对比估算与实际的偏差。

### Q. 什么是表分区？

A：表分区把一张逻辑大表按范围、列表或哈希拆成多个物理子表，查询时可以裁剪掉无关分区，同时便于按分区维度做归档与删除。

### Q. 什么是连接池？

A：连接池预先建立并复用数据库连接，避免每次请求都承担握手与认证开销，同时通过上限控制保护数据库不被过多连接压垮。

### Q. 连接池的最大连接数应该如何设置？

A：并非越大越好，超过数据库能有效并行处理的能力后，更多连接只会加剧上下文切换与锁竞争，通常应结合数据库的核心数与实际压测结果确定。

### Q. 什么是慢查询？

A：执行时间超过设定阈值的查询即为慢查询，通常通过开启慢查询记录定位，再结合执行计划分析是缺索引、数据量过大还是语句写法问题。

### Q. 什么是 SQL 注入？

A：SQL 注入指攻击者把恶意片段拼进 SQL 语句改变原有语义，根本的防范方式是使用参数化查询让数据与语句结构彻底分离。

### Q. 表名不能参数化时应该怎么办？

A：占位符只能用于数据值不能用于标识符，表名等标识符若必须动态拼接，应当对其做严格的白名单或正则校验后再拼入语句。

### Q. Redis 有哪些常用数据结构？

A：常用的有字符串、哈希、列表、集合、有序集合，此外还有位图、基数统计、地理位置和流等扩展结构。

### Q. Redis 为什么快？

A：数据全部在内存中操作、核心处理采用单线程避免锁竞争与上下文切换、使用高效的数据结构与 IO 多路复用，共同带来了很高的吞吐。

### Q. Redis 的持久化方式有哪些？

A：一种是定期生成内存快照，恢复快但可能丢失最后一段时间的数据；另一种是追加写命令日志，数据更完整但文件更大恢复更慢，两者可以同时开启。

### Q. 什么是缓存穿透？

A：缓存穿透指查询一个数据库中也不存在的键，导致每次请求都击穿缓存打到数据库，常用空值缓存或布隆过滤器防范。

### Q. 什么是缓存击穿？

A：缓存击穿指某个热点键恰好过期，大量并发请求同时涌向数据库，可以通过互斥重建或热点键不过期来缓解。

### Q. 什么是缓存雪崩？

A：缓存雪崩指大量键在同一时刻集中过期或缓存服务整体不可用，导致数据库瞬时压力激增，常用随机过期时间与多级缓存防范。

### Q. Redis 的过期键是如何删除的？

A：采用惰性删除与定期抽样删除相结合的策略，访问到已过期的键时删除，同时后台定时随机抽查一部分键清理，兼顾及时性与性能。

### Q. Redis 的内存淘汰策略有哪些？

A：包括不淘汰直接报错、在设置了过期时间的键中淘汰最久未使用或最少使用的、在全部键中淘汰、以及随机淘汰等多种策略。

### Q. 如何用 Redis 实现分布式锁？

A：用带过期时间的原子写入命令抢占锁并记录唯一标识，释放时通过脚本校验标识后再删除，避免误删他人持有的锁，同时需要考虑锁续期问题。

### Q. 什么是 Redis 管道？

A：管道把多条命令一次性发送到服务端再统一读取响应，减少往返次数，在批量操作场景下能显著降低总耗时。

### Q. Redis 主从复制的作用是什么？

A：主从复制把主节点的数据同步到从节点，用于读写分离分担读压力，同时作为数据冗余提高可用性。

### Q. 什么是 Redis 哨兵？

A：哨兵负责监控主从节点健康状况，主节点失效时自动选举并提升一个从节点为新主，同时通知客户端更新连接目标。

### Q. Redis 集群是如何分片的？

A：集群把键空间划分为固定数量的槽位，每个节点负责其中一部分，客户端根据键计算槽位后直接路由到对应节点。

### Q. 为什么用 Redis 而不用关系型数据库存会话状态？

A：会话状态读写频繁、生命周期短、天然适合键值模型且需要自动过期能力，内存数据库在延迟和过期管理上都远优于关系型数据库。

### Q. Docker 镜像的分层机制是什么？

A：镜像由多个只读层叠加而成，每条构建指令生成一层，相同的层可以在不同镜像间共享，容器运行时在最上方叠加一个可写层。

### Q. 如何减小 Docker 镜像体积？

A：常见手段包括使用精简的基础镜像、采用多阶段构建只把产物拷进最终镜像、合并指令减少层数、以及清理构建过程中的临时文件与缓存。

### Q. 什么是多阶段构建？

A：多阶段构建在同一个构建文件中定义多个阶段，前面的阶段负责编译打包，最后的阶段只从前序阶段拷贝必要产物，从而剥离掉全部构建工具链。

### Q. Docker 的数据卷有什么用？

A：数据卷把容器内的目录映射到宿主机或专用存储上，使数据独立于容器生命周期存在，容器重建后数据不丢失。

### Q. 为什么建议容器内用非 root 用户运行应用？

A：容器内的 root 在某些配置下可能突破隔离影响宿主机，使用普通用户运行可以缩小攻击面，同时避免挂载卷产生的文件属主混乱。

### Q. 容器的时区为什么需要单独设置？

A：精简基础镜像通常不携带时区数据，默认按世界协调时运行，若应用会输出或存储本地时间，就必须显式安装时区数据并设置环境变量。

### Q. 什么是容器健康检查？

A：健康检查通过周期性执行指定命令判断容器内应用是否真正可用，比单纯的进程存活判断更准确，编排系统可据此自动重启或摘除流量。

### Q. 什么是容器编排？

A：容器编排负责在集群范围内调度容器、维持期望副本数、提供服务发现与负载均衡、执行滚动更新与故障自愈。

### Q. HTTP 状态码 4xx 和 5xx 分别代表什么？

A：4xx 表示客户端错误，请求本身有问题；5xx 表示服务端错误，请求合法但服务处理失败。区分二者对定位责任方很重要。

### Q. HTTP 幂等性指什么？

A：幂等指同一请求执行一次与执行多次对服务端状态的影响相同。查询、替换和删除通常设计为幂等，新建操作一般不幂等，需要额外的去重手段。

### Q. 什么是 HTTPS 的握手过程？

A：握手阶段双方协商加密套件、服务端出示证书供客户端验证身份、通过非对称加密协商出会话密钥，之后的通信使用对称加密提高效率。

### Q. 什么是 JWT？

A：JWT 是一种自包含的令牌格式，由头部、载荷和签名三段组成，服务端凭签名验证真伪而无需查询存储，代价是签发后难以主动撤销。

### Q. 什么是 OAuth 2.0 的授权码模式？

A：授权码模式先由用户在授权服务器完成认证并返回一个一次性授权码给客户端，客户端再用授权码到后端换取访问令牌，避免令牌经过浏览器暴露。

### Q. 什么是限流？

A：限流通过限制单位时间内的请求量保护后端资源，常见算法包括固定窗口、滑动窗口、漏桶和令牌桶，其中令牌桶允许一定程度的突发。

### Q. 什么是熔断？

A：熔断在下游持续失败达到阈值时快速切断调用直接返回失败，避免请求堆积拖垮上游，经过冷却期后再放少量流量试探恢复情况。

### Q. 什么是 CAP 定理？

A：分布式系统在网络分区发生时无法同时保证一致性与可用性，只能二选一，因此实际系统的设计本质上是在这两者之间做取舍。

### Q. 什么是幂等消费？

A：消息中间件通常只能保证至少投递一次，因此消费端必须能够识别重复消息并保证重复处理不产生副作用，常用唯一业务标识加去重表实现。

### Q. 什么是死信队列？

A：死信队列收纳那些多次消费失败或过期无法处理的消息，避免它们无限重试阻塞正常队列，同时保留现场供人工排查。

### Q. Kafka 是如何保证分区内有序的？

A：同一分区内的消息按写入顺序追加并按顺序消费，因此只要把需要保序的消息用同一个键路由到同一分区即可保证局部有序。

### Q. 什么是二分查找？

A：二分查找在有序序列上每次取中间元素与目标比较，据此把搜索范围减半，时间复杂度为对数级，前提是数据必须有序且支持随机访问。

### Q. 什么是动态规划？

A：动态规划把问题分解成相互重叠的子问题，通过保存子问题的解避免重复计算，适用于具备最优子结构与重叠子问题特征的场景。

### Q. 什么是布隆过滤器？

A：布隆过滤器用多个哈希函数把元素映射到位数组上，能以极小的空间判断元素「一定不存在」或「可能存在」，存在可控的误判率但没有漏判。

### Q. 什么是一致性哈希？

A：一致性哈希把节点和数据都映射到一个环形空间上，数据归属顺时针方向最近的节点，节点增减时只影响相邻区间的数据，大幅减少再平衡量。

### Q. 什么是 LRU 缓存淘汰算法？

A：最近最少使用算法在缓存满时淘汰最久没有被访问的条目，通常用哈希表配合双向链表实现，使查找与更新都保持常数时间。

### Q. Git 的 merge 和 rebase 有什么区别？

A：merge 保留完整的分支拓扑并产生一个合并提交，rebase 把提交逐个重放到目标分支顶端形成线性历史，已推送到共享分支的提交不应 rebase。

### Q. 什么是持续集成？

A：持续集成让开发者频繁把代码合入主干，每次合入自动触发构建与自动化验证，尽早暴露集成冲突与缺陷，缩短问题的发现周期。

### Q. 什么是蓝绿部署？

A：蓝绿部署准备两套完全对等的环境，新版本先在闲置环境部署验证，确认无误后把流量整体切过去，出问题可以迅速切回。

### Q. 什么是灰度发布？

A：灰度发布让新版本先承接一小部分流量，观察指标正常后逐步扩大比例，把故障影响面控制在可接受范围内。

### Q. 什么是单例模式？

A：单例模式保证一个类在进程内只有一个实例并提供全局访问点，常见实现有饿汉式、双重检查加锁和静态内部类，枚举实现天然防反射与反序列化破坏。

### Q. 什么是工厂模式？

A：工厂模式把对象创建的逻辑集中到工厂里，调用方只依赖抽象类型不关心具体实现，便于在不改动调用方的前提下替换实现。

### Q. 什么是建造者模式？

A：建造者模式把复杂对象的构造过程拆成一系列可选步骤，用链式调用逐项设置后统一构建，适合参数多且大部分可选的场景。

### Q. 什么是策略模式？

A：策略模式把一族可互换的算法各自封装成独立类，运行时按需选用，用组合替代大量条件分支，新增策略无需修改已有代码。

### Q. 什么是模板方法模式？

A：模板方法在父类中定义算法骨架并把可变步骤留作抽象方法交给子类实现，保证流程一致的同时允许局部定制。

### Q. 什么是观察者模式？

A：观察者模式让多个订阅者注册到主题上，主题状态变化时逐一通知，实现发布方与订阅方的解耦，事件总线与监听器机制都基于此。

### Q. 什么是装饰器模式？

A：装饰器模式通过包装同接口的对象逐层附加职责，在不修改原类也不使用继承的前提下动态扩展行为。

### Q. 什么是适配器模式？

A：适配器模式在两个接口不兼容的组件之间加一层转换，把一方的接口翻译成另一方期望的形式，常用于集成遗留系统或第三方库。

### Q. 什么是代理模式？

A：代理模式为目标对象提供一个替身来控制访问，可以在转发调用前后插入权限校验、缓存、延迟加载等逻辑。

### Q. 什么是责任链模式？

A：责任链把多个处理者串成一条链，请求沿链传递直到被某个处理者消费或走完全链，便于灵活增删处理环节。

### Q. 什么是依赖倒置原则？

A：高层模块不应依赖低层模块，两者都应依赖抽象；抽象不应依赖细节，细节应依赖抽象。这是分层架构保持可替换性的基础。

### Q. 什么是单一职责原则？

A：一个类应当只有一个引起它变化的原因。职责越单一，修改的影响面越小，复用与测试也越容易。

### Q. 什么是开闭原则？

A：软件实体应当对扩展开放、对修改关闭，即通过新增代码而非改动已有代码来应对需求变化，通常依靠抽象与多态实现。

### Q. 什么是里氏替换原则？

A：子类对象必须能够替换父类对象出现在任何使用父类的地方而不破坏程序正确性，这要求子类不得收窄父类的行为契约。

### Q. 什么是接口隔离原则？

A：不应强迫调用方依赖它用不到的方法，宽接口应当拆分成多个更小的专用接口，减少不必要的耦合。

### Q. 什么是迪米特法则？

A：一个对象应当尽量少地了解其他对象，只与直接朋友通信，避免形成长长的调用链，从而降低模块间的耦合度。

### Q. 什么是贫血模型与充血模型？

A：贫血模型的实体只有数据没有行为，业务逻辑集中在服务层；充血模型把与实体密切相关的业务行为内聚到实体自身，更贴近领域驱动设计的主张。

### Q. 什么是领域驱动设计中的限界上下文？

A：限界上下文划定了一个模型有效的边界，同一个名词在不同上下文中可以有不同含义，边界之间通过明确的契约通信。

### Q. 如何查看 Linux 系统的内存使用情况？

A：可以使用查看内存概况的命令得到总量、已用、空闲和缓存的分布，注意缓存部分在需要时可被回收，判断内存是否吃紧应看可用值而非空闲值。

### Q. 如何定位占用 CPU 最高的进程？

A：使用交互式的进程监控命令按 CPU 使用率排序即可，若要进一步定位到线程，可以展开线程视图再结合线程编号在应用侧的线程栈中查找。

### Q. 如何查看端口被哪个进程占用？

A：使用套接字统计命令列出监听中的端口并显示对应进程信息，也可以用文件句柄查看工具按端口过滤。

### Q. 如何查看磁盘空间占用？

A：查看文件系统整体使用率用一个命令，定位具体是哪个目录占了空间则用统计目录大小的命令并按大小排序。

### Q. inode 耗尽会有什么现象？

A：磁盘明明还有剩余空间却提示无法创建文件，通常是因为小文件数量过多耗尽了 inode，需要清理海量小文件或重建文件系统。

### Q. 什么是软链接和硬链接的区别？

A：软链接是一个指向目标路径的独立文件，目标删除后失效；硬链接与原文件共用同一份数据，只要还有一个链接存在数据就不会被释放。

### Q. 什么是 systemd 服务单元？

A：服务单元用配置文件描述一个后台服务的启动命令、依赖关系、重启策略和运行环境，由系统管理器统一托管其生命周期。

### Q. 如何让进程在终端断开后继续运行？

A：可以借助会话保持工具或把进程交给系统服务管理器托管，也可以使用忽略挂断信号的方式启动，生产环境推荐交给服务管理器。

### Q. 什么是文件描述符限制？

A：每个进程能同时打开的文件与套接字数量存在上限，高并发服务常因该上限过低而报出打开文件过多的错误，需要调整系统与进程级别的限制。

### Q. 什么是负载均衡中的健康检查？

A：负载均衡器周期性探测后端实例是否可用，把不健康的实例摘出流量池，恢复后再重新加入，是保障可用性的基础机制。

### Q. 什么是反向代理？

A：反向代理站在服务端一侧接收客户端请求并转发给后端服务，可以统一处理加密卸载、负载分发、缓存和访问控制。

### Q. 什么是防火墙的入站与出站规则？

A：入站规则控制外部能访问本机的哪些端口，出站规则控制本机能主动连接哪些目标，服务器安全加固通常从收紧入站规则开始。

### Q. 为什么不建议开放密码方式的远程登录？

A：公网上的自动化扫描会持续尝试常见口令，密码方式一旦被猜中即完全失守。改用密钥认证并禁用超级用户直接登录可以大幅降低风险。

### Q. 什么是最小权限原则？

A：每个账号、进程和服务只应被授予完成其职责所必需的最小权限，一旦被攻破也能把损失限制在有限范围内。

### Q. 什么是服务发现？

A：服务发现让调用方无需硬编码目标地址，通过注册中心动态获取当前健康的实例列表，实例上下线自动感知。

### Q. 什么是配置中心？

A：配置中心把配置从应用包中剥离出来集中管理，支持按环境隔离、动态推送和变更审计，避免改一个参数就要重新发版。

### Q. 什么是链路追踪？

A：链路追踪为一次请求分配全局唯一标识并在跨服务调用中透传，把分散在各服务的处理片段串成完整调用链，便于定位延迟瓶颈。

### Q. 什么是指标、日志与链路三大可观测性支柱？

A：指标提供聚合的数值趋势适合告警，链路还原单次请求的完整路径适合定位，两者结合再辅以详细的运行记录，才能覆盖从发现问题到定位根因的全过程。

### Q. 什么是拉模式的指标采集？

A：采集端周期性主动请求各个目标暴露的指标接口获取数据，好处是采集端掌握节奏、目标端实现简单，缺点是需要能够网络可达每个目标。

### Q. 什么是时间序列数据库？

A：时间序列数据库针对按时间递增写入、按时间范围查询的负载做了专门优化，通常采用列式存储与高压缩比编码。

### Q. 什么是 PromQL？

A：PromQL 是面向时间序列的查询语言，支持按标签筛选、区间聚合和跨序列运算，常用于计算速率、分位数和比值型指标。

### Q. 为什么监控计数器要配合速率函数使用？

A：计数器是只增不减的累积值，直接绘图只能看到一条上升曲线，必须用速率函数换算成单位时间的增量才能反映实时变化。

### Q. 什么是分位数延迟指标？

A：分位数延迟表示有多少比例的请求快于某个耗时，例如九十九分位反映最慢那百分之一的体验，比平均值更能暴露长尾问题。

### Q. 为什么平均延迟会掩盖问题？

A：平均值会被大量快速请求稀释，即使存在少量极慢请求也难以体现，而这些长尾请求往往正是用户投诉的来源。

### Q. 什么是幂等键？

A：幂等键是客户端为一次业务操作生成的唯一标识，服务端凭它识别重复提交，保证同一操作无论请求多少次只生效一次。

### Q. 什么是最终一致性？

A：最终一致性允许系统在一段时间内各副本数据不一致，但保证在没有新更新的前提下最终收敛到相同状态，是高可用系统常见的取舍。

### Q. 什么是分布式事务的补偿模式？

A：补偿模式把长事务拆成多个本地事务，每步都定义对应的补偿动作，某一步失败时逆序执行前面各步的补偿以回到一致状态。

### Q. 什么是雪崩效应？

A：一个下游服务变慢导致上游线程被大量占用，进而上游也不可用，故障沿调用链逐级放大，最终整个系统瘫痪。

### Q. 什么是舱壁隔离？

A：舱壁隔离为不同的下游依赖分配独立的资源池，某个依赖出问题时只耗尽自己那份资源，不会拖垮调用其他依赖的能力。

### Q. SSE 和 WebSocket 有什么区别？

A：SSE 基于普通 HTTP 只支持服务端到客户端的单向文本推送，实现与调试简单；WebSocket 是全双工二进制协议，适合双向实时交互但需要额外的协议升级与心跳维护。

### Q. 什么是长轮询？

A：长轮询由客户端发起请求后服务端挂起不立即返回，直到有新数据或超时才响应，客户端收到后立刻再发起下一次，是推送能力的兼容性兜底方案。

### Q. RESTful API 的核心设计原则是什么？

A：以资源为中心组织 URL、用标准方法表达操作语义、用状态码表达结果、保持无状态，让接口语义可预测且易于缓存与代理。

### Q. 什么是 API 版本管理？

A：通过在路径、请求头或参数中标注版本，让不兼容的接口变更可以与旧版本并存，给调用方留出迁移窗口。

### Q. 什么是分页的游标方式？

A：游标分页用上一页最后一条记录的排序键作为下一页起点，避免偏移量分页在深翻页时的性能问题，也不会因数据插入导致重复或遗漏。

### Q. 什么是接口的向后兼容？

A：向后兼容指新版本服务仍能正确处理旧版本客户端的请求，常见做法是只新增可选字段、不删除不改语义、不收紧已有校验。

### Q. 什么是防抖与节流？

A：防抖在事件停止触发一段时间后才执行，适合搜索联想；节流在固定间隔内最多执行一次，适合滚动与拖拽这类高频事件。

### Q. 什么是同源策略？

A：同源策略限制不同源的文档或脚本相互访问资源，源由协议、域名和端口三者共同决定，是浏览器最基础的安全机制。

### Q. 什么是 XSS 攻击？

A：跨站脚本攻击把恶意脚本注入到页面中在其他用户浏览器执行，防范核心是对输出做上下文相关的转义，并配合内容安全策略限制脚本来源。

### Q. 什么是 CSRF 攻击？

A：跨站请求伪造诱导已登录用户在不知情的情况下向目标站点发起请求，常用防范手段是校验一次性令牌和限制 Cookie 的跨站发送策略。

### Q. 什么是路径穿越漏洞？

A：当程序用外部输入拼接文件路径且未做校验时，攻击者可以用上级目录符号跳出预期目录读写任意文件，防范方式是规范化路径后校验其仍位于基准目录之内。

### Q. 为什么文件名要做白名单校验？

A：黑名单容易被各种编码与变形绕过，白名单只放行明确符合预期格式的输入，安全边界更清晰，也更容易在评审中确认其正确性。

### Q. 知识库中的一个块应该包含多少内容？

A：理想情况下一个块恰好承载一个完整且自足的知识点。塞进多个主题会让无关内容成为噪声，拆得过碎又会让一个知识点永远只能被召回一半。

### Q. 为什么按标题切分通常优于按固定长度切分？

A：标题是作者显式给出的语义边界，按它切分能让检索单元与知识单元对齐；固定长度切分则可能把一个完整论述从中间截断，导致上下两半都不完整。

### Q. 按标题切分有什么需要注意的边界？

A：需要处理代码块内以井号开头的行被误判为标题的情况，以及单个小节过长时如何二次切分，还要考虑是否保留父级标题路径以维持层级语境。

### Q. 为什么切块时要保留父级标题路径？

A：脱离上下文的块可能丢失关键限定，例如同一个「配置方式」小节在不同父章节下含义完全不同，把标题路径拼到块首能补回这层语境。

### Q. 入库前给文本块加统一前缀有什么风险？

A：对所有块完全相同的前缀不提供任何区分度，却会让全部向量朝同一方向偏移，同时占用短块本就有限的语义容量。

### Q. 知识库中的元数据应该怎么用？

A：元数据适合承载来源文件、章节、更新时间等溯源信息，用于过滤和引用标注，一般不应混入参与向量化的正文。

### Q. 为什么多路检索的去重不能用正文字符串做键？

A：不同检索路返回的同一片段可能在空白字符或后处理上存在细微差异，用正文比对会判为两条，导致同一内容重复进入上下文并重复贡献融合分数。

### Q. 知识库文档更新后需要做什么？

A：需要重新切分并更新向量索引。全量重建简单但成本高，增量更新需要能识别哪些块发生了变化，常用内容摘要值比对实现。

### Q. 为什么应用每次启动都全量重建向量库不是好做法？

A：语料规模稍大时重建会显著拖慢启动，并且每次都要重新支付向量化的调用成本，更好的方式是按内容摘要做增量更新。

### Q. 动态写入知识库时为什么要先写文件再写向量库？

A：文件是可持久化、可人工审阅的事实来源，向量库可以随时从文件重建。先写文件保证即使向量化失败知识也不丢失。

### Q. 知识库支持自然语言写入时有哪些风险？

A：模型写入的内容可能破坏切分格式、与已有条目重复或冲突、混入本应属于会话临时偏好的内容，因此写入前需要查重、格式校验和必要时的人工确认。

### Q. 为什么知识写入工具的校验失败不应该抛异常？

A：对智能体来说校验失败是可恢复的反馈，把错误信息作为工具返回值交还给模型，它可以据此修正后重试；直接抛异常则会中断整轮对话。

### Q. 检索不到内容时应该怎么处理？

A：应当返回空结果并让生成环节明确告知无法回答，而不是硬塞低相关度的片段。给模型喂无关上下文反而会诱发编造。

### Q. 为什么重排序的兜底逻辑可能适得其反？

A：如果设置了相关性阈值却在全部候选都不达标时无条件回退返回若干条，等于让阈值失效，恰好在最该拒答的场景下把噪声送进了上下文。

### Q. 如何为检索链路选择合适的相关性阈值？

A：应当在评测集上扫描一组候选阈值，同时观察拒答准确率与误拒率的变化曲线，选取两者平衡点，而不是凭经验直接拍定一个数值。

### Q. 智能体的记忆和知识库应该如何区分？

A：会话记忆保存当前对话的临时状态，随会话结束失效；知识库保存全局共享的事实，写入后对所有用户生效。用户的临时偏好不应写进知识库。

### Q. 为什么评测链路要刻意绕开会话记忆与工具调用？

A：评测的目的是隔离变量，只反映检索与生成本身的变化。若保留记忆和工具，指标波动会混入这些因素的影响，无法归因到检索优化上。

### Q. 检索系统上线后应该监控哪些指标？

A：至少应监控检索耗时、召回条数分布、命中零结果的比例、重排序后被阈值过滤的比例，以及模型回答中触发拒答的频次。

### Q. 什么是知识库的冷启动问题？

A：系统初期语料稀少，检索经常返回空或低相关结果，此时应当明确告知能力边界并提供补充知识的入口，而不是让模型强行作答。

### Q. 如何评估知识库的覆盖度？

A：可以统计测试集中每个问题命中的块分布，看有多少块从未被任何问题指向，以及是否存在大量问题集中命中同一批块，据此判断语料与问题集是否匹配。

### Q. 什么是代码坏味道？

A：代码坏味道指虽然能运行但预示着设计问题的特征，例如重复代码、过长方法、过大类、过多参数和发散式修改，它们是重构的触发信号。

### Q. 重复代码为什么危险？

A：同一段逻辑存在多份拷贝时，修复缺陷或调整规则必须同时改动所有副本，一旦遗漏就会产生行为不一致的隐蔽缺陷。

### Q. 什么是防御式编程？

A：防御式编程假定外部输入和依赖都可能出错，在边界处做充分校验并给出明确的失败语义，避免错误在系统内部扩散后才暴露。

### Q. 为什么锁要放在共享资源的唯一入口处？

A：如果同一份资源被多处代码各自加锁，而这些锁并非同一个对象，实际上等于没有互斥。把访问收敛到唯一入口才能保证锁真正生效。

### Q. 实例方法上的同步关键字锁的是什么？

A：锁的是当前实例对象。因此两个不同实例上的同名同步方法可以并发执行，若要跨实例互斥必须使用类级别的锁或共享的锁对象。

### Q. 为什么配置项不应硬编码绝对路径？

A：硬编码的本机绝对路径在其他机器和容器环境中不存在，会导致程序无法启动或功能静默失效，应改用相对路径或环境变量并提供合理默认值。

### Q. 代码注释与实现不一致会带来什么问题？

A：过时注释比没有注释更有害，它会误导阅读者做出错误判断，重构时应当把注释视为代码的一部分同步维护。

### Q. 什么是配置与代码分离？

A：把随环境变化的参数从代码中抽离到配置文件或环境变量，使同一份构建产物可以部署到不同环境，是持续交付的基本前提。

### Q. 为什么敏感信息不能提交到代码仓库？

A：仓库历史难以彻底清除，且常被分发和镜像。凭据一旦进入历史即应视为已泄露，必须立即轮换而不是仅仅删除文件。

### Q. 打包分发前应该清理哪些内容？

A：应清理编译产物、本地开发工具生成的配置目录、包含服务器地址或凭据的文件，以及任何与运行无关的临时数据。

### Q. 单字符关键词匹配做内容过滤有什么问题？

A：中文里单字组合能力极强，用单字做包含匹配会大量误伤正常表达，例如技术讨论中的常见术语，应改用词组匹配并配合白名单。

### Q. 什么是可恢复错误与不可恢复错误？

A：可恢复错误调用方有办法应对，例如参数不合法可以修正后重试；不可恢复错误通常意味着系统状态异常，应当快速失败并告警。

### Q. 为什么要区分业务异常与系统异常？

A：业务异常是预期内的规则拒绝，应返回明确提示且无需告警；系统异常代表非预期故障，需要记录完整现场并触发告警，两者混淆会淹没真正的故障信号。

### Q. 什么是接口的幂等设计？

A：幂等设计保证同一请求重复提交不会产生额外副作用，是应对网络重试与用户重复操作的基本要求。

### Q. 代码评审应该重点关注什么？

A：重点关注设计合理性、边界与异常处理、并发与安全隐患，以及可读性和可测试性，格式与风格问题应交给自动化工具处理。

### Q. 什么是元空间？

A：元空间存放类的元数据，使用本地内存而非堆内存，默认可以持续增长，类加载器泄漏时会表现为元空间不断膨胀。

### Q. 什么是直接内存？

A：直接内存由本地方法分配在堆外，常用于零拷贝的网络与文件读写，它不受堆大小限制但受操作系统与参数上限约束，泄漏时堆内看不出异常。

### Q. 如何判断一次垃圾回收是否正常？

A：关注单次暂停时长、回收频率以及回收后老年代占用是否持续上升。若每次回收后占用都比上次高，通常意味着存在内存泄漏。

### Q. 什么是逃逸分析？

A：逃逸分析判断一个对象是否会被方法外部引用，未逃逸的对象可以做栈上分配、标量替换和锁消除，从而减少堆压力。

### Q. 什么是即时编译？

A：即时编译在运行时把被频繁执行的字节码编译成本地机器码并做激进优化，这也是服务需要预热才能达到稳定性能的原因。

### Q. 什么是方法内联？

A：方法内联把被调用方法的代码直接嵌入调用处，消除调用开销并为后续优化创造条件，方法体过大会阻止内联发生。

### Q. 堆转储文件怎么用？

A：堆转储记录了某一时刻堆中所有对象的快照，用分析工具打开后按占用大小排序并沿引用链回溯，即可定位是谁持有了本该释放的对象。

### Q. 什么是线程转储？

A：线程转储记录所有线程当时的调用栈与状态，是排查死锁、线程阻塞和线程数暴涨的首选手段，通常需要间隔采集多份对比。

### Q. 什么是死锁？如何排查？

A：死锁指多个线程互相持有对方需要的锁而永久等待。排查时采集线程转储，工具会直接标出构成环路的线程与锁对象。

### Q. 如何避免死锁？

A：常见做法是让所有线程按统一顺序获取多把锁、使用带超时的获取方式、缩小锁的持有范围，以及尽量用无锁结构替代显式加锁。

### Q. 什么是锁竞争？

A：多个线程频繁争抢同一把锁时，大量时间消耗在等待与唤醒上，表现为 CPU 不高但吞吐上不去，需要通过减小锁粒度或分段来缓解。

### Q. 什么是伪共享？

A：多个线程修改的变量恰好位于同一缓存行时，会导致缓存行在核间反复失效，性能显著下降，可以通过填充使热点变量独占缓存行。

### Q. 什么是内存屏障？

A：内存屏障约束指令重排序并强制刷新缓存，保证屏障两侧的读写在多核环境下具有预期的可见性顺序。

### Q. 什么是 happens-before 关系？

A：happens-before 定义了操作之间的偏序，若 A happens-before B，则 A 的结果对 B 可见。它是判断并发程序正确性的基本工具。

### Q. 什么是无锁队列？

A：无锁队列用原子操作代替互斥锁完成入队出队，避免线程阻塞与上下文切换，在高竞争场景下吞吐更好但实现复杂且需要注意内存回收。

### Q. 什么是读写锁？

A：读写锁允许多个读线程并发持有，写线程独占。适合读多写少的场景，但写线程可能因读线程持续到来而饥饿，需要公平策略缓解。

### Q. 什么是信号量？

A：信号量维护一组许可，线程获取许可才能继续执行，用完归还，常用于限制同时访问某资源的并发数量。

### Q. 什么是倒计时门闩？

A：倒计时门闩让一个或多个线程等待，直到计数减到零才继续，常用于等待一批并行任务全部完成后再汇总结果。

### Q. 什么是自旋锁？

A：自旋锁在获取失败时循环重试而不挂起线程，适合锁持有时间极短的场景，持有时间长时会白白消耗 CPU。

### Q. 什么是原子类？

A：原子类基于比较并交换提供无锁的原子读改写操作，在中低竞争下性能优于加锁，高竞争下可以改用分段累加的变体。

### Q. TCP 三次握手为什么是三次？

A：三次握手确保双方的发送与接收能力都得到确认。两次不足以让服务端确认客户端能收到自己的报文，四次则可以合并为三次，属于冗余。

### Q. TCP 四次挥手为什么比握手多一次？

A：关闭是全双工的，被动关闭方收到关闭请求后可能还有数据要发送，因此确认与自己的关闭请求需要分开发送，无法像握手那样合并。

### Q. 什么是 TIME_WAIT 状态？

A：主动关闭方在最后进入等待状态并保持约两倍报文最大生存时间，用于确保最后的确认能到达对端，并让旧连接的残留报文自然消亡。

### Q. TCP 和 UDP 的核心区别是什么？

A：TCP 面向连接，提供可靠有序的字节流与拥塞控制；UDP 无连接，只做尽力而为的数据报投递，开销小延迟低但不保证可靠与顺序。

### Q. 什么是粘包与拆包？

A：TCP 是字节流协议不保留消息边界，应用层必须自己定义边界，常见做法是固定长度、特殊分隔符或在头部携带长度字段。

### Q. 什么是 Nagle 算法？

A：Nagle 算法把小数据包攒起来合并发送以减少报文数量，但会增加延迟，对实时性要求高的交互式场景通常需要关闭。

### Q. 什么是 IO 多路复用？

A：IO 多路复用让单个线程同时监听多个连接的就绪事件，只在有事件时才处理，用少量线程支撑大量连接，是高并发服务器的基础模型。

### Q. 什么是零拷贝？

A：零拷贝减少数据在内核态与用户态之间的复制次数，直接在内核内完成文件到网卡的传输，显著降低大文件传输的 CPU 开销。

### Q. 什么是 HTTP 长连接？

A：长连接在一次 TCP 连接上串行处理多个请求，避免为每个请求重新握手，是现代 HTTP 的默认行为。

### Q. HTTP/2 相比 HTTP/1.1 改进了什么？

A：引入二进制分帧与多路复用，同一连接上可并行传输多个请求响应，消除队头阻塞；同时支持头部压缩和服务端推送。

### Q. 什么是 DNS 解析过程？

A：客户端依次查询本地缓存、递归解析器、根域名服务器、顶级域服务器和权威服务器，逐级缩小范围直到拿到目标地址。

### Q. 什么是 CDN？

A：内容分发网络把静态资源缓存到靠近用户的边缘节点，用户就近获取从而降低延迟并减轻源站压力。

### Q. 什么是网关超时？

A：网关在等待上游响应超过设定时长后主动断开并返回错误，它保护网关自身资源不被慢请求耗尽，排查时需要区分是上游慢还是网关阈值过低。

### Q. 什么是连接泄漏？

A：程序获取连接后未在所有分支上正确归还，连接池逐渐耗尽最终无法获取新连接，表现为运行一段时间后请求集体超时。

### Q. 什么是哈希冲突？如何解决？

A：不同键映射到同一位置即为冲突，常见解法是链地址法把冲突元素挂成链表或树，以及开放寻址法在数组中另寻空位。

### Q. 什么是负载因子？

A：负载因子是已用槽位与总容量的比值，超过阈值就扩容。它在空间占用与冲突概率之间取平衡，过高会退化查找性能。

### Q. 什么是红黑树？

A：红黑树是一种自平衡二叉查找树，通过节点着色与旋转维持近似平衡，保证查找、插入和删除都是对数级复杂度。

### Q. 什么是 B+ 树？为什么数据库索引常用它？

A：B+ 树是多路平衡查找树，所有数据都在叶子层且叶子间用链表相连。它层数低、单节点承载多个键，能减少磁盘随机访问，且天然支持范围扫描。

### Q. 什么是跳表？

A：跳表在有序链表上叠加多级索引，用概率方式维持平衡，实现比红黑树简单，查找与插入同样是对数级复杂度。

### Q. 什么是堆（优先队列）？

A：堆是一棵完全二叉树且满足父节点优于子节点的性质，可以在常数时间取出极值、对数时间插入和调整，常用于求前 K 大与任务调度。

### Q. 什么是并查集？

A：并查集维护若干不相交集合，支持快速合并两个集合与查询元素所属集合，配合路径压缩与按秩合并后接近常数时间。

### Q. 什么是字典树？

A：字典树按字符逐层组织字符串，公共前缀共享路径，适合前缀匹配与自动补全，代价是空间占用较大。

### Q. 什么是滑动窗口算法？

A：滑动窗口用两个指针维护一段连续区间，随着右指针扩张与左指针收缩动态调整，把很多子串子数组问题从平方级降到线性。

### Q. 什么是双指针技巧？

A：双指针用两个索引以不同规则移动来减少枚举量，常见形态包括对撞指针和快慢指针，广泛用于有序数组与链表问题。

### Q. 什么是贪心算法？

A：贪心算法每步都选当前看起来最优的方案，只有在问题具备贪心选择性质与最优子结构时才能保证全局最优，否则只能得到近似解。

### Q. 什么是回溯算法？

A：回溯通过深度优先搜索枚举所有可能，在发现当前路径不可行时撤销选择返回上一步，常配合剪枝减少搜索空间。

### Q. 时间复杂度中的大 O 表示什么？

A：大 O 描述随输入规模增长时算法耗时的上界增长趋势，忽略常数因子与低阶项，用于比较算法的可扩展性而非绝对速度。

### Q. 什么是空间换时间？

A：通过额外存储中间结果避免重复计算，典型如缓存、预计算索引和记忆化搜索，代价是内存占用上升。

### Q. 什么是稳定排序？

A：稳定排序保证相等元素的相对顺序在排序后不变，在需要按多个关键字依次排序时非常重要。

### Q. 什么是模型推理的批处理？

A：批处理把多个请求合并成一批送进模型一次前向计算，显著提升硬件利用率与吞吐，代价是单个请求的延迟略有增加。

### Q. 什么是连续批处理？

A：连续批处理允许在一批请求生成过程中动态加入新请求、移出已完成请求，避免整批等待最慢的那个，大幅提升在线服务的吞吐。

### Q. 什么是首字延迟？

A：首字延迟指从发出请求到收到第一个输出字符的时间，它直接决定用户的等待感受，流式输出优化的主要就是这个指标。

### Q. 什么是模型服务的并发限制？

A：受显存与计算资源约束，单个模型实例能同时处理的请求数有限，超出后请求进入排队，因此需要在网关侧做限流与排队可见性。

### Q. 调用大模型 API 时为什么要做重试？

A：网络抖动与服务端瞬时限流都可能导致偶发失败，配合指数退避的有限次重试能显著提升成功率，但对非幂等操作要谨慎。

### Q. 什么是指数退避？

A：重试间隔随失败次数指数增长并叠加随机抖动，既给下游恢复时间，又避免所有客户端在同一时刻同步重试造成二次冲击。

### Q. 如何控制大模型的调用成本？

A：常见手段包括压缩提示词、按需加载而非全量常驻、对重复问题做结果缓存、简单任务路由到小模型、以及限制单次输出的最大长度。

### Q. 什么是提示词缓存？

A：部分服务支持缓存提示词中稳定不变的前缀部分，后续请求命中缓存后这部分不再重复计费与重复计算，适合系统提示词较长的场景。

### Q. 什么是语义缓存？

A：语义缓存用向量相似度判断新问题是否与历史问题足够接近，命中则直接复用历史答案，比精确字符串匹配的命中率高得多。

### Q. 什么是模型路由？

A：模型路由根据任务难度把请求分发到不同能力与价格的模型上，简单任务用小模型、复杂任务用大模型，在质量与成本之间取平衡。

### Q. 为什么要给智能体的工具调用设上限？

A：没有上限时模型可能陷入反复调用同一工具的循环，既产生大量成本又无法收敛，应设置最大轮次并在超限时终止并给出提示。

### Q. 智能体的工具描述应该怎么写？

A：描述要明确说明工具的用途、适用与不适用的场景、以及每个参数的含义与取值约束，写得越准确模型误调用的概率越低。

### Q. 为什么工具越多智能体表现反而可能变差？

A：工具定义会占用上下文并增加选择难度，工具数量过多时模型容易选错或漏选，通常需要按场景分组按需加载而非一次性全部暴露。

### Q. 什么是智能体的规划能力？

A：规划指把复杂目标拆解成有序的子任务并决定执行顺序与依赖关系，是区分单轮问答与真正智能体的核心能力之一。

### Q. 什么是智能体的反思机制？

A：反思让智能体在执行后回顾结果、识别错误并调整后续策略，通过反馈闭环提升多步任务的成功率。

### Q. 什么是人在回路？

A：人在回路指在智能体的关键决策点插入人工确认环节，例如执行不可逆操作前必须由人批准，用以控制自动化带来的风险。

### Q. 什么是模型的确定性问题？

A：同样的输入多次调用可能得到不同输出，这给测试与复现带来困难，评测时通常需要多次采样取统计量而非依赖单次结果。

### Q. 如何为大模型应用写自动化验证？

A：对确定性强的环节做精确断言，对生成内容则用规则校验结构、用关键信息点检查覆盖度，必要时引入模型裁判做语义层面的判定。

### Q. 什么是回归评测集？

A：回归评测集是一组固定的代表性用例，每次改动后重跑以确认没有引入退化，它的价值在于稳定而非全面。

### Q. 为什么线上效果和离线评测常常不一致？

A：离线评测集的分布往往窄于真实流量，且不包含多轮上下文、用户表述的多样性与异常输入，因此离线指标只能作为参考而非保证。

### Q. 什么是 ETL？

A：ETL 指抽取、转换、加载三个阶段，把分散异构的原始数据整理成统一结构后载入目标存储，是数据流水线的经典范式。

### Q. 什么是数据倾斜？

A：分布式计算中某些分区的数据量远大于其他分区，导致个别任务成为长尾拖慢整体，常用加盐打散或预聚合缓解。

### Q. 什么是列式存储？

A：列式存储把同一列的数据连续存放，扫描少数列时无需读取整行，且同列数据类型一致压缩率高，适合分析型负载。

### Q. 什么是数据血缘？

A：数据血缘记录一份数据从源头经过哪些加工步骤得到，用于影响分析、问题溯源和合规审计。

### Q. 什么是幂等的数据写入？

A：重复执行同一批写入不会产生重复记录，通常通过唯一约束、按主键覆盖写或先删后插的方式实现，是流水线可重跑的前提。

### Q. CSV 文件处理有哪些常见坑？

A：字段内包含分隔符或换行时必须用引号包裹并转义，直接按行按逗号切分会错位；此外编码不一致与首行是否为表头也是常见问题。

### Q. 什么是数据脱敏？

A：数据脱敏在保留数据可用性的前提下遮蔽敏感信息，常见方式包括掩码、哈希替换和泛化，用于测试环境与对外共享场景。

### Q. 什么是采样偏差？

A：样本的分布与总体不一致时得出的结论无法推广，例如只用活跃用户的数据评估产品，会系统性高估整体满意度。

### Q. 什么是置信区间？

A：置信区间给出参数的一个估计范围，反映抽样带来的不确定性。样本量越小区间越宽，两个系统的区间大幅重叠时不能断言存在差异。

### Q. 为什么小样本上的微小差异不可信？

A：小样本下随机波动的幅度本身就可能超过观察到的差异，此时需要做显著性检验，而不是直接把数值高低当作结论。

### Q. 什么是 A/B 测试？

A：A/B 测试把流量随机分成对照组与实验组，在同一时间窗口内比较指标差异，随机分流消除了混杂因素的影响。

### Q. 什么是辛普森悖论？

A：分组统计中各组都呈现同一方向的趋势，合并后整体趋势却相反，通常源于各组样本量与基线差异悬殊，提示必须分层分析。

### Q. 选择对话模型时应该考虑哪些因素？

A：需要综合考虑指令遵循能力、上下文窗口长度、函数调用支持程度、响应延迟、单位 token 价格以及数据合规要求，很少有单一维度最优的选择。

### Q. 选择 Embedding 模型时应该考虑哪些因素？

A：重点看目标语言上的检索效果、向量维度带来的存储成本、最大输入长度是否覆盖切块长度，以及是否与后续可能更换的模型保持兼容。

### Q. 为什么更换 Embedding 模型后必须重建向量库？

A：不同模型输出的向量位于不同的语义空间，新旧向量之间的距离没有意义，因此必须用新模型对全部语料重新向量化。

### Q. 常见的开源中文文本向量模型有哪几类？

A：大体分为通用语义检索类、面向问答的非对称检索类和多语言类三种，选型时应当用自己的真实语料做评测而不是只看公开榜单。

### Q. 公开评测榜单上的分数可以直接照搬吗？

A：不能。榜单语料与实际业务语料的分布往往差异很大，且部分模型存在针对榜单过拟合的情况，选型必须在自己的数据上复测。

### Q. 如何锁定第三方依赖的版本？

A：应在构建文件中显式声明确切版本而非使用动态范围，并把版本集中在统一的属性或依赖管理段落中，避免不同模块引入不一致的版本。

### Q. 依赖版本升级需要注意什么？

A：先阅读变更说明确认有无破坏性改动，优先升级补丁版本，跨大版本升级应在独立分支验证，并关注传递依赖是否被动升级。

### Q. 什么是依赖冲突？

A：不同模块引入了同一依赖的不同版本，构建工具按仲裁规则只保留一个，若被舍弃的版本才含有所需类或方法，运行时就会抛出找不到类或方法的错误。

### Q. 对话历史应该保留多少轮？

A：保留轮数需要在上下文连贯性与 token 成本之间权衡，常见做法是设定一个固定的消息条数窗口，超出后丢弃最早的消息或做摘要压缩。

### Q. 什么是对话历史的摘要压缩？

A：当历史超出窗口时，用模型把较早的对话浓缩成一段摘要替代原文，既保留关键信息又显著减少 token 占用，代价是细节丢失。

### Q. 多用户共用一份对话历史会有什么问题？

A：不同用户的上下文互相污染，模型会把别人的信息当成当前用户的背景，既影响回答准确性也构成隐私泄露。

### Q. 会话状态存在本地内存有什么隐患？

A：多实例部署时用户请求可能落到不同实例上导致上下文丢失，且实例重启后历史全部消失，无法水平扩展。

### Q. 会话数据应该设置过期时间吗？

A：应该。会话天然有生命周期，不设过期会导致存储无限增长，通常按业务的合理会话时长设定，并在每次交互时续期。

### Q. 如何为会话生成唯一标识？

A：可以由服务端生成不可预测的随机串，或由客户端提供并在服务端校验归属，关键是保证不同用户与不同会话之间不会碰撞。

### Q. 切块大小设置多少合适？

A：没有普适答案，需要结合文档结构、Embedding 模型的输入长度和单次可放入上下文的块数综合权衡，并用评测集实测确定。

### Q. 切块重叠的作用是什么？

A：重叠让相邻块共享一段边界内容，避免恰好被切断的句子或论述在两个块中都不完整，代价是存储与检索时存在冗余。

### Q. 重叠比例一般取多少？

A：常见做法是取块长度的一到两成，过小起不到弥合作用，过大则冗余明显、检索时容易返回内容高度雷同的相邻块。

### Q. 什么是递归字符切分？

A：递归字符切分按优先级依次尝试段落、句子、词、字符等分隔符，先用粗粒度分隔符切分，超长的部分再用更细的分隔符继续切，直到满足长度约束。

### Q. 为什么长文档需要设置兜底切分？

A：按语义边界切分时个别小节可能远超模型输入上限，需要一个基于长度的兜底策略把超长块继续拆开，否则尾部内容会被静默截断。

### Q. 如何验证切分结果是否符合预期？

A：把切分后的块打印或落盘检查，重点看块数、长度分布、有没有内容被从中间截断，以及是否存在大量空块或极短块。

### Q. 检索返回条数设置多少合适？

A：需要在信息充分与噪声可控之间权衡，条数太少可能漏掉关键依据，太多则稀释注意力并增加成本，通常结合上下文预算与评测结果确定。

### Q. 相似度阈值应该设在什么水平？

A：阈值取决于所用模型的分数分布，不同模型之间不可直接照搬。合理做法是在评测集上观察相关与不相关样本的分数分布，选择两者重叠最小处。

### Q. 为什么不同 Embedding 模型的相似度分数不能直接比较？

A：各模型的向量空间结构与训练目标不同，分数的绝对值缺乏统一含义，只有在同一模型内部做相对比较才有意义。

### Q. 检索返回为空时应该怎么处理？

A：应当把「无检索结果」这一事实明确传递给生成环节并要求如实告知，而不是留空让模型自由发挥，后者极易导致编造。

### Q. 如何判断检索环节是不是瓶颈？

A：把标准答案所需的关键信息与实际召回内容逐条比对，若关键信息根本没被召回则问题在检索侧，若召回了却没被采用则问题在生成侧。

### Q. 工具方法的返回值应该设计成什么样？

A：应返回对模型友好的自然语言描述而非裸数据结构，明确说明执行结果、失败原因以及模型下一步该做什么，便于模型据此继续推理。

### Q. 工具执行失败时应该抛异常还是返回错误信息？

A：对模型可以自行纠正的错误应作为返回值交还给模型；对系统级不可恢复故障才抛出异常中断流程，两者混淆会让智能体失去自愈机会。

### Q. 获取当前时间为什么要作为工具提供？

A：模型自身没有实时时钟，训练数据中的时间也早已过期，涉及当前日期的推理必须通过工具获取真实时间才可靠。

### Q. 发送邮件类的工具需要注意什么？

A：这类工具会产生不可撤销的外部副作用，应当限制收件范围、对内容做校验，必要时引入人工确认，并对调用做完整审计记录。

### Q. 如何避免模型滥用工具？

A：在工具描述中明确写出不适用的场景、限制单轮可调用的工具次数、对高风险工具增加确认环节，并在系统提示词中说明工具与知识边界的关系。

### Q. MCP 的常见传输方式有哪些？

A：常见的有基于标准输入输出的本地进程通信，以及基于 HTTP 的远程通信。前者适合在本机拉起的工具进程，后者适合托管在远端的服务。

### Q. 本地进程方式的 MCP 服务是如何启动的？

A：由客户端在本机拉起一个子进程，双方通过该进程的标准输入输出交换消息，进程生命周期由客户端管理。

### Q. 接入多个 MCP 服务时需要注意什么？

A：需要注意不同服务提供的工具是否重名、总工具数量是否过多影响模型选择、以及某个服务不可用时是否会阻塞整体初始化。

### Q. MCP 相比直接写工具方法有什么优势？

A：MCP 把工具实现与调用方解耦成独立进程或服务，可以跨语言复用、独立升级，并形成可共享的生态，代价是多了一层通信开销。

### Q. 使用第三方 MCP 服务有什么风险？

A：第三方服务可能读取传入的数据、返回诱导性内容影响模型判断，也可能不稳定或停止维护，接入前需要评估其权限范围与可信度。

### Q. 输入护轨应该在什么位置生效？

A：应在请求进入模型之前拦截，越早拦截消耗越小；同时要注意护轨本身不应成为性能瓶颈，复杂判定可以分级处理。

### Q. 敏感词过滤为什么容易误伤？

A：自然语言中同一个字词在不同语境下含义差别巨大，基于字面的匹配无法感知语境，因此单纯的关键词表在中文场景下误判率很高。

### Q. 如何降低内容过滤的误伤率？

A：可以用更长的词组替代单字、维护白名单豁免专业术语、按场景分级处理，必要时引入语义分类模型替代纯规则匹配。

### Q. 输出侧的合规检查应该查什么？

A：重点检查是否泄露了系统提示词与内部配置、是否输出了敏感个人信息、是否包含违规内容，以及是否偏离了既定的角色设定。

### Q. 为什么系统提示词本身也需要保护？

A：系统提示词包含业务规则与安全约束，一旦被诱导输出，攻击者就能针对性地设计绕过方式，因此应当在输出侧明确禁止复述。

### Q. 大模型应用应该采集哪些核心指标？

A：至少应包括调用次数、成功与失败次数、端到端耗时分布，以及输入输出的 token 用量，后者直接对应成本。

### Q. 为什么 token 用量要区分输入与输出分别统计？

A：两者的计价通常不同，且优化手段完全不同：输入侧靠精简提示词与缓存，输出侧靠限制最大长度与调整回答风格，混在一起统计无法指导优化。

### Q. 指标应该打哪些标签维度？

A：常见维度包括模型名称、调用来源、用户或租户标识以及成功失败状态，但标签取值过多会导致时间序列爆炸，需要控制基数。

### Q. 什么是指标基数爆炸？

A：把高基数字段作为标签会产生海量时间序列，撑爆存储与查询性能，因此用户标识这类字段通常不适合直接作为指标标签。

### Q. 请求级上下文如何传递给指标采集？

A：常见做法是在请求入口把上下文放进线程本地存储，采集点直接读取。关键是必须在请求结束时清理，否则线程复用会导致数据串号。

### Q. 为什么清理上下文要放在 finally 中？

A：业务逻辑抛出异常时正常路径上的清理语句不会执行，残留的上下文会污染下一个复用该线程的请求，只有 finally 能保证一定执行。

### Q. 响应式链路中的上下文应该在哪里清理？

A：响应式链路的执行与订阅可能不在同一线程，需要在流的终止回调中清理，而不能依赖方法返回后的同步代码。

### Q. 容器化部署时配置应该怎么传入？

A：优先通过环境变量注入，其次是挂载配置文件。把配置烤进镜像会让同一镜像无法跨环境复用，违背构建一次到处运行的原则。

### Q. 容器内的可写数据应该放在哪里？

A：应放在挂载的数据卷中而不是容器内的普通目录，否则容器重建后数据丢失，这对需要持久化用户产出的功能尤其关键。

### Q. 为什么容器启动脚本常用不覆盖的方式拷贝初始文件？

A：镜像内自带一份初始数据，启动时只在目标目录缺少对应文件时才拷入，这样既保证首次启动可用，又不会覆盖用户后续产生的数据。

### Q. 服务端口需要在哪些地方开放？

A：至少包括宿主机防火墙、云厂商的安全组，以及容器的端口映射，三者任一未放通都会导致外部无法访问。

### Q. 生产环境应该激活哪套配置？

A：应使用与开发环境隔离的独立配置，其中数据库地址、凭据、文件路径和日志输出等都指向生产资源，绝不能复用开发配置。

### Q. 为什么开发配置中的本机路径在服务器上会出问题？

A：开发机上的路径在服务器文件系统中并不存在，程序启动时可能直接失败，更隐蔽的情况是运行时写入失败而功能表面正常。

### Q. 提示词中的输出格式约束怎么写才有效？

A：给出明确的结构示例比抽象描述有效得多，必要时配合结构化输出能力做强约束，并在应用侧对解析失败做兜底处理。

### Q. 如何让模型的回答保持稳定的风格？

A：在系统提示词中固定角色、语气和篇幅要求，并给出一到两个符合期望的示例，比单纯用形容词描述风格有效。

### Q. 提示词写得越详细越好吗？

A：并非如此。过长的提示词会稀释关键约束的权重、增加每轮成本，且相互冲突的规则会让模型行为变得不可预测，应当精简并排除歧义。

### Q. 如何测试提示词的改动效果？

A：准备一组覆盖典型与边界场景的固定用例，改动前后各跑一遍对比，避免仅凭一两个例子的主观感受下结论。

### Q. 为什么提示词中的规则之间可能相互冲突？

A：不同时期为不同问题追加的规则容易在边界场景上相互矛盾，例如既要求严格依据材料作答又希望主动调用工具，需要显式说明两者的适用范围。

### Q. 技能与提示词的本质区别是什么？

A：提示词每轮都随上下文发送，技能只在命中时才加载；提示词多用于约束风格，技能更适合封装特定场景下的操作规程，且技能可以独立版本化演进。

### Q. 技能的元数据描述应该怎么写？

A：描述要准确覆盖触发场景并明确排除不适用的情况，因为模型正是靠这段简短描述判断要不要展开完整说明，写得含糊会导致该触发时不触发。

### Q. 技能正文应该包含什么？

A：应包含为什么需要这套流程、适用与不适用的边界、可执行的分步操作、失败时的处理方式，以及一到两个完整示例。

### Q. 为什么技能要配合服务端校验？

A：技能说明只是对模型的指导，模型未必严格遵守，服务端必须对关键约束做强制校验兜底，两侧规则应保持一致。

### Q. 如何衡量技能机制带来的收益？

A：可以统计技能的触发频率与总请求数的比值，未触发的那部分请求就是节省下来的加载开销，据此换算相比全量常驻方案省下的 token 量。

### Q. 只有一个技能时有必要引入这套机制吗？

A：收益主要体现在避免长指令常驻上下文，而非技能数量。若机制本身实现成本低且扩展为零成本，早期引入是合理的，但不必夸大其规模效应。

### Q. rerank 用的模型是什么？阈值是多少？

A：rerank 使用的模型是 qwen3-rerank，相似度阈值设为 0.2。

### Q. 千言项目为什么把段落切分换成了标题切分？

A：千言的知识库是一个 Q&A 问答库，每一条知识天然就是一个 ### 三级标题。标题切分能保证一块恰好是「一问一答」，长答案不会被拦腰截断，短问答也不会两条挤进同一块，每块只讲一件事，语义干净聚焦，embedding 建得更准；而且每块开头就是那个问题，和用户提问更容易匹配上。相比之下固定切分只按字数切、完全不看内容，容易把一条答案切碎或把不相关内容混进同一块，反而拖低检索质量。

### Q. MarkdownHeadingSplitter 这个类是怎么实现按标题切分的？

A：MarkdownHeadingSplitter 实现 langchain4j 的 DocumentSplitter 接口，构造参数为 headingLevel、maxCharsPerSegment 和 subSplitter。split 方法用 document.text().split("\n", -1) 逐行扫描，遇到标题行且当前缓冲区非空就 flush 出一个 TextSegment；isHeading 判断行首去掉空格后恰好以 headingPrefix 开头且不以再多一个井号开头，从而排除四级及更深标题；flush 时若内容长度超过 maxCharsPerSegment 且 subSplitter 不为空，就交给 subSplitter 二次细分，并复用原文档的 metadata 让细分片段也带着 file_name 来源信息。

### Q. 千言项目里 MarkdownHeadingSplitter 的三个参数各设成了多少？

A：项目在 RagConfig 中构建为 new MarkdownHeadingSplitter(3, 1500, subSplitter)：headingLevel=3 表示按三级标题 ### 切分，maxCharsPerSegment=1500 表示单块超过 1500 字符才触发兜底细分，subSplitter 为 DocumentSplitters.recursive(1000, 100)，即兜底时按块长 1000 字符、重叠 100 字符递归切分。

### Q. 什么是混合检索（Hybrid Search）？

A：混合检索就是同时用两种互补的检索方式召回资料，再把两路结果融合成一个排序。稠密检索即向量检索，把问题和文档都编码成向量比语义相近程度，懂同义、懂改写，但对精确关键词不够敏感；稀疏检索即 BM25 关键词检索，本质是关键词命中加词频与逆文档频率打分，字面命中越多分越高。把两者并联，用统一的融合算法 RRF 合并两路排名，让最终结果在语义和关键词两头都占。

### Q. 千言项目为什么要引入混合检索？

A：稀疏检索与稠密检索的强项弱项几乎互为镜像：前者擅长专有名词、错误码、版本号等精确字面匹配，遇到同义词和不同表达就会漏检；后者理解语义、能跨越表达差异，却对精确字符串和生僻新词不敏感。真实查询往往同时包含这两种需求，任何单一方法都有盲区。把两路结果用 RRF 融合再接重排模型精排，就能以很低成本换来明显更稳健的检索效果，尤其在领域术语多、内容夹杂大量实体标识符的场景下。

### Q. 千言项目的 BM25 检索是靠哪个类、哪条 SQL 实现的？

A：由 PgBm25ContentRetriever 实现，它实现 ContentRetriever 接口，构造时注入 JdbcTemplate、表名和 maxResults。核心 SQL 是 SELECT text, paradedb.score(embedding_id) AS score FROM 表名 WHERE embedding_id @@@ paradedb.match('text', ?) ORDER BY score DESC LIMIT ?，用占位符传入问题以规避注入与特殊字符解析问题。它直接对 langchain4j 写入的向量表 text 列做检索，与向量检索共用同一张表、同一批数据，不需要额外同步；检索失败时降级返回空列表，让向量检索兜底，不拖垮整条链路。

### Q. 千言项目里 BM25 索引是什么时候建的、怎么建的？

A：由 PgBm25IndexInitializer 建立，它是一个 @Order(2) 的 CommandLineRunner，排在 RagDataLoader（@Order(1)）之后，保证文档灌库完成后再建索引。它先执行 CREATE EXTENSION IF NOT EXISTS pg_search 确保扩展启用，再按「先删后建」保证幂等，索引名为表名加 _bm25_idx，建索引语句为 CREATE INDEX 索引名 ON 表名 USING bm25 (embedding_id, (text::pdb.chinese_compatible)) WITH (key_field='embedding_id')。因为 PgVectorEmbeddingStore 配了 dropTableFirst(true)，每次启动表都会重建，所以 BM25 索引也必须每次启动重建。

### Q. 千言项目的 HybridContentRetriever 是怎么融合两路结果的？

A：HybridContentRetriever 同时调用 vectorRetriever 和 bm25Retriever 拿到两路结果，用片段文本内容作为去重键，按 RRF 公式累加分数：某文档在某一路的名次为 rank 时，该路贡献 1/(rrfK + rank)，两路命中则分数累加。项目里 rrfK 取经验值 60，融合后按总分从高到低排序，截取 maxResults 条返回。只用名次不碰原始分，天然绕开余弦相似度与 BM25 得分量纲不一致的问题。

### Q. 什么是 ParadeDB？千言项目为什么要换这个镜像？

A：ParadeDB 是「Postgres + pgvector + pg_search」三合一的镜像。千言原先用的是普通 PgVector 镜像，只有向量检索能力；换成 ParadeDB 后原来的向量检索完全不受影响，只是额外多了 BM25 全文检索能力，这样向量路和 BM25 路可以共用同一个库、同一张表。项目中 ParadeDB 容器映射的端口是 54329，对应 application-dev.yml 里 pgvector.port 也改成了 54329。

### Q. 千言项目是怎么为 BM25 单独配置数据源的？

A：BM25 要走原生 SQL，所以 POM 引入了 spring-boot-starter-jdbc（自带 HikariCP 与 JdbcTemplate），并新增 DataSourceConfig。它复用 pgvector.* 的连接参数，用 HikariConfig 拼出 jdbc:postgresql://host:port/database 的 URL，设置最大连接池 5、连接池名 bm25-pool，暴露 DataSource 与 JdbcTemplate 两个 Bean。这套连接与 langchain4j 内部连接相互独立，只是指向同一个库同一张表；显式声明 DataSource 后 Spring Boot 也不会再因没配 spring.datasource.url 而报 Failed to configure a DataSource。

### Q. 什么是 Rerank 重排序？两阶段检索指的是什么？

A：Rerank 就是在粗召回之后再加一道精排，用更强的交叉编码器模型对粗召回捞回来的每个候选片段逐对打分，按相关性从高到低重排，只把最相关的几条交给大模型。这就是典型的两阶段检索：第一阶段用向量检索加 BM25 快速廉价地从整个知识库捞回一批候选，追求不漏；第二阶段用 rerank 模型对这批候选做精细打分，追求排得准，最后只保留少量结果。

### Q. 双编码器和交叉编码器有什么区别？

A：双编码器是向量检索用的，Query 和文档各编各的、互不见面，分别压成定长向量，最后只比几何距离。它快在文档向量可以离线算好灌进库里，查询时只算一次 Query 向量，扛得住百万级粗筛；粗在整篇文档在没见到 Query 时就被压进固定向量，token 级细节尽失。交叉编码器是 rerank 用的，Query 和候选文档拼成一条序列一起喂进模型，每一层 attention 里逐 token 交互，由打分头输出相关性分数，精度远高但算不起全库——分数是 Query 与该文档这一对共同算出来的，换个 Query 就全部作废，无法预先建库。

### Q. 千言项目的 rerank 用的是哪个模型？为什么选它？

A：千言使用百炼平台的 qwen3-rerank，通过 langchain4j-community 的 QwenScoringModel 接入，在 RerankModelConfig 中构建为 ScoringModel Bean，模型名由 rerank.model-name 配置项注入，默认 qwen3-rerank。选它是因为 qwen3-rerank 支持 100 多个语种、单次最多 500 篇文档，适用于文本语义检索和 RAG 场景；而 qwen3-vl-rerank 更适合图片检索。另外 gte-rerank 将于 2026-05-30 下线，官方推荐迁移到 qwen3-rerank。

### Q. 千言项目的 RerankingContentRetriever 是怎么工作的？

A：RerankingContentRetriever 是一个装饰器，把粗召回检索器 hybridContentRetriever 包在里面。retrieve 时先拿粗召回结果，为空直接返回空列表、只有一条则跳过精排省一次模型调用；否则抽出候选的 TextSegment，调用 scoringModel.scoreAll(segments, query.text()) 批量打分，把候选与分数配对后按分数降序排序，再过 minScore 阈值并截取 topK。如果阈值把所有候选都砍光，会兜底返回分数最高的 topK 条并打 warn 日志；精排抛异常时降级为粗召回的前 topK 条，不拖垮整条链路。

### Q. 千言项目两阶段检索的三个参数分别配了多少？

A：在 application.yml 的 rag 节点下：recall-top-n 为 20，是粗召回条数，向量路与 BM25 路各取 20 条、RRF 融合后也保留 20 条；rerank-top-k 为 5，是精排后最终喂给大模型的条数；rerank-min-score 为 0.2，是 qwen3-rerank 的相关性阈值，分数范围 0 到 1，低于 0.2 的候选直接丢弃。粗召回条数明显大于精排保留条数，是为了给精排足够的候选空间。

### Q. 千言项目 RagConfig 里现在一共有哪几个检索器 Bean？

A：共四个，依次串成两阶段链路：vectorContentRetriever 是稠密检索（EmbeddingStoreContentRetriever，maxResults=20、minScore=0.75）；bm25ContentRetriever 是稀疏检索（PgBm25ContentRetriever，maxResults=20）；hybridContentRetriever 把前两者用 RRF（k=60）融合，取 20 条；rerankingContentRetriever 把混合检索结果交给 qwen3-rerank 精排，过 0.2 阈值后取 5 条。最终对外出口是 rerankingContentRetriever，AiChatService、EvalController 和 RagTool 都注入它。

### Q. 千言项目引入标题切分、混合检索和 Rerank 之后，评测指标提升了多少？

A：在同一份 153 题测试集上，基线（段落切分 + 单路向量检索）与叠加「标题切分 + 混合检索 + Rerank 精排」后的对比为：忠实度 0.9498 升至 0.9516，答案相关性 0.7661 升至 0.7943，上下文精确率 0.8449 升至 0.9208，上下文召回率 0.8912 升至 0.9299，Hit@1 从 0.5106 升至 0.7730，Hit@3 从 0.6099 升至 0.8582，Hit@5 从 0.6809 升至 0.8865，负样本拒答准确率保持 1.0000，正样本误拒率由 0.0496 降至 0.0355。九项指标全面向好、无一回退，提升主要集中在检索侧。

### Q. 千言项目的 Agent Skills 运行时是怎么实现的？

A：全部实现就是 SkillTool 一个类。启动时 @PostConstruct 的 load 方法用 PathMatchingResourcePatternResolver 扫描 classpath*:skills/*/SKILL.md，用 frontmatter 的三个短横线把文件切成元数据与正文两段，读出 name 与 description 拼成技能清单，正文存进 bodies 这个 LinkedHashMap。渐进式披露只有两层：L1 是 catalog() 返回的技能清单，常驻系统提示词每轮都发；L2 是 loadSkill 工具返回的 SKILL.md 正文，只有模型判断命中那轮才读取。单个技能缺 frontmatter 或 name/description 时只跳过并打错误日志，不拖垮启动。

### Q. 千言项目是怎么把技能清单注入系统提示词的？

A：在 AiChatService 构建 AiServices 时调用 .systemMessageTransformer(sm -> sm + "\n\n" + skillTool.catalog())，把技能清单追加到 @SystemMessage 读到的提示词后面。transformer 跑在 @SystemMessage 解析之后，所以 AiChat 接口一行都不用改。同时在 .tools(...) 末尾追加 skillTool，让模型能调用 loadSkill 拿到技能正文。

### Q. 千言项目里 kb-curator 这个技能是干什么的？

A：kb-curator 是把用户口述内容规范化后写入千言知识库的技能，当用户表达「记一下 / 存到知识库 / 以后记住这个 / 帮我补一条知识」这类入库意图时触发。它的 SOP 分三步：第一步调用 searchKnowledge 查重，为空则新增、完全一致则告知用户不重复入库、同一问题答案不同则停下来问用户；第二步规范化，question 写成完整能独立看懂的疑问句、answer 第一句就说结论且只讲一件事、任何一行都不能以三个井号开头；第三步调用 addKnowledgeToRag 写入并向用户回报入库条数、规范化后的问题原文和写入的文件名。

### Q. 千言项目为什么要把「动态知识植入」写成一个 Skill 而不是塞进提示词？

A：有三个缺口。缺能力：原先无条件追加写入、不查重，重复内容压缩召回量、矛盾内容引发模型混乱，而框架自动注入检索结果，模型没有主动二次检索的能力，所以要新增 searchKnowledge 工具并规定「先查后写、冲突确认」。缺约束：项目特有的工程约束（如切分器只认三个井号）不是模型的先验常识，需要在 SKILL.md 里写明。缺容器：完整入库要跨多个工具编排，单个工具描述承载不了，强行塞进系统提示词会抬高误触发率并浪费 Token，所以用按需加载的 Skill 作为容器。

### Q. 千言项目的 RagTool 新增了什么工具方法？

A：新增了 searchKnowledge，@Tool 描述为「在知识库里检索与给定问题最相近的已有条目。用于入库前查重，或需要确认知识库里到底有没有某条内容时」。它注入 @Qualifier("rerankingContentRetriever") 的检索器，复用线上那条两阶段检索链路，保证查重标准和回答时完全一致；检索为空时返回「可视为新知识」，有命中则把片段拼起来交给模型判断是重复、冲突还是无关，检索异常时如实告知不要在没查重的情况下直接入库。

### Q. 千言项目的 addKnowledgeToRag 增加了什么校验？入库格式是什么？

A：增加了兜底校验：若 question 或 answer 中任何一行以三个井号开头，直接返回失败提示要求改写，因为这样的行会被切分器当成新块的起点、把一条知识劈成两半。注意是 return 一句话而不是抛异常，把失败当作反馈交还给模型，它自己改完重试、对话不中断。格式化后的内容为「### Q. 问题」加空行加「A：答案」，与 Test.md 里已有条目的块首字面串统一，BM25 才好命中；文件名为空时默认 InfiniteChat.md，不以 .md 结尾会自动补上。

### Q. 千言项目升级 LangChain4j 版本后，McpToolConfig 为什么要改？

A：新版本中 HttpMcpTransport 将被弃用，不改虽然不会报错但代码会爆红，所以改用 StreamableHttpMcpTransport.Builder 构建传输层，URL 指向 https://open.bigmodel.cn/api/mcp/web_search/mcp，通过 customHeaders 传入 Authorization 请求头（取 apiKey.trim()），并开启 logRequests 与 logResponses。另外升级后 Lombok 不能再指望作为传递依赖被带进来，否则会报「lombok 不存在」，需要在 POM 里显式声明并设为 optional。
