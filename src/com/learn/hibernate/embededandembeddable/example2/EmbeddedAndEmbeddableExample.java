package com.learn.hibernate.embededandembeddable.example2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class EmbeddedAndEmbeddableExample {

    public static void main(String[] args) {
        Address cd = new Address();
        cd.setCity("blr");
        cd.setCountry("IN");
        cd.setState("KA");
        Student std = new Student();
        std.setId(1);
        std.setName("jacl");
        std.setcAddress(cd);
        std.setpAddress(cd);
        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(std);
        session.getTransaction().commit();
        session.close();
    }
}
