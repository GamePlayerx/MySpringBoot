package com.xcc.springbootmybatis.service.Impl;

import com.xcc.springbootmybatis.entity.Person;
import com.xcc.springbootmybatis.mapper.PersonMapper;
import com.xcc.springbootmybatis.mapper.PersonXMLMapper;
import com.xcc.springbootmybatis.service.PersonService;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/8/28
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Person> list() {
        return personMapper.list();
    }

    @Override
    public int add(List<Person> list) {

        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        PersonXMLMapper personMapper1 = sqlSession.getMapper(PersonXMLMapper.class);

        long startTime = System.currentTimeMillis();
        list.stream().forEach(m -> personMapper1.add(m));
        sqlSession.commit();
        sqlSession.rollback();
        long endTime = System.currentTimeMillis();
        System.out.printf("执行时长：%d毫秒", (endTime - startTime));

        return 0;
    }

    @Override
    public int update(List<Person> list) {

        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        PersonXMLMapper personXMLMapper = sqlSession.getMapper(PersonXMLMapper.class);

        long startTime = System.currentTimeMillis();
        list.stream().forEach(m -> personXMLMapper.update(m));
        sqlSession.commit();
        sqlSession.rollback();
        long endTime = System.currentTimeMillis();
        System.out.printf("执行时长：%d毫秒", (endTime - startTime));

        return 0;
    }
}
