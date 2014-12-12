package com.bjethwan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class BasicMovieManager {
	
	private SessionFactory sessionFactory = null;

	  // Creating SessionFactory using 4.2 version of Hibernate
	  private void initSessionFactory(){
		  sessionFactory = new Configuration()
          .configure() // configures settings from hibernate.cfg.xml
          .buildSessionFactory();
	  }
	
	public void persist(Movie movie){
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
        session.close();if(sessionFactory!=null){
        	sessionFactory.close();
        }

	}
	public Movie query(int id){
		return new Movie();
	}
	
	public static void main(String[] args) {
		BasicMovieManager movieManager = new BasicMovieManager();
		movieManager.initSessionFactory();
		Movie movie = new Movie();
		movie.setId(2);
		movie.setTitle("The man from Earth");
		movie.setDirector("Don't remember");
		movie.setSynopsis("a man through 14 centuries");
		movieManager.persist(movie);
	}
}
