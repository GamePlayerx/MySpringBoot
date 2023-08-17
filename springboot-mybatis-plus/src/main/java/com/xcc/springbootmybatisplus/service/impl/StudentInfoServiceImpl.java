package com.xcc.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcc.springbootmybatisplus.entity.StudentInfo;
import com.xcc.springbootmybatisplus.service.StudentInfoService;
import com.xcc.springbootmybatisplus.mapper.StudentInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author helloworld
* @description 针对表【student_info】的数据库操作Service实现
* @createDate 2023-08-17 10:27:37
*/
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo>
    implements StudentInfoService{

}




