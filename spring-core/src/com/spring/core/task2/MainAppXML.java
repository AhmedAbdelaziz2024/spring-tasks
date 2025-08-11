package com.spring.core.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        AccountService accountService = context.getBean("accountServiceImpl", AccountService.class);
        accountService.getSavePerson("Ahmed");
    }
}
