package cn.javabus.ribbonserviceconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonServiceConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceConsumeApplication.class, args);
    }

}
