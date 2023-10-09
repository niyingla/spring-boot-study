package com.imooc.architect.module.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author jimmy
 */
@Slf4j
public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;

    private final String[] args;
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    private void logRecord(String type){
      log.info("====run {}====",type);
//      System.out.println(String.format("====run %s====",type));
    }
    @Override
    public void starting() {
        logRecord("starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logRecord("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logRecord("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        logRecord("contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        logRecord("started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        logRecord("running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        logRecord("failed");
    }
}
