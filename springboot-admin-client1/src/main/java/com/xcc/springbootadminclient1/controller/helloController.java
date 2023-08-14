package com.xcc.springbootadminclient1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xcc
 * @Date 2023/8/14
 */
@RestController
public class helloController {

    @GetMapping("/hello")
    public String hello () {
        return "Hello";
    }
}
