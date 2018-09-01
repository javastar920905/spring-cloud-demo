package javastar920905;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 * Eureka是Spring Cloud Netflix的一个子模块，也是核心模块之一。
 * 用于云端服务发现，一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。
 * <p>
 * 服务发现：服务发现是微服务基础架构的关键原则之一。
 * 试图着手配置每个客户端或某种格式的约定可以说是非常困难的和非常脆弱的。
 * Eureka是Netflix服务发现的一种服务和客户端。这种服务是可以被高可用性配置的和部署,并且在注册的服务当中，每个服务的状态可以互相复制给彼此。
 * <p>
 * 服务注册:当一个客户端注册到Eureka,它提供关于自己的元数据（诸如主机和端口，健康指标URL，首页等）
 * Eureka通过一个服务从各个实例接收心跳信息。如果心跳接收失败超过配置的时间，实例将会正常从注册里面移除
 */
//通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class, args);
    }
}
