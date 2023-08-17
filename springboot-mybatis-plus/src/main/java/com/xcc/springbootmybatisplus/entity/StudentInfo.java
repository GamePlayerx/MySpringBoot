package com.xcc.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student_info
 */
@TableName(value ="student_info")
@Data
public class StudentInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "student_name")
    private String studentName;

    /**
     * 
     */
    @TableField(value = "student_day")
    private String studentDay;

    /**
     * 
     */
    @TableField(value = "student_mail")
    private String studentMail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}