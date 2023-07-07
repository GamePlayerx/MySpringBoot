package com.xcc.springbootenable;

import com.xcc.springbootenableother.config.EnablePerson;
import com.xcc.springbootenableother.config.PersonConfig;
import com.xcc.springbootenableother.demain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan("com.xcc.springbootenableother.config")
//@Import(PersonConfig.class)
@EnablePerson
@SpringBootApplication
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

        Person perosn = (Person) context.getBean("person");
        System.out.println(perosn);
    }

}
