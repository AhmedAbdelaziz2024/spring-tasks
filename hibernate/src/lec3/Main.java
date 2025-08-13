package lec3;

import lec4.task2.Doctor;
import lec4.task2.DoctorDetails;
import lec4.task2.Hospital;
import lec4.task2.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Hospital.class)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(DoctorDetails.class)
                .addAnnotatedClass(Patient.class);

        SessionFactory factory =  config.buildSessionFactory();
        Session session = factory.getCurrentSession();

        factory.close();
        session.close();

    }
}