package com.javastar920905.springboothellostarter.autoconfig;

import com.javastar920905.springboothellostarter.properties.HelloServiceProperties;
import com.javastar920905.springboothellostarter.service.HelloService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ouzhx on 2018/9/19.
 */
@Configuration//标识此类为一个spring配置类
@EnableConfigurationProperties(value = HelloServiceProperties.class)//启动配置文件，value用来指定我们要启用的配置类，可以有多个
@ConditionalOnClass(HelloService.class)//表示当classPath下存在HelloService.class文件时,当前配置文件类才有效
//表示只有我们的配置文件是否配置了以hello为前缀的资源项值，并且在该资源项值为enable，如果没有配置我们默认设置为enable
@ConditionalOnProperty(prefix = "hello", value = "enable", matchIfMissing = true)
@Log4j2
public class HelloAutoConfiguration {
    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        log.warn("helloService 初始化成功");
        helloService.sayHello();
        return helloService;
    }
}
