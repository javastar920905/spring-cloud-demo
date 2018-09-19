package com.javastar920905.springbootcustom.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author ouzhx on 2018/9/19.
 */
@Component
@Log4j2
public class CustomRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("自定义ApplicationRunner运行了");
    }
}
