# 参考文档
[参考文档](http://www.ityouknow.com/springcloud/2018/01/20/spring-cloud-zuul.html)
[博客](https://www.fangzhipeng.com/springcloud/2017/06/05/sc05-zuul.html)

## 微服务组件的配合方式

    在微服务架构中，需要几个基础的服务治理组件，
    包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，
    由这几个基础组件相互协作，共同组建了一个简单的微服务系统

    在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（zuul、Ngnix），
    再到达服务网关（zuul集群），然后再到具体的服务，
    服务统一注册到高可用的服务注册中心集群，服务的所有的配置文件由配置服务管理（下一篇文章讲述），配置服务的配置文件放在git仓库，方便开发人员随时改配置。
    
## Zuul简介
Zuul的主要功能是路由转发和过滤器。
路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。

zuul有以下功能：

    Authentication
    Insights
    Stress Testing
    Canary Testing
    Dynamic Routing
    Service Migration
    Load Shedding
    Security
    Static Response handling
    Active/Active traffic management
    

## demo 测试
依次运行这五个工程;打开浏览器访问：http://localhost:8769/api-ribbon/hi?name=forezp ;浏览器显示：

    hi forezp,i am from port:8762   

打开浏览器访问：http://localhost:8769/api-feign/hi?name=forezp&token=22 ;浏览器显示：

    hi forezp,i am from port:8762

这说明zuul起到了路由的作用

### 添加服务过滤
zuul不仅只是路由，并且还能过滤，做一些安全验证。继续改造工程；
