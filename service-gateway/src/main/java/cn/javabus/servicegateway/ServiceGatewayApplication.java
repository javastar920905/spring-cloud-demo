package cn.javabus.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableHystrix
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }


    /**
     * myRoutes方法中，
     * 使用了一个RouteLocatorBuilder的bean去创建路由，
     * 除了创建路由RouteLocatorBuilder可以让你添加各种predicates和filters，predicates断言的意思，
     * 顾名思义就是根据具体的请求的规则，由具体的route去处理，filters是各种过滤器，用来对请求做各种判断和修改。
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        /**
//         * 让请求“/get”请求都转发到“http://httpbin.org:80/get”。
//         * 在route配置上，我们添加了一个filter，该filter会将请求添加一个header,key为hello，value为world。
//         */
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("token", "hello World"))
//                        .uri("http://httpbin.org:80"))
//                .build();
//    }

    /**
     * Hystrix是 spring cloud gateway中是以filter的形式使用的
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";

//        我们使用了另外一个router，该router使用host去断言请求是否进入该路由，
//        当请求的host有“*.hystrix.com”，都会进入该router，
//        该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，
//        比如本案例中重定向到了“/fallback”

        //使用git bash 测试 curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8080/delay/3
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("token", "hello World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }

    //带hostwww.hystrix.com的请求执行了hystrix的fallback的逻辑
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
