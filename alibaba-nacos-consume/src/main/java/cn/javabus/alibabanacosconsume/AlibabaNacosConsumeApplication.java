package cn.javabus.alibabanacosconsume;

import cn.javabus.alibabanacosconsume.feignclient.NacosConfigFeignClient;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaNacosConsumeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext= SpringApplication.run(AlibabaNacosConsumeApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :"+userName+"; age: "+userAge);
    }

    @RestController
    public class NacosController {

        @Autowired
        private LoadBalancerClient loadBalancerClient;
        @Autowired
        private RestTemplate restTemplate;
        @Autowired
        private NacosConfigFeignClient configClient;

        @Value("${spring.application.name}")
        private String appName;

        @GetMapping("/echo/app-name")
        @SentinelResource("/echo/app-name")
        public String echoAppName() {
            //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
            ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-config");
            String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
            System.out.println("request url:" + url);

            System.out.println("feign 请求结果"+configClient.ehcoSth(appName));
            return restTemplate.getForObject(url, String.class);
        }
    }

        //实例化 RestTemplate 实例
        @Bean
        public RestTemplate restTemplate(){
            return new RestTemplate();
        }

}
