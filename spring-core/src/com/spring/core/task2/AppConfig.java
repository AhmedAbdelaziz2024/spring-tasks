package com.spring.core.task2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserService personService() {
        return new PersonService();
    }

    @Bean
    public AccountService accountServiceImpl() {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setUserService(personService());
        return accountService;
    }
}
