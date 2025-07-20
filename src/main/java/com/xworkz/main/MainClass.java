package com.xworkz.main;

import com.xworkz.entities.User;
import jakarta.persistence.LockOption;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.locks.Lock;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory sessionFactory =null;
        Session session = null;
//        User user = new User();
//        User user1 = new User();
        User user3 = new User();

//        user.setName("Nick");
//        user.setEmail("nishanth@gmail.com");
//        user.setPassword("123456");
//        user.setGender("male");
//        user.setCity("kasargod");

//        user3.setName("ladoo");
//        user3.setEmail("ladoo@gmail.com");
//        user3.setPassword("naugthy");
//        user3.setGender("female");
//        user3.setCity("amaravati");
        try  {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

//            Creating Session
            session = sessionFactory.openSession();

//            Creating transaction
            Transaction transaction = session.beginTransaction();


//            session.persist(user3);
//            transaction.commit();

//            Select Operation
//            session.getEntityName(user1);

//                User user2 = session.byId(User.class).load(user1.getId());
//            if(user2 != null){
//                System.out.println(user2.getId());
//                System.out.println(user2.getName());
//                System.out.println(user2.getEmail());
//                System.out.println(user2.getPassword());
//                System.out.println(user2.getCity());
//                System.out.println(user2.getGender());
//            } else  {
//                System.out.print("The User Is Not Found!");
//            }


//            Update Operation

            User user2 = session.byId(User.class)
                    .with(LockMode.PESSIMISTIC_WRITE)
                    .load(3L);
            if(user2!=null) {
                user2.setGender("male");

                session.persist(user2);
                transaction.commit();
            } else {
                System.out.print("Null is expected");
            }

        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
