package com.xcc.springbootmybatis.mapper;

import com.xcc.springbootmybatis.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonXMLMapper {
    List<Person> list();

    int add(Person person);

    int update(Person person);
}
