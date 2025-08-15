package com.spring.core.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppJava {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService = context.getBean(AccountService.class);
        accountService.getSavePerson("Ali");
    }
}
