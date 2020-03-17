package com.learn.hibernate.lazyload.example5;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * By default the loading strategy is lazy loading i.e child object will not be fetched by default.
 * when explicity calling user.getDetList() then only child list object would be fetched.
 * for an element collection the fetch type can be changed like
 * @ElementCollection(fetch = FetchType.LAZY)
 *
 */
public class LazyLoadExample {

    public static void main(String[] args) {
        Department unvDept1 = new Department("dep1", "block1");
        Department unvDept2 = new Department("dep2", "block2");
        Set set = new HashSet<Department>();

        College college1 = new College(1, "college1", set);
        college1.getDeptList().add(unvDept1);
        college1.getDeptList().add(unvDept2);
        set = new HashSet<Department>();

        Department unvDept3 = new Department("dep3", "block3");
        Department unvDept4 = new Department("dep4", "block4");
        set = new HashSet<Department>();
        College college2 = new College(2, "college2", set);
        college2.getDeptList().add(unvDept3);
        college2.getDeptList().add(unvDept4);

        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(college1);
        session.save(college2);
        session.getTransaction().commit();
        session.close();
        session = sf.openSession();
        // here actually the proxy object would be returned, not the actual College object
        College college = session.get(College.class, 1);
        session.close();
        // Test: session is already closed but proxy object could not able to fetch the child dept object
        // so throwing the LazyInitializationException
        // if change to @ElementCollection(fetch = FetchType.EAGER) , while loading College class itself all the child elements would be fetched
        System.out.println(college.getDeptList().size());

    }

}
