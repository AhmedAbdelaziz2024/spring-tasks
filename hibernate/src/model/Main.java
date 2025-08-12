package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(teacher.class);

        SessionFactory factory =  config.buildSessionFactory();
        Session session = factory.getCurrentSession();

        factory.close();
        session.close();

    }
}