package com.bjethwan;

import static com.bjethwan.HibernateUtil.getAppSessionFactory;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException 
	{
		
		
		
		Movie movie2 = new Movie();
		movie2.setId(2);
		movie2.setTitle("The man from Earth");
		movie2.setDirector("Don't remember");
		movie2.setSynopsis("a man lived through 14 centuries");
		
		Movie movie3 = new Movie();
		movie3.setId(3);
		movie3.setTitle("Something fishy");
		movie3.setDirector("Bipin Jethwani");
		movie3.setSynopsis("don't know");
		
		
		
		BasicMovieManager movieManager = new BasicMovieManager();
		movieManager.persist(movie2);
		movieManager.persist(movie3);
		System.out.println(movieManager.query(2));
		System.out.println(movieManager.listAll());
		TimeUnit.MINUTES.sleep(2);
		System.out.println(movieManager.updateSynopsis(3, "TODO: download the movie"));
		
		if(getAppSessionFactory()!=null){
			getAppSessionFactory().close();
		}
	}

}
