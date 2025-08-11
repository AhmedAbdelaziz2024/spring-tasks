package com.spring.core.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppJava{
    public static void main(String[] args) {

    ApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    UserService person = (UserService) context.getBean("personService");
    UserService manager = (UserService) context.getBean("managerService");

    person.save("Eslam");
    person.update("Eslam");

    manager.save("Amr");
    manager.update("Amr");
}
}
