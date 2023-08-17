package com.xcc.springbootmybatisplus.mapper;

import com.xcc.springbootmybatisplus.entity.StudentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author helloworld
* @description 针对表【student_info】的数据库操作Mapper
* @createDate 2023-08-17 10:27:37
* @Entity com.xcc.springbootmybatisplus.entity.StudentInfo
*/
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {

}




