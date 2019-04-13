package cn.javabus.alibabanacosconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
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


        //实例化 RestTemplate 实例
        @Bean
        public RestTemplate restTemplate(){
            return new RestTemplate();
        }

}
