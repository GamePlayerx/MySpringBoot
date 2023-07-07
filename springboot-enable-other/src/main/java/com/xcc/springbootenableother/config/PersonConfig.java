package com.xcc.springbootenableother.config;

import com.xcc.springbootenableother.demain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置类注解
@Configuration
public class PersonConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
