package com.learn.hibernate.manytomany.example10;

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
public class ManyToManyMappingExample {

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setItemName("item1");

        Item item2 = new Item();
        item2.setItemName("item2");

        Cart cart = new Cart();
        cart.setCartName("cart1");
        cart.getItems().add(item1);
        cart.getItems().add(item2);

        item1.getCart().add(cart);
        item2.getCart().add(cart);

        Cart cart1 = new Cart();
        cart1.setCartName("cart2");
        cart1.getItems().add(item1);
        cart1.getItems().add(item2);
        item1.getCart().add(cart1);
        item2.getCart().add(cart1);


        SessionFactory sf = HibernateConfigUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(cart);
        session.save(item1);
        session.save(item2);
        session.save(cart1);

        session.getTransaction().commit();
        session.close();
    }
}
