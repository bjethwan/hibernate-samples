package com.bjethwan;

import static com.bjethwan.HibernateUtil.getAppSessionFactory;

public class Main {
	public static void main(String[] args) 
	{
		Movie movie = new Movie();
		movie.setId(2);
		movie.setTitle("The man from Earth");
		movie.setDirector("Don't remember");
		movie.setSynopsis("a man lived through 14 centuries");
		
		BasicMovieManager movieManager = new BasicMovieManager();
		movieManager.persist(movie);
		System.out.println(movieManager.query(2));
		System.out.println(movieManager.listAll());
		
		if(getAppSessionFactory()!=null){
			getAppSessionFactory().close();
		}
	}

}
