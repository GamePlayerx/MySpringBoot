package com.xcc.springbootlistener.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author xcc
 * @Date 2023/8/14
 */
@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerDemo run 程序启动了！");
    }
}
