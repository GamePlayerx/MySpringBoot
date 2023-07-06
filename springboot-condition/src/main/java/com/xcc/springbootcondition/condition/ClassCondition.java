//package com.xcc.springbootcondition.condition;
//
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//
//import java.util.Map;
//
//public class ClassCondition implements Condition {
//    // 通过返回boolean值，就能确定是否生成bean对象
//    @Override
//    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        // 业务逻辑，通过true或false来决定某个bean对象是否生成
//
////        // 需求你的项目必须引入jedis，才生成User对象
////        try {
////            Class.forName("redis.clients.jedis.Jedis");
////            return true;
////        } catch (ClassNotFoundException e) {
////            return false;
////        }
//
//
//        try {
//            // 需求：必须引入 动态传来的包名，项目才生成User对象
//            Map<String, Object> map = metadata.getAnnotationAttributes("com.xcc.springbootcondition.condition.ConditionalOnClass");
//            System.out.println(map);
//
//            String [] values = (String[]) map.get("value");
//            for (String value : values) {
//                Class.forName(value);
//            }
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//}
