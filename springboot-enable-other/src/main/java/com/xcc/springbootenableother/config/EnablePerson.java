package com.xcc.springbootenableother.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(PersonConfig.class)
public @interface EnablePerson {
}
