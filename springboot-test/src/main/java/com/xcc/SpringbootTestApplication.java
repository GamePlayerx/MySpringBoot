package com.xcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class SpringbootTestApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootTestApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootTestApplication.class, args);

        Jedis jedis = (Jedis) context.getBean("jedis");
        System.out.println(jedis);
//        String a = jedis.get("key1");
//        System.out.println(a);
//        String b = jedis.set("key2", "halo");
//        System.out.println(b);
//        String c = jedis.get("key2");
//        System.out.println(c);
    }

}
