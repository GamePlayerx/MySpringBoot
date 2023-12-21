package com.xcc.springbootmybatis.service;

import com.xcc.springbootmybatis.entity.Person;

import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/8/28
 */
public interface PersonService {
    List<Person> list();

    int add(List<Person> list);

    int update(List<Person> list);
}
