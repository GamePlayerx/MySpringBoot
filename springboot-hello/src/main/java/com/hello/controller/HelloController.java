package com.hello.controller;

import com.hello.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // 获取普通配置
    @Value("${name}")
    private String name;

    // 获取对象属性
    @Value("${person1.name}")
    private String name1;

    // 获取数组
    @Value("${array2[0]}")
    private String array1;

    // 获取纯量
    @Value("${msg1}")
    private String msg1;

    @Autowired
    private Environment env;

    @Autowired
    Person person;

    @GetMapping("/test")
    public String test() {
        System.out.println("name======"+name);
        System.out.println("name1====="+name1);
        System.out.println("array1===="+array1);
        System.out.println("msg1======"+msg1);

        System.out.println("=========================================");

        System.out.println("name1====="+env.getProperty("person1.name"));
        System.out.println("array1====="+env.getProperty("array2[0]"));
        System.out.println("msg1====="+env.getProperty("msg1"));
        System.out.println("name====="+env.getProperty("name"));

        System.out.println("=========================================");

        System.out.println(person.toString());

        return "Hello SpringBoot";
    }
}
