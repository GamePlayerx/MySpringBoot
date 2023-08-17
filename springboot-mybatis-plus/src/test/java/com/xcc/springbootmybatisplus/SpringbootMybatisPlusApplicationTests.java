package com.xcc.springbootmybatisplus;

import com.xcc.springbootmybatisplus.dao.UserInfoMapper;
import com.xcc.springbootmybatisplus.entity.StudentInfo;
import com.xcc.springbootmybatisplus.entity.UserInfo;
import com.xcc.springbootmybatisplus.service.StudentInfoService;
import com.xcc.springbootmybatisplus.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StudentInfoService studentInfoService;

    @Test
    void contextLoads() {
        UserInfo u = userInfoMapper.selectById(1);
        System.out.println(u);
    }

    @Test
    void test() {
        UserInfo userInfo = userInfoService.getById(1);
        System.out.println(userInfo);
    }

    @Test
    void add() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentName("GamePlayer-Joker");
        studentInfo.setStudentDay("26");
        studentInfo.setStudentMail("halo@hello.com");
        Boolean isSave = studentInfoService.save(studentInfo);

        List<StudentInfo> list = studentInfoService.list();
        System.out.println(list);
    }

}
