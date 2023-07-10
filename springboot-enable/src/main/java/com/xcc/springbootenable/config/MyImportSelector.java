package com.xcc.springbootenable.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author xcc
 * @Date 2023/7/10
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.xcc.springbootenableother.demain.Person"};
    }
}
