package cn.javabus.ribbonserviceconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class RibbonServiceConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceConsumeApplication.class, args);
    }

}
