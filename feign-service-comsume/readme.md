# 参考文档
[博客](https://www.fangzhipeng.com/springcloud/2017/06/03/sc03-feign.html)

# feign 介绍
ribbon-service-consume，讲述了如何通过RestTemplate+Ribbon去消费服务
feign-service-comsume主要讲述如何通过Feign去消费服务。

    Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。
    使用Feign，只需要创建一个接口并注解。
    它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。
    Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。

简而言之：

    Feign 采用的是基于接口的注解
    Feign 整合了ribbon
    
# 启动服务
访问地址: http://localhost:8765/hi?name=forezp
