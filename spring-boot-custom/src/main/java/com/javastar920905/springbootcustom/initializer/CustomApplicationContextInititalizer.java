package com.javastar920905.springbootcustom.initializer;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ouzhx on 2018/9/19.
 */
@Log4j2
public class CustomApplicationContextInititalizer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        log.info("自定义的初始化器的initialize方法被执行了");
    }
}
