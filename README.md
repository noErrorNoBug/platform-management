## 项目介绍
- 详细文档 https://noerrornobug.github.io/docs/
- github: https://github.com/noErrorNoBug/platform-management

## 功能介绍
- **分布式系统基础支撑**
  - 服务注册发现
  - 路由负载均衡
  - 服务限流、熔断
  - 统一配置中心
  - 统一日志中心
  - 统一搜索中心
  - 分布式缓存
  - 分布式锁
  - 分布式任务调度
  - 分布式ID
  - 分布式事务(强一致性/最终一致性)
  - 链路追踪
  - CI/CD持续集成(后端)
  - 高性能应用层网关API
  - 网关聚合Swagger
  - 统一异常处理
  - 统一跨域处理
  - 高性能幂等性支持
- **统一认证功能（UUA）**
  - 网关统一认证
  - url级别权限认证
  - oauth2的4种认证模式
  - 用户名、密码+图形验证码登录
  - 手机号+密码登录
  - openId登录
  - 第三方登录
  - 单点登录
  - token生成
- **系统监控功能**
  - 服务调用链路追踪
  - 应用拓扑图
  - 日志查询、审计
  - 慢sql查询
  - 应用吞吐量控制(qps,rt)
  - 服务限流、降级
  - redis监控、mysql监控、Prometheus监控、nacos监控、es监控
- 业务功能
  - 多租户、RBAC权限管理
  - 商城项目(业务模式参考 https://github.com/macrozheng/mall)
  - 秒杀系统
  - flink实时推荐系统

## 技术选型
### 后端主要依赖
| 技术                   | 说明            | 版本                                            |
|----------------------|---------------|-----------------------------------------------|
| SpringBoot           | 容器+MVC框架      | 2.6.4                                         |
| Spring Cloud         | 微服务框架         | 2021.0.1                                      |
| Spring Cloud Alibaba | 微服务框架         | 2021.0.1.0                                    |
| Druid                | 数据库连接池        | 2.2.2                                         |
| MyBatis              | ORM框架         | 2.2.2                                         |
| MyBatis-Plus         | 简化ORM框架       | 3.5.1                                         |
| PageHelper           | 分页插件          | 1.4.1                                         |
| log4j                | 日志API         | 1.7.36                                        |
| lombok               | 简化开发          | 1.18.22                                       |
| swagger3             | API文档         | 3.0.0                                         |
| knife4j              | API文档UI       | 3.0.5                                         |
| SpringSecurity       | 认证和授权框架       | 2.6.4                                         |
| jwt                  | 登录支持          | 0.9.1                                         |
| guava                | Java工具类库      | 31.0.1-jre                                    |
| Hutool               | Java工具类库      | 5.7.20                                        |


### 分布式组件
| 技术            | 说明              | 版本     |
|---------------|-----------------|--------|
| jdk           | jdk             | 18     |
| mysql         | 关系型数据库Mysql     | 8.0.27 |
| Nacos         | 注册中心/配置中心       |        |
| ZKUI          | Zookeeper独立监控平台 |        |
| kafka         | 分布式消息队列         |        |
| CMAK          | Kafka独立监控平台     |        |
| Elasticsearch | 搜索引擎            |        |
| RabbitMQ      | 消息队列            |        |
| Redis         | 分布式缓存           |        |
| RedisManager  | Redis独立监控平台     |        |
| MongoDB       | NoSql数据库        |        |
| LogStash      | 日志收集工具          |        |
| Kibana        | 日志可视化查看工具       |        |
| Nginx         | 静态资源服务器         |        |
| Docker        | 应用容器引擎          |        |
| OSS           | 对象存储            |        |


## 代码结构
```lua
platform-management -- 项目路径
│  ├─documents -- 项目文档
│  ├─platform-parent -- 父项目，项目版本、依赖管理、项目整合
│  ├─platform-common -- 通用组件整合(一级工程)
│  │  ├─platform-common-core -- 通用核心组件
│  │  ├─platform-config-stater -- Nacos配置中心组件封装
│  │  ├─platform-db-starter -- 数据库(mysql)组件封装
│  │  ├─platform-elasticsearch-starter -- elasticsearch组件封装
│  │  ├─platform-kafka-starter -- kafka组件封装
│  │  ├─platform-loadbalancer-starter -- Web组件(微服务)封装
│  │  ├─platform-log-starter -- log日志组件封装
│  │  ├─platform-mvc-starter -- Web组件(单体)封装
│  │  ├─platform-redis-starter -- redis组件封装
│  │  ├─platform-rocket-starter -- RocketMQ组件封装
│  │  ├─platform-seata-starter -- Seata分布式事务组件封装
│  │  ├─platform-security -- SpringSecurity安全组件封装
│  │  ├─platform-sentinel-starter -- Sentinel限流、熔断组件封装
│  │  ├─platform-swagger3-starter -- kinif4j、swagger3接口文档组件封装
│  │  ├─platform-zookeeper-starter -- zookeeper组件封装
│  ├─platform-mybatisplus-generator -- mybatis-plus代码生成工具(Mybatis逆向工具)
│  ├─platform-uua -- 认证鉴权服务
│  ├─platform-job -- 任务调度系统(一级工程)
│  ├─platform-monitor -- 实时监控系统(一级工程)
│  ├─platform-transaction -- 事务管理器(一级工程)
│  ├─platform-mall -- 商城系统业务demo(一级工程)
│  │  ├─mall-admin -- 商城系统卖家端(二级工程)
│  │  │  ├─mall-admin-gateway -- 卖家端网关
│  │  │  ├─mall-admin-cms -- 卖家内容管理服务
│  │  │  ├─mall-admin-oms -- 卖家订单管理服务
│  │  │  ├─mall-admin-pms -- 卖家商品管理服务
│  │  │  ├─mall-admin-sms -- 卖家营销管理服务
│  │  │  ├─mall-admin-ums -- 卖家会员管理服务
│  │  ├─mall-portal -- 商城系统买家端(二级工程)
│  │  │  ├─mall-admin-gateway -- 买家端网关
│  │  │  ├─mall-admin-cms -- 买家内容管理服务
│  │  │  ├─mall-admin-oms -- 买家订单管理服务
│  │  │  ├─mall-admin-pms -- 买家商品管理服务
│  │  │  ├─mall-admin-sms -- 买家营销管理服务
│  │  │  ├─mall-admin-ums -- 买家会员管理服务
│  │  ├─mall-seckill -- 商城秒杀系统

```