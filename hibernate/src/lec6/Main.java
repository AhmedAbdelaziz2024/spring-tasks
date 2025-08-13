package lec6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .addAnnotatedClass(Friends.class)
                .addAnnotatedClass(Post.class);

        SessionFactory factory =  config.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //task2 ->  based on task 1 ->(without using cascade)
       /* // Add user with user details
        User user1 = new User();
        user1.setName("Ahmed");
        user1.setAge(25);

        UserDetails details = new UserDetails();
        details.setAddress("Cairo");
        details.setPhone("01012345678");
        details.setUser(user1);
        user1.setUserDetails(details);

        session.save(user1);
        session.save(details);

        // Add user with friends
        User user2 = new User();
        user2.setName("Sara");
        user2.setAge(22);

        Friends f1 = new Friends();
        f1.setName("Mona");

        Friends f2 = new Friends();
        f2.setName("Ali");

        user2.getFriends().add(f1);
        f1.getUsers().add(user2);

        user2.getFriends().add(f2);
        f2.getUsers().add(user2);

        session.save(user2);
        session.save(f1);
        session.save(f2);

        // Add user with posts
        User user3 = new User();
        user3.setName("Omar");
        user3.setAge(30);

        Post p1 = new Post();
        p1.setHeader("First Post");
        p1.setContent("This is my first post.");
        p1.setUser(user3);

        Post p2 = new Post();
        p2.setHeader("Second Post");
        p2.setContent("This is my second post.");
        p2.setUser(user3);

        user3.getPosts().add(p1);
        user3.getPosts().add(p2);

        session.save(user3);
        session.save(p1);
        session.save(p2);*/

        //task2 ->  based on task 1 ->(please using cascade)
        //Add user with user details
        User user1 = new User();
        user1.setName("Ahmed");
        user1.setAge(25);

        UserDetails details = new UserDetails();
        details.setAddress("Cairo");
        details.setPhone("01012345678");

        user1.setUserDetails(details);
        details.setUser(user1);

        session.save(user1);

        //Add user with friends
        User user2 = new User();
        user2.setName("Sara");
        user2.setAge(22);

        Friends f1 = new Friends();
        f1.setName("Mona");

        Friends f2 = new Friends();
        f2.setName("Ali");

        user2.getFriends().addAll(Arrays.asList(f1, f2));
        f1.getUsers().add(user2);
        f2.getUsers().add(user2);

        session.save(user2);

        //Add user with posts
        User user3 = new User();
        user3.setName("Omar");
        user3.setAge(30);

        Post p1 = new Post();
        p1.setHeader("First Post");
        p1.setContent("This is my first post.");
        p1.setUser(user3);

        Post p2 = new Post();
        p2.setHeader("Second Post");
        p2.setContent("This is my second post.");
        p2.setUser(user3);

        user3.getPosts().addAll(Arrays.asList(p1, p2));

        session.save(user3);


        transaction.commit();
        factory.close();
        session.close();

    }
}
