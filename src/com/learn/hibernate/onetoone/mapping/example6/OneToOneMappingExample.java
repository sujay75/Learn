package com.learn.hibernate.onetoone.mapping.example6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class OneToOneMappingExample {

    public static void main(String[] args) {
        Vehicle vh = new Vehicle();
        vh.setVehicleName("CAR5");
        UserDetails user = new UserDetails();
        user.setUserName("user5");
        user.setVehicle(vh);
        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        // if we are not saving the vehicle table then we get below exception
        // Caused by: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing:
        // com.learn.hibernate.onetoone.mapping.example6.Vehicle
        session.save(vh);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
