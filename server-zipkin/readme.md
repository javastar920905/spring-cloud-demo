# 必须实现分布式链路追踪-參考文檔
[Spring Cloud Sleuth 之Greenwich版本全攻略](https://www.fangzhipeng.com/springcloud/2019/02/05/sc-sleuth-g.html)

## 案例
在本案例一共有三个应用，分别为注册中心，eureka-server、eureka-client、eureka-client-feign，三个应用的基本信息如下：

    应用名	端口	作用
    eureka-server	8761	注册中心
    service-hi	8762	    服务提供者
    feign-service-comsume	8765	服务消费者
    
### zipkin-server
在Spring Cloud D版本，zipkin-server通过引入依赖的方式构建工程，自从E版本之后，这一方式改变了，采用官方的jar形式启动
，所以需要通过下载官方的jar来启动，也通过以下命令一键启动：
    
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
    java -jar zipkin.jar
    
    docker 方式启动
    docker run -d -p 9411:9411 openzipkin/zipkin
    在浏览器上访问lcoalhost:9411

