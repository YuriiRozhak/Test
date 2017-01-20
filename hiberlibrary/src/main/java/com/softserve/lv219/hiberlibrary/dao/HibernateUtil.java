package com.softserve.lv219.hiberlibrary.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static final Configuration configuration = new Configuration();
    static {
        try {
            // Creates the session factory from hibernate.cfg.xml
            configuration.configure();
            sessionFactory = configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (Exception e) {
            e.printStackTrace();
    }   }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }    } // class