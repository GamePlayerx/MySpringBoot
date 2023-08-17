package com.xcc.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcc.springbootmybatisplus.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/8/17
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
