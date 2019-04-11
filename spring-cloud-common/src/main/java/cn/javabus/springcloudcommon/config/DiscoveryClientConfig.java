package cn.javabus.springcloudcommon.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author ouzhx on 2019/4/11.
 *
 * 自动到服务注册中心查找服务,默认注册中心url配置 @see AppContextInitializer.java
 */
@EnableDiscoveryClient
@Configuration
public class DiscoveryClientConfig {
}
