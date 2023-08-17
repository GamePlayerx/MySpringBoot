package com.xcc.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcc.springbootmybatisplus.dao.UserInfoMapper;
import com.xcc.springbootmybatisplus.entity.UserInfo;
import com.xcc.springbootmybatisplus.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/8/17
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
