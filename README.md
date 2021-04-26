# cloud
# springcloud基础框架

# registry 注册中心（服务不可用或者手工停止，可快速下线）
# config 配置中心
# config-repo 外部化配置文件（profiles.active可以用于启动命令中，启动使用不同配置的参数）
# gateway 网关（加入swagger组件，可以快速访问后续服务的接口文档等。默认轮询负载均衡）
# clienta 服务A（测试服务A，含feign调用，熔断器等）
# clientb 服务B（测试服务B）
# swagger 快速生成接口文档
# hystrix 熔断器
# openFeign和ribbon（负载均衡以及失败重发机制）
