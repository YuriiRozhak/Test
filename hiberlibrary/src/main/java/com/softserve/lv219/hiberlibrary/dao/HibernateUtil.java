package com.softserve.lv219.hiberlibrary.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softserve.lv219.hiberlibrary.entity.Author;
import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.entity.BookInstance;
import com.softserve.lv219.hiberlibrary.entity.ReadSession;
import com.softserve.lv219.hiberlibrary.entity.User;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static final Configuration configuration = new Configuration();
    static {
        try {
            // Creates the session factory from hibernate.cfg.xml
            configuration.addAnnotatedClass(Book.class)
            .addAnnotatedClass(Author.class)
            .addAnnotatedClass(BookInstance.class)
            .addAnnotatedClass(ReadSession.class)
            .addAnnotatedClass(User.class)
            .configure();
            sessionFactory = configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                    		.build());
        } catch (Exception e) {
            e.printStackTrace();
    }   }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }    } 