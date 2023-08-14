package com.xcc.springbootlistener.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author xcc
 * @Date 2023/8/14
 */
public class ApplicationContextInitializerDemo implements ApplicationContextInitializer {
    // 监听更早，可以做一些资源的检查，redis有没有启动等等
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializerDemo initialize ");
    }
}
