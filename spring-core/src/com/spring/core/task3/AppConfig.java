package com.spring.core.task3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public UserService personService() {
        return new PersonService();
    }
}
