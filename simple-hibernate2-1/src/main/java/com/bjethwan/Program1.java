package com.bjethwan;

import java.util.Date;

import org.hibernate.Session;

public class Program1 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		
		//Transaction# 1
		session.beginTransaction();
		
		User user = new User();
		user.setName("Bipin");
		
		user.getUserEmailAddresses().add("bipin.jethwani@kony.com");
		user.getUserEmailAddresses().add("jethwani.bipin@gmail.com");
		user.getUserEmailAddresses().add("jethwani.bipin@gmail.com");
		
		user.getUserHistory().add(new UserHistory(new Date(), "Created new user Bipin"));
		user.getProteinData().setGoal(250);
		user.getUserHistory().add(new UserHistory(new Date(), "Set protein goal as 250"));
		
		Long userid = (Long)session.save(user);	
		session.getTransaction().commit();
		
		
		//Transaction# 2
		session.beginTransaction();
		
		User dbUser = (User)session.load(User.class, userid);
		System.out.println("User:" + dbUser.getName()+" Goal: "+dbUser.getProteinData().getGoal());
		dbUser.getProteinData().setTotal(dbUser.getProteinData().getTotal()+50);
		dbUser.getUserHistory().add(new UserHistory(new Date(), "Existing total protein as 50"));
		
		session.getTransaction().commit();
		session.close();
		
		
		HibernateUtil.getAppSessionFactory().close();
	}
}


