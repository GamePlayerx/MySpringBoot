//package com.xcc.springbootcondition.condition;
//
//import org.springframework.context.annotation.Conditional;
//
//import java.lang.annotation.*;
//
//// 元注解 Target，Retention，Documented 每个注解上都要加这三个
//@Target({ElementType.TYPE, ElementType.METHOD})             // 可以用在哪些地方
//@Retention(RetentionPolicy.RUNTIME)                         // 什么时候起作用
//@Documented                                                 // 生成javadoc
//@Conditional(ClassCondition.class)
//public @interface ConditionalOnClass {
//    String[] value();       // 注解参数
//
//}
