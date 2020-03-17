package com.learn.hibernate.saveoperation.example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class SaveOperationExample {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(3);
        emp.setName("sujay");
        emp.setAddress("blr");
        Employee emp1 = new Employee();
        emp1.setId(4);
        emp1.setName("sujay");
        emp1.setAddress("blr");
        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(emp);
        session.save(emp1);
        session.getTransaction().commit();
        session.close();

        session = sf.openSession();
        Employee employee = session.get(Employee.class, 1);
        System.out.println("Name = " + employee.getName());
    }

}
