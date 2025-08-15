package com.spring.core.task3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppXML {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        UserService person1 = context.getBean("personService", UserService.class);
        person1.save("Ahmed");

        UserService person2 = context.getBean("personService", UserService.class);
        person2.save("Ali");

        context.close();
    }
}
