package com.xcc.redisspringbootautoconfigure.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Author xcc
 * @Date 2023/8/10
 */
@Configuration
@EnableConfigurationProperties(com.xcc.redisspringbootautoconfigure.config.RedisProperties.class)
@ConditionalOnClass(Jedis.class)
public class RedisAutoConfigure {

    @Bean
    public Jedis jedis(com.xcc.redisspringbootautoconfigure.config.RedisProperties redisProperties) {
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }

}
