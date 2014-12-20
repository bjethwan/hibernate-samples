package com.bjethwan;

import static com.bjethwan.HibernateUtil.getAppSessionFactory;

public class Main {
	public static void main(String[] args) 
	{
		Movie movie = new Movie();
		movie.setId(4);
		movie.setTitle("This is from JH4 project");
		movie.setDirector("Offcourse me");
		movie.setSynopsis("trying session context");
		
		BasicMovieManager movieManager = new BasicMovieManager();
		movieManager.persist(movie);
		System.out.println(movieManager.query(2));
		System.out.println(movieManager.listAll());
		
		if(getAppSessionFactory()!=null){
			getAppSessionFactory().close();
		}
	}

}
