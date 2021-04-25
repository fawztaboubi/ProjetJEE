package Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DataAccess {

	private static SessionFactory sessionFactory;
	
	 public static SessionFactory buildSessionAnnotationFactory() {
	    	try {
	            // Create the SessionFactory from hibernate.cfg.xml
	        	Configuration configuration = new Configuration();
	        	configuration.configure("hibernate.cfg.xml");
	        	System.out.println("Hibernate Annotation Configuration loaded");
	        	
	        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        	System.out.println("Hibernate Annotation serviceRegistry created");
	        	
	        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        	
	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
		}
	 
	 
	 public static SessionFactory getSessionAnnotationFactory() {
			if(sessionFactory == null) sessionFactory = buildSessionAnnotationFactory();
	        return sessionFactory;
	    }
	
}
