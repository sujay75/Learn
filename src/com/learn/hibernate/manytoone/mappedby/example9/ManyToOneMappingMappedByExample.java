package com.learn.hibernate.manytoone.mappedby.example9;

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
public class ManyToOneMappingMappedByExample {

    public static void main(String[] args) {
        Prodct product = new Prodct();
        product.setPname("product1");

        Prodct product2 = new Prodct();
        product2.setPname("product2");

        Custom customer = new Custom();
        customer.setName("Customer1");
        product.setCustomer(customer);
        product2.setCustomer(customer);
        customer.getProduct().add(product);
        customer.getProduct().add(product2);

        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(customer);
        session.save(product);
        session.save(product2);
        session.getTransaction().commit();
        session.close();
    }
}
