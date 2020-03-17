package com.learn.hibernate.criteriaquery.example18;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class CriteriaQueryExample {

    public static void main(String[] args) {

        // here creating the record
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i <= 10; i++) {
            StudentDetail student = new StudentDetail();
            student.setStudentName("student" + i);
            session.save(student);
        }

        closeSession(session);

        // retrieving the record using Criteria adding one restriction
        session = beginSession();
        Criteria criteria = session.createCriteria(StudentDetail.class)
                .add(Restrictions.eq("studentId", 1));

        System.out.println("Criteria adding one restriction result size=" + criteria.list().size());
        printList((List<StudentDetail>) criteria.list());
        closeSession(session);

        // retrieving the record using Criteria adding multiple restriction
        session = beginSession();
        criteria = session.createCriteria(StudentDetail.class)
                .add(Restrictions.gt("studentId", 1))
                .add(Restrictions.between("studentId", 2, 4));
        printList((List<StudentDetail>) criteria.list());
        closeSession(session);

        // retrieving the record using Criteria adding restriction or example
        session = beginSession();
        criteria = session.createCriteria(StudentDetail.class)
                .add(Restrictions.or(Restrictions.between("studentId", 1, 2),
                        Restrictions.between("studentId", 3, 4)));
        printList((List<StudentDetail>) criteria.list());
        closeSession(session);

        // retrieving the record using Criteria adding projections
        session = beginSession();
        criteria = session.createCriteria(StudentDetail.class).setProjection(Projections.property("studentId"))
                .setProjection(Projections.property("studentName"));
        for (String s : (List<String>) criteria.list()) {
            // query : select this_.studentName as y0_ from StudentDetail this_
            System.out.println(s);
        }
        closeSession(session);

        // retrieving the record using Criteria adding projections with max value
        session = beginSession();
        criteria = session.createCriteria(StudentDetail.class).setProjection(Projections.property("studentId"))
                .setProjection(Projections.max("studentId"));
        for (Integer s : (List<Integer>) criteria.list()) {
            // query : select max(this_.studentId) as y0_ from StudentDetail this_
            System.out.println(s);
        }
        closeSession(session);

        // using example not allowed in latest version
        /*
         * StudentDetail sd = new StudentDetail();
         * sd.setStudentName("student10");
         * Example example = new Example(sd);
         * criteria = session.createCriteria(StudentDetail.class).
         */
    }

    private static void printList(List<StudentDetail> list) {
        (list).stream().forEach(i -> {
            System.out.println(i.getStudentId() + "-" + i.getStudentName());
        });
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
