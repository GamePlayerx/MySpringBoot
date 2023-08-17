package com.xcc.springbootmybatisplus.controller;

import com.xcc.springbootmybatisplus.entity.UserInfo;
import com.xcc.springbootmybatisplus.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/8/17
 */
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/selectAll")
    public List<UserInfo> selectAll() {
        return userInfoService.list();
    }
}
