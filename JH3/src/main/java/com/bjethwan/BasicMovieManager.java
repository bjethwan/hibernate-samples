package com.bjethwan;

import java.util.List;

import org.hibernate.Session;
import static com.bjethwan.HibernateUtil.*;

public class BasicMovieManager {

	public void persist(Movie movie)
	{
		Session session = getAppSessionFactory().openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
	}


	public Movie query(int movieId)
	{
		Movie movie = null;
		Session session = getAppSessionFactory().openSession();
		session.beginTransaction();
		movie = (Movie)session.load(Movie.class, movieId);
		session.getTransaction().commit();
		return movie;
	}
	
	public List<Movie> listAll()
	{
		List<Movie> list = null;
		Session session = getAppSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Movie").list();
		session.getTransaction().commit();		
		return list;
	}


}
