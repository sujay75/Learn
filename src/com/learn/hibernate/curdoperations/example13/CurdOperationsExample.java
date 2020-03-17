package com.learn.hibernate.curdoperations.example13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class CurdOperationsExample {
public static void main(String[] args) {
        ProjectDetails pj = new ProjectDetails();
        pj.setProjectName("project1");
        ProjectDetails p2 = new ProjectDetails();
        p2.setProjectName("project2");
    SessionFactory sessionFactory =HibernateConfigUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
        session.save(pj);
        session.save(p2);
        ProjectDetails pj3 = session.get(ProjectDetails.class, 1);
        System.out.println(pj3.getProjectName());
        pj3.setProjectName(pj3.getProjectName() + "updated");
        session.update(pj3);
        System.out.println(pj3.getProjectName());
        session.delete(pj3);
    session.getTransaction().commit();
        session.close();
}
}
