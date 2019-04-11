package cn.javabus.springcloudcommon.initializer;

import cn.javabus.springcloudcommon.util.SpringContextUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

/**
 * @author ouzhx on 2018/9/19.
 */
@Log4j2
@Import(SpringContextUtil.class)
public class AppContextInitializer implements ApplicationContextInitializer {
    private static final String config_server_name="configserver";
    private static final String config_server_pwd="";

    @AllArgsConstructor
    enum Server{
        register_server("eureka.client.serviceUrl.defaultZone","http://peer1:8761/eureka/,http://peer2:8769/eureka/,http://peer3:8770/eureka/","默认注册中心地址,hosts中配置peer1,2,3的实际ip地址"),
        config_server("spring.cloud.config.uri","http://configserver:9999","默认配置中心地址,hosts中配置configserver的实际ip地址");

        public String key;
        public String value;
        public String desc;
    }

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        String configServerUrl = environment.getProperty(Server.config_server.key);
        String registerServerUrl = environment.getProperty("eureka.client.serviceUrl.defaultZone");

        //配置默认服务注册中心地址
        if (StringUtils.isEmpty(registerServerUrl)) {
            log.info("{} 正在自动配置registerServerUrl:{}", appName, Server.register_server.value);
            System.setProperty("eureka.client.serviceUrl.defaultZone", Server.register_server.value);
        } else {
            log.info("{} 使用外部指定registerServerUrl", appName, registerServerUrl);
        }


        if (StringUtils.isEmpty(configServerUrl)) {
            log.info("{} 正在自动配置configServer url:{}", appName, Server.config_server.value);
            System.setProperty("spring.cloud.config.uri", Server.config_server.value);
        } else {
            log.info("{} 使用外部指定configServer url:{}", appName, configServerUrl);
        }

        System.setProperty("spring.cloud.config.username", config_server_name);
        System.setProperty("spring.cloud.config.password",config_server_pwd);
        System.setProperty("xxl.job.admin.addresses", "http://xxljobadmin:10001/xxl-job-admin");


    }
}
