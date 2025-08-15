package com.spring.core.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        UserService person = (UserService) context.getBean("personServiceCore");
        UserService manager = (UserService) context.getBean("managerService");

        person.save("Ahmed");
        person.update("Ahmed");

        manager.save("Ali");
        manager.update("Ali");
    }
}
