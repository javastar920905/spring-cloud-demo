package com.javastar920905.springbootcustom.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ouzhx on 2018/9/19.
 */
@Component
@Order(1)
@Log4j2
public class CustomCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("自定义CommandLineRunner运行了");
    }
}
