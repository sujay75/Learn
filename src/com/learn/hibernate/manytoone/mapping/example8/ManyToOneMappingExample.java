package com.learn.hibernate.manytoone.mapping.example8;

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
public class ManyToOneMappingExample {

    public static void main(String[] args) {
        // Here one customer can have many products ,so designed like many to one relation ship
        Productt product = new Productt();
        product.setPname("product1");

        Productt product2 = new Productt();
        product2.setPname("product2");

        Customerr customer = new Customerr();
        customer.setName("Customer1");
        customer.getProduct().add(product);
        customer.getProduct().add(product2);

        product.setCustomer(customer);
        product2.setCustomer(customer);

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
