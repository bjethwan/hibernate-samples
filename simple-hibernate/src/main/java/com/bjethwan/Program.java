package com.bjethwan;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		
	/** Transaction# 1 - Begin*/ 
		session.beginTransaction();
		
		User user = new User();
		user.setName("Bipin");
		user.setGoal(250);
		
		Integer userid = (Integer)session.save(user);	
		
		session.getTransaction().commit();
	/** Transaction# 1 - End*/ 
		
		
	/** Transaction# 2 - Begin*/ 
		session.beginTransaction();
		
		User dbUser = (User)session.load(User.class, userid);
		System.out.println("User:" + dbUser.getName()+" Goal: "+dbUser.getGoal());
		
		dbUser.setTotal(dbUser.getTotal() + 50);
		
		session.getTransaction().commit();
	/** Transaction# 2 - End*/
		
		
		session.close();
		HibernateUtil.getAppSessionFactory().close();
		
		
	}
}


