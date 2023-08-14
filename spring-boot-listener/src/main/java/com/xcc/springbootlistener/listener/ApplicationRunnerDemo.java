package com.xcc.springbootlistener.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author xcc
 * @Date 2023/8/14
 */
@Component
public class ApplicationRunnerDemo implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 链接一下数据库，业务代码实现
        System.out.println("ApplicationRunnerDemo run 程序启动了！");
    }
}
