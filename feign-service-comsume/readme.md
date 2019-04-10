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

# 断路器
[参考文档](https://www.fangzhipeng.com/springcloud/2017/06/04/sc04-hystrix.html)
Feign是自带断路器的，在D版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它
    
    feign.hystrix.enabled=true
## 测试断路器
启动四servcie-feign工程，浏览器打开http://localhost:8765/hi?name=forezp,注意此时service-hi工程没有启动，网页显示：

    sorry 熔断器 forezp

打开service-hi工程，再次访问，浏览器显示：

    hi forezp,i am from port:8762

这证明断路器起到作用了。