package com.xcc.springbootlistener.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @Author xcc
 * @Date 2023/8/14
 */
public class SpringApplicationRunListenerDemo implements SpringApplicationRunListener {

    public SpringApplicationRunListenerDemo(SpringApplication application, String[] args) {}

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        SpringApplicationRunListener.super.starting(bootstrapContext);
        System.out.println("SpringApplicationRunListenerDemo  starting ");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
        System.out.println("SpringApplicationRunListenerDemo  environmentPrepared ");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.contextPrepared(context);
        System.out.println("SpringApplicationRunListenerDemo  contextPrepared ");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.contextLoaded(context);
        System.out.println("SpringApplicationRunListenerDemo  contextLoaded ");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        SpringApplicationRunListener.super.started(context, timeTaken);
        System.out.println("SpringApplicationRunListenerDemo  started ");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        SpringApplicationRunListener.super.ready(context, timeTaken);
        System.out.println("SpringApplicationRunListenerDemo  ready ");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        SpringApplicationRunListener.super.failed(context, exception);
        System.out.println("SpringApplicationRunListenerDemo  failed ");
    }
}
