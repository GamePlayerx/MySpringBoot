//package com.xcc.springbootcondition.config;
//
//import com.xcc.springbootcondition.condition.ConditionalOnClass;
//import com.xcc.springbootcondition.domain.User;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//// 配置类
//@Configuration
//public class UserConfig {
//
//    @Bean
////    @Conditional(ClassCondition.class)      // 只有当条件满足，才new这个对象，没满足不操作
////    @ConditionalOnClass({"jedis","fastJson"})
//    @ConditionalOnClass({"redis.clients.jedis.Jedis"})      // 这个注解不用我们自己写，springboot自己写好了
//    public User user() {
//        return new User();
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "ipAddress", havingValue="localhost")
//    public User user2() {
//        return new User();
//    }
//}
