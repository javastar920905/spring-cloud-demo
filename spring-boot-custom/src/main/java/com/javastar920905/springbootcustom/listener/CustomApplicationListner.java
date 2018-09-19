package com.javastar920905.springbootcustom.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author ouzhx on 2018/9/19.
 */
@Log4j2
public class CustomApplicationListner implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 监听ApplicationStartingEvent
        if (event instanceof ApplicationStartedEvent) {
            logInfo("ApplicationStartedEvent listened");
        }

        // 监听ApplicationEnvironmentPreparedEvent
        else if (event instanceof ApplicationEnvironmentPreparedEvent) {
            logInfo("ApplicationEnvironmentPreparedEvent listened");
        }

        // 监听ApplicationPreparedEvent
        else if (event instanceof ApplicationPreparedEvent) {
            logInfo("ApplicationPreparedEvent listened");
        }

        // 监听ApplicationReadyEvent
        else if (event instanceof ApplicationReadyEvent) {
            logInfo("ApplicationReadyEvent listened");
        }

        // 监听ApplicationFailedEvent
        else if (event instanceof ApplicationFailedEvent) {
            logInfo("ApplicationFailedEvent listened");
        }
    }

    private static void logInfo(String str) {
        log.info(str);
    }
}
