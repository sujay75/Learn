package com.learn.hibernate.session.flush.merge.example21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learn.hibernate.configuration.HibernateConfigUtil;

public class FlushMergeEvictExample {

    public static void main(String[] args) throws InterruptedException {

        // here creating the record
        SessionFactory sessionFactory = HibernateConfigUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i <= 10; i++) {
            ProductDetail pd = new ProductDetail();
            pd.setpName("product" + i);
            session.save(pd);
        }
        closeSession(session);
        /**
         * output
         * Name::product1
         * Name::product1
         * Hibernate: select productdet0_.pid as pid1_19_0_, productdet0_.pName as pName2_19_0_ from ProductDetail productdet0_ where productdet0_.pid=?
         * Name::product1111
         * 
         */
        session = beginSession();
        // Here session load retrieved from proxy object , so Name not updated in the proxy object even updated(backend) in database.
        ProductDetail pd11 = session.load(ProductDetail.class, 1);
        System.out.println("Name::" + pd11.getpName());// Name::product1
        Thread.sleep(10000);// here paused the program and updated the data in the back end.//eg: pName= "new name"
        ProductDetail pd12 = session.load(ProductDetail.class, 1);
        System.out.println("Name::" + pd12.getpName()); // Name::product1 (even though updated the value in the backend)
        // Try to evict the session object from cache and check the updated name.
        session.evict(pd12);// specific object removed from the cache
        ProductDetail pd13 = session.load(ProductDetail.class, 1);
        System.out.println("Name::" + pd13.getpName());
        closeSession(session);

        // Here clear() would remove all objects from cache associated with that session
        session = beginSession();
        ProductDetail pd14 = session.load(ProductDetail.class, 2);
        pd14.setpName("updatedName");
        System.out.println("Name2::" + pd14.getpName());// Name2::updatedName

        ProductDetail pd15 = session.load(ProductDetail.class, 2);
        System.out.println("Name2::" + pd15.getpName());// Name2::updatedName
        session.clear();// here pd14 and pd15 objects are removed from the first level cache even though
        // the name got updated in pd14 (in session level)

        ProductDetail pd16 = session.load(ProductDetail.class, 2);
        System.out.println("Name2::" + pd16.getpName());// Name2::product2
        closeSession(session);

        // Merge() : would add/update the object into persistend context and if object itself
        // is not available in loaded in the context, into context, would inserted into database
        /**
         * Hibernate: select productdet0_.pid as pid1_19_0_, productdet0_.pName as pName2_19_0_ from ProductDetail productdet0_ where productdet0_.pid=?
         * Name3::product3
         * Name3::3product3
         * Name3::3product3
         * Hibernate: update ProductDetail set pName=? where pid=?
         */
        session = beginSession();
        ProductDetail pd17 = session.load(ProductDetail.class, 3);
        System.out.println("Name3::" + pd17.getpName());// Name3::product3

        ProductDetail pd18 = pd17;
        pd18.setpName("3product3");
        ProductDetail pd19 = (ProductDetail) session.merge(pd18);
        System.out.println("Name3::" + pd19.getpName());

        ProductDetail pd20 = session.load(ProductDetail.class, 3);
        System.out.println("Name3::" + pd20.getpName());
        closeSession(session);

        // Note: session.contains(obj)//to check wheather the object lies in session or not

        // flush() : When you call session.flush(), the statements are executed in database but it will not committed.
        // If you dont call session.flush() and if you call session.commit() , internally commit() method executes the statement and commits.
        session = beginSession();
        ProductDetail pd21 = session.load(ProductDetail.class, 4);
        pd21.setpName("new name update");
        // executed the updated query in database and commited to database.so would not be reflect in the database.
        // output :Name4::new name update
        // Hibernate: update ProductDetail set pName=? where pid=?
        System.out.println("Name4::" + pd21.getpName());
        session.flush();
        System.out.println("Name4::" + pd21.getpName());// updated name in cache and finally updated to database
        closeSession(session);
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
