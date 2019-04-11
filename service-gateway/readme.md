# 参考文档
[Spring Cloud入门到实战系列教程](http://cxytiandi.com/blog/detail/17470)
[服务网关 Spring Cloud GateWay 入门](http://www.ityouknow.com/springcloud/2018/12/12/spring-cloud-gateway-start.html)
[Spring Cloud Gateway 初体验](https://www.fangzhipeng.com/springcloud/2018/11/06/sc-f-gateway1.html)
在spring cloud gateway中有2个重要的概念predicates和filters
[predicate简介-todo](https://www.fangzhipeng.com/springcloud/2018/12/05/sc-f-gateway2.html)

[filter的作用和生命周期-todo](https://www.fangzhipeng.com/springcloud/2018/12/21/sc-f-gatway3.html)

## demo test
启动springboot项目，在浏览器上http://localhost:8080/get

##  使用Hystrix
在spring cloud gateway中可以使用Hystrix。Hystrix是 spring cloud中一个服务熔断降级的组件，在微服务系统有着十分重要的作用。
Hystrix是 spring cloud gateway中是以filter的形式使用的，代码如下：

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    </dependency>
    @EnableHystrix
    
使用git bash 测试 
    
    curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8080/delay/3


## 常见的限流算法

[Spring Cloud Gateway限流](https://www.fangzhipeng.com/springcloud/2018/12/22/sc-f-gatway4.html)

    计数器算法
    漏桶算法
    令牌桶算法

## 网关扮演的角色
其中service-hi、service-gateway向注册中心eureka-server注册。
用户的请求首先经过service-gateway，根据路径由gateway的predict 去断言进到哪一个 router， router经过各种过滤器处理后，最后路由到具体的业务服务，比如 service-hi。如图：

    在浏览器上请求输入localhost:8081/service-hi/hi?name=1323
    在浏览器上请求localhost:8081/demo/hi?name=1323 (自定义url)