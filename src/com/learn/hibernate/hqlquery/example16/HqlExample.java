package com.learn.hibernate.hqlquery.example16;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * 
 * Hibernate: select vehiclecat0_.id as id1_26_, vehiclecat0_.categoryName as categoryName2_26_ from VehicleCategory vehiclecat0_
 *
 * 
 */
public class HqlExample {

    public static void main(String[] args) {
        VehicleCategory pj = new VehicleCategory();
        pj.setCategoryName("org1");
        VehicleCategory pj3 = new VehicleCategory();
        pj3.setCategoryName("org3");
        VehicleCategory pj4 = new VehicleCategory();
        pj4.setCategoryName("org4");
        VehicleCategory pj5 = new VehicleCategory();
        pj5.setCategoryName("org5");
        // here creating the record
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(pj);
        session.save(pj3);
        session.save(pj4);
        session.save(pj5);
        closeSession(session);

        // retrieving the record using HQL
        session = beginSession();
        List list = session.createQuery("from VehicleCategory").list();
        closeSession(session);
        System.out.println("size1=" + list.size());
        
        /**
         * retriving the record using hql pagination
         * Hibernate: select * from ( select row_.*, rownum rownum_ from ( select vehiclecat0_.id as id1_26_, vehiclecat0_.categoryName as categoryName2_26_ from VehicleCategory
         * vehiclecat0_ ) row_ where rownum <= ?) where rownum_ > ?
         * size=2
         */
        session = beginSession();
        Query query = session.createQuery("from VehicleCategory");
        query.setFirstResult(2);
        query.setMaxResults(2);
        System.out.println("size2=" + query.list().size());
        closeSession(session);
        /**
         * Parameter substitution example with bind variable
         * select vehiclecat0_.id as id1_26_, vehiclecat0_.categoryName as categoryName2_26_ from VehicleCategory vehiclecat0_ where vehiclecat0_.id=?
         */
        session = beginSession();
        query = session.createQuery("from VehicleCategory where id=?1");
        query.setInteger(1, 1);
        System.out.println("size3=" + query.list().size());
        closeSession(session);
        
        /**
         * Parameter substitution example with named parameter
         * Hibernate: select vehiclecat0_.id as id1_26_, vehiclecat0_.categoryName as categoryName2_26_ from VehicleCategory vehiclecat0_ where vehiclecat0_.id=?
         */
        session = beginSession();
        query = session.createQuery("from VehicleCategory where id=:id");
        query.setInteger("id", 1);
        System.out.println("size4=" + query.list().size());
        closeSession(session);

    }

    private static void closeSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    private static Session beginSession() {
        SessionFactory sessionFactory;
        Session session;
        sessionFactory = HibernateConfigUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
}
