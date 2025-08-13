package lec4.task1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Player.class);

        SessionFactory factory =  config.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //save player (save object with any data)
        Player player = new Player(1,"Ahmed",10,true);
        session.save(player);
        transaction.commit();

        //update player (update object)
        Player player1 = new Player(1,"Ahmed",30,true);
        session.update(player1);
        transaction.commit();

        //get player by id (get object with id)
        Player player2 = session.get(Player.class,1L);
        System.out.println(player2.toString());


        //delete player (delete object)
        //Note:when delete the object hibernate auto check or select the object by id first then delete the object
        Player player3 = new Player(1,"Ahmed",10,true);
        session.delete(player3);
        transaction.commit();


        factory.close();
        session.close();

    }
}
