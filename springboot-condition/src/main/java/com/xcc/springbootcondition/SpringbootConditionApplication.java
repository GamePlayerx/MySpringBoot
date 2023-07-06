package com.xcc.springbootcondition;

import com.xcc.springbootcondition.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConditionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConditionApplication.class, args);
        // 返回spring容器
//        ConfigurableApplicationContext context = SpringApplication.run(SpringbootConditionApplication.class, args);

        // 获取redisTemplate这个bean对象
//        Object redisTemplate = context.getBean("redisTemplate");
//        System.out.println(redisTemplate);

        // 通过名字拿bean对象
//        User user = (User) context.getBean("user");
//        System.out.println(user);

        // 通过类型拿bean对象
//        User user = (User) context.getBean(User.class);
//        System.out.println(user);

//        User user2 = (User) context.getBean("user2");
//        System.out.println(user2);
    }

}
