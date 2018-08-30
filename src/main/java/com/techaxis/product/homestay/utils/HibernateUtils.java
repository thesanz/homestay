package com.techaxis.product.homestay.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtils {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
//                    .configure("hibernate.cfg.xml").build();
            
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.configure("hibernate.cfg.xml"); 
            ServiceRegistry service = sb.build();
            
            
            // Create a metadata sources using the specified service registry.
            
            MetadataSources mds = new MetadataSources(service);
            MetadataBuilder mdb = mds.getMetadataBuilder();
           // Metadata metadata = new MetadataSources(service).getMetadataBuilder().build();
            Metadata metadata = mdb.build();
            
            SessionFactoryBuilder sfb = metadata.getSessionFactoryBuilder();
            
            SessionFactory sf = sfb.build();
 
            return sf;
        } catch (Throwable ex) {
         
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
 
}