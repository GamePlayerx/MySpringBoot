package com.xcc.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcc.springbootmybatisplus.dao.UserInfoMapper;
import com.xcc.springbootmybatisplus.entity.StudentInfo;
import com.xcc.springbootmybatisplus.entity.UserInfo;
import com.xcc.springbootmybatisplus.service.StudentInfoService;
import com.xcc.springbootmybatisplus.service.UserInfoService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    void addTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("123");
        userInfo.setNames("aaa");
        userInfo.setAgeIng(1);

        for (int i = 0; i < 30; i++)
            userInfoMapper.insert(userInfo);
    }

    @Test
    void updateTest1() {
        LambdaUpdateWrapper<UserInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(UserInfo::getNames, "aaa")
                .set(UserInfo::getAgeIng, "2")
                .set(UserInfo::getNames, "bbb");

        int i = userInfoMapper.update(null,lambdaUpdateWrapper);
        System.out.println(i);
    }

    @Test
    void updateTest2() {
        LambdaUpdateWrapper<UserInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(UserInfo::getNames, "aaa");

        UserInfo userInfo = new UserInfo();
        userInfo.setAgeIng(2);
        userInfo.setNames("bbb");
        int i = userInfoMapper.update(null,lambdaUpdateWrapper);
        System.out.println(i);
    }

    @Test
    void PageTest() {
        Long current = 1L;
        Long size = 10L;
        IPage<UserInfo> page = new Page<>(current, size);
        userInfoMapper.selectPage(page, null);

        List<UserInfo> records = page.getRecords();
        System.out.println(records);
        long total = page.getTotal();
        System.out.println(total);
        long pages = page.getPages();
        System.out.println(pages);
    }

    @Test
    void selectTest() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "aaa")
                .gt("age", "2")
                .lt("age", "8");

        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        System.out.println(userInfos);
    }

    @Test
    void selectTest2() {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserInfo::getNames, "aaa")
                .like(UserInfo::getEmail, "1")
                .gt(UserInfo::getAgeIng, "2")
                .lt(UserInfo::getAgeIng, "8");

        List<UserInfo> userInfos = userInfoMapper.selectList(lambdaQueryWrapper);
        System.out.println(userInfos);
    }

    @Test
    void delete1() {
        int i = userInfoMapper.deleteById(1);
    }

    @Test
    void delete2() {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserInfo::getNames, "aaa");
        int i = userInfoMapper.delete(lambdaQueryWrapper);
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
