package com.learn.hibernate.onetomany.mapping.example7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * Hibernate: create table UserDetails (userId number(10,0) not null, userName varchar2(255 char), vehicle_vehicleId number(10,0), primary key (userId))
 * Hibernate: create table Vehicle (vehicleId number(10,0) not null, vehicleName varchar2(255 char), primary key (vehicleId))
 * Hibernate: insert into Product (pname, pid) values (?, ?)
 * Hibernate: insert into Product (pname, pid) values (?, ?)
 * Hibernate: insert into Customer (name, cid) values (?, ?)
 * Hibernate: insert into CUSTOMER_PRODUCT (FK_CUSTOMER_ID, FK_PRODUCT_ID) values (?, ?)
 * Hibernate: insert into CUSTOMER_PRODUCT (FK_CUSTOMER_ID, FK_PRODUCT_ID) values (?, ?)
 *
 */
public class OneToManyMappingExample {

    public static void main(String[] args) {
        // Here one customer can have many products ,so designed like many to one relation ship
        Product product = new Product();
        product.setPname("product1");
        Product product2 = new Product();
        product2.setPname("product2");
        Customer customer = new Customer();
        customer.setName("Customer1");
        customer.getProduct().add(product);
        customer.getProduct().add(product2);
        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        // if we are not saving the vehicle table then we get below exception
        // Caused by: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing:
        // com.learn.hibernate.onetoone.mapping.example6.Vehicle
        session.save(product);
        session.save(product2);
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }
}
