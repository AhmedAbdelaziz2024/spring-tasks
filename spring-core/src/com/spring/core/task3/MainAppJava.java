package com.spring.core.task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppJava {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService person1 = context.getBean(UserService.class);
        person1.save("Ahmed");

        UserService person2 = context.getBean(UserService.class);
        person2.save("Ali");

        ((PersonService) person1).destroy();
        ((PersonService) person2).destroy();

        context.close();
    }

}
