package com.learn.hibernate.cache.example19;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * 
 * To retrieve data from second level cache configuration should be added at entity level  and configuration class
 * 
 * 1. @Cacheable // should be used for second level cache
 *    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)// should be used for second level cache
 *    
 * 2.  settings.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
        settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
        
    3. To enable the query level cache add the below configuration
    settings.put(Environment.USE_QUERY_CACHE, "true");
 * 
 * 
 *
 */
public class CacheExample {

    public static void main(String[] args) {

        // here creating the record
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i <= 10; i++) {
            LecturerDetail lecturer = new LecturerDetail();
            lecturer.setLectName("student" + i);
            session.save(lecturer);
        }

        closeSession(session);

        // retrieving the record using first level cache :session
        session = beginSession();
        LecturerDetail lec1 = session.get(LecturerDetail.class, 1);
        // assume some code is there
        LecturerDetail lec2 = session.get(LecturerDetail.class, 1);
        // but one only select query is exectued since there is no change in the query criteria and which is in first level cache
        // Hibernate: select lecturerde0_.lecId as lecId1_13_0_, lecturerde0_.lectName as lectName2_13_0_ from LecturerDetail lecturerde0_ where lecturerde0_.lecId=?

        closeSession(session);

        // retrieving the record using first level cache with update
        session = beginSession();
        LecturerDetail lec3 = session.get(LecturerDetail.class, 1);
        lec3.setLectName("updated name");
        LecturerDetail lec4 = session.get(LecturerDetail.class, 1);
        // but one select query and one update query is exectued since there is no change in the query criteria and which is in first level cache
        // Hibernate: select lecturerde0_.lecId as lecId1_13_0_, lecturerde0_.lectName as lectName2_13_0_ from LecturerDetail lecturerde0_ where lecturerde0_.lecId=?
        // Hibernate: update LecturerDetail set lectName=? where lecId=?
        closeSession(session);

        // retrieving the record from the second level cache
        session = beginSession();
        System.out.println("retrieving from second level cache:::");
        LecturerDetail lec5 = session.get(LecturerDetail.class, 1);
        System.out.println("second level cache data::" + lec5.getLectName());

        closeSession(session);

        // retrieving the record from the query level cache
        session = beginSession();
        System.out.println("retrieving from query cache:::");
        // select lecturerde0_.lecId as lecId1_13_, lecturerde0_.lectName as lectName2_13_ from LecturerDetail lecturerde0_ where lecturerde0_.lecId=1
        LecturerDetail lec7 = ((LecturerDetail) session.createQuery("from LecturerDetail where lecId=1").getResultList().get(0));
        System.out.println("querycache data::" + lec7.getLectName());
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
