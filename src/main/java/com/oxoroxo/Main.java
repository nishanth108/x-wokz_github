package com.oxoroxo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Alien alien = new Alien();
        alien.setId(108);
        alien.setName("dora");
        alien.setWepon("nix");

        //making configuration with hibernate


       SessionFactory sessionFactory = new Configuration()
               .addAnnotatedClass(Alien.class)
               .configure()
               .buildSessionFactory();


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        //have to tell hibernate to save


       session.merge(alien);

        transaction.commit();

        System.out.println(alien);
        session.close();
        sessionFactory.close();

    }
}