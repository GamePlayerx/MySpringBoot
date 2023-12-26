package com.xcc.redis;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/26
 */
public class ApiTest {
    JedisPool jedisPool;

    // 1 首先创建连接
    @BeforeTest
    public void beforeTest() {
        // 创建jedis连接池
        JedisPoolConfig config = new JedisPoolConfig();
        // 最大空闲连接
        config.setMaxIdle(10);
        // 最小空闲连接
        config.setMinIdle(5);
        // 最大空闲时间 这里设置的4秒
        config.setMaxWaitMillis(4000);
        // 最大连接数
        config.setMaxTotal(50);

        // 这里连接的是本地的redis，默认端口号是6379
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    @Test
    public void testString() {
        // 从池子中拿一个连接
        Jedis jedis = jedisPool.getResource();
        String name = jedis.get("myname");
        System.out.println("name====="+name);
    }

    // 9 关闭连接
    @AfterTest
    public void closeTest() {
        jedisPool.close();
    }

}
