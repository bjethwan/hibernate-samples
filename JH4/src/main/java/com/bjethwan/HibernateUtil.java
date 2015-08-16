package com.bjethwan;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() 
	{
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			ServiceRegistry serviceRegistry = 
					new StandardServiceRegistryBuilder().
						applySettings(configuration.getProperties()).
						build();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		}
		catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getAppSessionFactory(){
		return sessionFactory;
	}

}
