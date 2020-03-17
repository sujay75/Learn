package com.learn.hibernate.entityobjectstates.example14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * 
 * Hibernate: insert into Organization (orgName, projectId) values (?, ?)
 * Hibernate: update Organization set orgName=? where projectId=?
 *
 */
public class ObjectStatesExample {
public static void main(String[] args) {
        Organization pj = new Organization();// this is transient object which doesn't in session
        pj.setOrgName("org1");

    SessionFactory sessionFactory =HibernateConfigUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
        // here it is persistent object since the object is in session .insert query will be triggered
        session.save(pj);
        // since the update in the org Name , hibernate will trigger the updated query to update the data even though explict update has not been called.
        pj.setOrgName("updated org");

    session.getTransaction().commit();
        session.close();
        // after comming from the session.close(), object is in detaced mode and no more interaction with hibernate session
}
}
