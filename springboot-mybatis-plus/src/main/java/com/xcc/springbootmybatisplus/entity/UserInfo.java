package com.xcc.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/8/17
 */
@Data
@TableName("user")
public class UserInfo {
    @TableField("id")
    private Long Id;
    @TableField("name")
    private String names;
    @TableField("age")
    private Integer ageIng;
    @TableField("email")
    private String Email;
}
