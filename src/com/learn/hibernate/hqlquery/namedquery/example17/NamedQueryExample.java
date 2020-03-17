package com.learn.hibernate.hqlquery.namedquery.example17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * 
 * Named query and Native queries can added in Entity level.
 * Note: multiple named queries and multiple native queries annotatble not allowed at entity.
 * Hibernate: select studentdet0_.studentId as studentId1_20_, studentdet0_.studentName as studentName2_20_ from STUDENT_DETAILS studentdet0_ where studentdet0_.studentId=?
 * Hql Named query result size=1
 * Hibernate: select * from student_details where studentname= ?
 * ql Named native query result size=1
 *
 */
public class NamedQueryExample {

    public static void main(String[] args) {
        StudentDetails student1 = new StudentDetails();
        student1.setStudentName("student1");
        StudentDetails student2 = new StudentDetails();
        student2.setStudentName("student2");
        StudentDetails student3 = new StudentDetails();
        student3.setStudentName("student3");
        StudentDetails student4 = new StudentDetails();
        student4.setStudentName("student4");
        // here creating the record
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        closeSession(session);

        // retrieving the record using HQL NamedQuery
        session = beginSession();
        Query query = session.createNamedQuery("studentDetails.byId");
        query.setInteger(1, 1);
        System.out.println("Hql Named query result size=" + query.list().size());
        closeSession(session);

        // retrieving the record using sql native NamedQuery
        session = beginSession();
        query = session.createNamedQuery("studentDetails.native.byId");
        query.setParameter(1, "student1");
        System.out.println("ql Named native query result size=" + query.list().size());
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
