# jcasbin-springboot-demo
jcasbin-springboot-demo
  * 分支 feat/rbac_resource
    * 基于rbac的角色权限控制
  * 分支 feta/mutiDomainRBAC
    * 基于rbac的多租户角色权限控制
  * TODO：
    * ~~持久化rbac关系~~
    * ~~缓存~~
    * ABAC
  * 注意事项
    * sql导入后 最好将casbin_rule表截断再重新启动项目
    * 启动项目会初始化数据到casbin_rule
