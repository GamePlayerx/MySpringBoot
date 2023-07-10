package com.xcc.springbootenable;

import com.xcc.springbootenable.config.MyImportBeanDefinitionRegistrar;
import com.xcc.springbootenable.config.MyImportSelector;
import com.xcc.springbootenableother.config.EnablePerson;
import com.xcc.springbootenableother.config.PersonConfig;
import com.xcc.springbootenableother.demain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Map;

//@ComponentScan("com.xcc.springbootenableother.config")
//@Import(PersonConfig.class)
//@EnablePerson
//@Import(Person.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
@SpringBootApplication
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

//        Person perosn = (Person) context.getBean("person");
//        System.out.println(perosn);

        Map<String, Person> map = context.getBeansOfType(Person.class);
        System.out.println(map);
    }

}
