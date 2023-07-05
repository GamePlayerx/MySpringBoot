package com.xcc.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("a","Hello");

        redisTemplate.boundValueOps("b").set("Redis");
    }

    @Test
    public void test2() {
        Object c = redisTemplate.opsForValue().get("a");
        System.out.println(c);
        Object d = redisTemplate.boundValueOps("b").get();
        System.out.println(d);
    }
}
