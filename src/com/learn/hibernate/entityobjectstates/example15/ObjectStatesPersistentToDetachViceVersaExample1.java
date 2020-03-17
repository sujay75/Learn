package com.learn.hibernate.entityobjectstates.example15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * 
 * Hibernate: select organisati0_.projectId as projectId1_13_0_, organisati0_.orgName as orgName2_13_0_ from Organisation organisati0_ where organisati0_.projectId=?
 * Hibernate: select organisati_.projectId, organisati_.orgName as orgName2_13_ from Organisation organisati_ where organisati_.projectId=?
 * Hibernate: update Organisation set orgName=? where projectId=?
 * Hibernate: select organisati_.projectId, organisati_.orgName as orgName2_13_ from Organisation organisati_ where organisati_.projectId=?
 *
 * 
 */
public class ObjectStatesPersistentToDetachViceVersaExample1 {
public static void main(String[] args) {
        Organisation pj = new Organisation();// this is transient object which doesn't in session
        pj.setOrgName("org1");
        // here creating the record
    SessionFactory sessionFactory =HibernateConfigUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
        session.save(pj);
    session.getTransaction().commit();
        session.close();
        // retrieving the record
        sessionFactory = HibernateConfigUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        Organisation org = session.get(Organisation.class, 1);
        session.getTransaction().commit();
        session.close();
        // modifing the record ,means detached object to persist object
        sessionFactory = HibernateConfigUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        org.setOrgName("updated Name");
        session.update(org);
        session.getTransaction().commit();
        session.close();
        // here not updating any thing ,but still encounters the update query
        sessionFactory = HibernateConfigUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(org);
        session.getTransaction().commit();
        session.close();
        /**
         * to avoid unnecesary update call , we can add the annotation to check any
         * updates has been added to the object or not by select query
         * for that add @org.hibernate.annotations.Entity(selectBeforeUpdate = true) at entity level
         **/
}
}
