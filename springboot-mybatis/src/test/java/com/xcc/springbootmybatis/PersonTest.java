package com.xcc.springbootmybatis;

import com.xcc.springbootmybatis.entity.Person;
import com.xcc.springbootmybatis.mapper.PersonMapper;
import com.xcc.springbootmybatis.mapper.PersonXMLMapper;
import com.xcc.springbootmybatis.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonXMLMapper personXMLMapper;

    @Autowired
    private PersonService personService;

    @Test
    public void test() {
        List<Person> list = personMapper.list();
        System.out.println(list);
    }

    @Test
    public void demo() {
        List<Person> list = personXMLMapper.list();
        System.out.println(list);
    }

    static List<Person> list() {
        long startTime = System.currentTimeMillis();
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            list.add(new Person(Long.valueOf(i), String.valueOf(i), i));
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("执行时长：%d毫秒", (endTime - startTime));
        return list;
    }

    static List<Person> updateList() {
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            list.add(new Person(Long.valueOf(i), "a", i+i));
        }
        return list;
    }

    @Test
    public void addDemo() {
        personService.add(list());
    }

    @Test
    public void updateDemo() {
        personService.update(updateList());
    }

}
