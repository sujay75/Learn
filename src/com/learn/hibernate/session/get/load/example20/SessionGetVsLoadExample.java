package com.learn.hibernate.session.get.load.example20;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * Notes :
 * differences between get() vs load():
 * 
 * 1. get() loads the data as soon as it’s called whereas load() returns a proxy object and loads data only when it’s actually required, so load() is better because it support lazy
 * loading.
 * Since load() throws exception when data is not found, we should use it only when we know data exists.
 * We should use get() when we want to make sure data exists in the database.
 *
 * 2.We can use session evict() method to remove a single object from the hibernate first level cache.
 * We can use session clear() method to clear the cache i.e delete all the objects from the cache.
 * We can use session contains() method to check if an object is present in the hibernate cache or not, if the object is found in cache, it returns true or else it returns false.
 * Since hibernate cache all the objects into session first level cache, while running bulk queries or batch updates it’s necessary to clear the cache at certain intervals to avoid
 * memory issues.
 */

public class SessionGetVsLoadExample {

    public static void main(String[] args) {

        // here creating the record
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i <= 10; i++) {
            LecturerDetails lecturer = new LecturerDetails();
            lecturer.setLectName("student" + i);
            session.save(lecturer);
        }
        closeSession(session);


        session = beginSession();
        LecturerDetails lec1 = session.get(LecturerDetails.class, 1);
        LecturerDetails lec2 = session.load(LecturerDetails.class, 1);
        System.out.println("lec1:" + lec1.getLectName());
        System.out.println("lec2:" + lec2.getLectName());
        closeSession(session);
        session = beginSession();
        LecturerDetails lec3 = session.get(LecturerDetails.class, 100);
        LecturerDetails lec4 = session.load(LecturerDetails.class, 100);// should use only when object must present in database
        System.out.println("lec3:" + lec3);// null get() will give null value
        System.out.println("lec4 id:" + lec4.getLecId());// 100 will get from proxy object
        System.out.println("lec4:" + lec4); // will throw execption org.hibernate.ObjectNotFoundException:
        // executed the below query select lecturerde0_.lecId as lecId1_14_0_, lecturerde0_.lectName as lectName2_14_0_ from LecturerDetails lecturerde0_ where lecturerde0_.lecId=?
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
