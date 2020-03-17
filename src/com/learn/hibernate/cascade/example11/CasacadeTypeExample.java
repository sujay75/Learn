package com.learn.hibernate.cascade.example11;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class CasacadeTypeExample {
public static void main(String[] args) {
    Wheel wheel1 = new Wheel();
    wheel1.setWheelName("wheel1");
    Wheel wheel2 = new Wheel();
    wheel2.setWheelName("wheel2");
    Car car = new Car();
    car.setCarName("JeepCompass");
    car.setWheel(Arrays.asList(new Wheel[] {wheel1,wheel2}));
    SessionFactory sessionFactory =HibernateConfigUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
        session.persist(car);
    session.getTransaction().commit();
        session.close();
}
}
