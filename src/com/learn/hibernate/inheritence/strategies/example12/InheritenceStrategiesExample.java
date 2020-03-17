package com.learn.hibernate.inheritence.strategies.example12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

/**
 * single table strategy:
 * Hibernate: insert into House (homeName, DTYPE, homeId) values (?, 'House', ?)
 * Hibernate: insert into House (homeName, ownerName, DTYPE, homeId) values (?, ?, 'IndividualHouse', ?)
 * Hibernate: insert into House (homeName, builderName, DTYPE, homeId) values (?, ?, 'Appartement', ?)
 * Dtype is the column which represent the class name, this can be overidden by
 * HOUSE_TYPE HOMEID, HOMENAME, BUILDERNAME, OWNERNAME
 * House 1 Dream Home
 * Individual-House 2 Sujay bharadwaj
 * Appartment/Building 3 App1 appgroup
 * 
 * table per class strategy: for every class respective table would be created and redundant fields will exists in both parent and child tables
 * 
 * Hibernate: insert into House (homeName, homeId) values (?, ?)
 * Hibernate: insert into IndividualHouse (homeName, ownerName, homeId) values (?, ?, ?)
 * Hibernate: insert into Appartement (homeName, builderName, homeId) values (?, ?, ?)
 * 
 * joined strategy:
 * Hibernate: insert into House (homeName, HOUSE_TYPE, homeId) values (?, 'House', ?)
 * Hibernate: insert into House (homeName, HOUSE_TYPE, homeId) values (?, 'Individual-House', ?)
 * Hibernate: insert into IndividualHouse (ownerName, homeId) values (?, ?)
 * Hibernate: insert into House (homeName, HOUSE_TYPE, homeId) values (?, 'Appartment/Building', ?)
 * Hibernate: insert into Appartement (builderName, homeId) values (?, ?)
 */
public class InheritenceStrategiesExample {
public static void main(String[] args) {
        House house = new House();
        house.setHomeName("Dream Home");
        IndividualHouse indHouse = new IndividualHouse();
        indHouse.setHomeName("Sujay");
        indHouse.setOwnerName("bharadwaj");
        Appartement app = new Appartement();
        app.setHomeName("App1");
        app.setBuilderName("appgroup");

    SessionFactory sessionFactory =HibernateConfigUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
        session.persist(house);
        session.persist(indHouse);
        session.persist(app);
    session.getTransaction().commit();
        session.close();
}
}
