package com.learn.hibernate.elementcollection.with.jointable.example4;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class ElementCollectionExampleWithJoinColumn {

    public static void main(String[] args) {
        Dept_EX4 unvDept1 = new Dept_EX4("dep1", "block1");
        Dept_EX4 unvDept2 = new Dept_EX4("dep2", "block2");
        Set set = new HashSet<Dept_EX4>();

        University_EX4 unv = new University_EX4(3, "unv1", set);
        unv.getDeptList().add(unvDept1);
        unv.getDeptList().add(unvDept2);
        set = new HashSet<Dept_EX4>();
        Dept_EX4 unvDept3 = new Dept_EX4("dep3", "block3");
        Dept_EX4 unvDept4 = new Dept_EX4("dep4", "block4");
        set = new HashSet<Dept_EX4>();
        University_EX4 unv1 = new University_EX4(3, "unv2", set);
        unv1.getDeptList().add(unvDept3);
        unv1.getDeptList().add(unvDept4);

        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(unv);
        session.save(unv1);
        session.getTransaction().commit();
        session.close();
    }

}
