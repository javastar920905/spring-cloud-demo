package cn.javabus.feignservicecomsume;

import cn.javabus.springcloudcommon.initializer.AppContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients
@SpringBootApplication(scanBasePackages="cn.javabus")
//@Import(AppContextInitializer.class)
public class FeignServiceComsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceComsumeApplication.class, args);
    }

}
