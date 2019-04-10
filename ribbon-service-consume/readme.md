# 参考文档
[博客3](https://www.fangzhipeng.com/springcloud/2017/06/02/sc02-rest-ribbon.html)

# ribbon （rpc的一种实现）
服务消费者通过restful方式，远程调用服务


# 访问当前服务接口
启动两个 service-hi 服务，端口分别为： 8762和8763
在浏览器上多次访问http://localhost:8764/hi?name=forezp，浏览器交替显示：

    hi forezp,i am from port:8762
    hi forezp,i am from port:8763
这说明当我们通过调用restTemplate.getForObject(“http://SERVICE-HI/hi?name=”+name,String.class)方法时，已经做了负载均衡，访问了不同的端口的服务实例。


# 添加熔断器
[添加熔断器hystrix](https://www.fangzhipeng.com/springcloud/2017/06/04/sc04-hystrix.html)

    <!--添加熔断器,使用下面依赖,上面文档的依赖有问题-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    </dependency>
### 为啥要使用熔断器?(避免远程服务挂掉,导致web服务阻塞)
    在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。
    为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，
    如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。
    服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

    为了解决这个问题，业界提出了断路器模型。
    Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。
### 熔断器使用演示  
启动：service-ribbon 工程，当我们访问http://localhost:8764/hi?name=forezp,浏览器显示：
    
    hi forezp,i am from port:8762

此时关闭 service-hi 工程，当我们再访问http://localhost:8764/hi?name=forezp，浏览器会显示：

    hi ,forezp,orry,error!

这就说明当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
  
### 添加熔断器监控面板
     <!-- 添加熔断器监控面板-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    </dependency>
    
    @EnableHystrixDashboard main方法类上激活注解
打开浏览器：访问http://localhost:8764/hystrix,界面如下：
