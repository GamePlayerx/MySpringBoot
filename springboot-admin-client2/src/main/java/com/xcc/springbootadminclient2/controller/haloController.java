package com.xcc.springbootadminclient2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xcc
 * @Date 2023/8/14
 */
@RestController
public class haloController {

    @GetMapping("/halo")
    public String halo() {
        return "Halo";
    }
}
