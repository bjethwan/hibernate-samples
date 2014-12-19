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
			
			Configuration configuration = new Configuration()
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/JH")
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.username", "bipin")
				.setProperty("hibernate.connection.password", "jethwani")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.show_sql", "true")
				.addClass(Movie.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			        								.applySettings(configuration.getProperties())
			        								.build();
			
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
