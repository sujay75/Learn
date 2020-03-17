package com.learn.hibernate.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.learn.hibernate.cache.example19.LecturerDetail;
import com.learn.hibernate.cascade.example11.Car;
import com.learn.hibernate.cascade.example11.Wheel;
import com.learn.hibernate.criteriaquery.example18.StudentDetail;
import com.learn.hibernate.curdoperations.example13.ProjectDetails;
import com.learn.hibernate.entityobjectstates.example14.Organization;
import com.learn.hibernate.entityobjectstates.example15.Organisation;
import com.learn.hibernate.hqlquery.example16.VehicleCategory;
import com.learn.hibernate.hqlquery.namedquery.example17.StudentDetails;
import com.learn.hibernate.inheritence.strategies.example12.Appartement;
import com.learn.hibernate.inheritence.strategies.example12.House;
import com.learn.hibernate.inheritence.strategies.example12.IndividualHouse;
import com.learn.hibernate.manytomany.example10.Cart;
import com.learn.hibernate.manytomany.example10.Item;
import com.learn.hibernate.manytoone.mappedby.example9.Custom;
import com.learn.hibernate.manytoone.mappedby.example9.Prodct;
import com.learn.hibernate.manytoone.mapping.example8.Customerr;
import com.learn.hibernate.manytoone.mapping.example8.Productt;
import com.learn.hibernate.onetomany.mapping.example7.Customer;
import com.learn.hibernate.onetomany.mapping.example7.Product;
import com.learn.hibernate.onetoone.mapping.example6.UserDetails;
import com.learn.hibernate.onetoone.mapping.example6.Vehicle;
import com.learn.hibernate.session.flush.merge.example21.ProductDetail;
import com.learn.hibernate.session.get.load.example20.LecturerDetails;

public class HibernateConfigUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
                settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521/orcl");
                // settings.put(Environment.USER, "sys as sysdba");
                // settings.put(Environment.PASS, "MainKey3");
                settings.put(Environment.USER, "ibs_sys");
                settings.put(Environment.PASS, "ibs_sys");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle12cDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");
                settings.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
                settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
                settings.put(Environment.USE_QUERY_CACHE, "true");

                // create-drop : on startup this would be dropping table and recreating.
                // update- only updates the table if entity changes
                configuration.addAnnotatedClass(com.learn.hibernate.saveoperation.example1.Employee.class);
                configuration.addAnnotatedClass(com.learn.hibernate.embededandembeddable.example2.Student.class);
                // if not configured then Exception in thread "main" org.hibernate.MappingException: Unknown entity: com.learn.hibernate.example1.University
                configuration.addAnnotatedClass(com.learn.hibernate.elementcollection.example3.University_EX3.class);
                configuration.addAnnotatedClass(com.learn.hibernate.lazyload.example5.College.class);
                configuration.addAnnotatedClass(com.learn.hibernate.elementcollection.example3.Dept_EX3.class);
                configuration.addAnnotatedClass(com.learn.hibernate.lazyload.example5.Department.class);
                configuration.addAnnotatedClass(UserDetails.class);
                configuration.addAnnotatedClass(Vehicle.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Customerr.class);
                configuration.addAnnotatedClass(Productt.class);
                configuration.addAnnotatedClass(Custom.class);
                configuration.addAnnotatedClass(Prodct.class);
                configuration.addAnnotatedClass(Cart.class);
                configuration.addAnnotatedClass(Item.class);
                configuration.addAnnotatedClass(Car.class);
                configuration.addAnnotatedClass(Wheel.class);
                configuration.addAnnotatedClass(Appartement.class);
                configuration.addAnnotatedClass(IndividualHouse.class);
                configuration.addAnnotatedClass(House.class);
                configuration.addAnnotatedClass(ProjectDetails.class);
                configuration.addAnnotatedClass(Organization.class);
                configuration.addAnnotatedClass(Organisation.class);
                configuration.addAnnotatedClass(VehicleCategory.class);
                configuration.addAnnotatedClass(StudentDetails.class);
                configuration.addAnnotatedClass(StudentDetail.class);
                configuration.addAnnotatedClass(LecturerDetail.class);
                configuration.addAnnotatedClass(LecturerDetails.class);
                configuration.addAnnotatedClass(ProductDetail.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(settings).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
