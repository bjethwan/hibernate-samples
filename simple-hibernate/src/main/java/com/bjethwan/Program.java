package com.bjethwan;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		
		//Transaction# 1
		session.beginTransaction();
		
		User user = new User();
		user.setName("Bipin");
		user.setGoal(250);
		
		session.save(user);	
		session.getTransaction().commit();
		
		
		//Transaction# 2
		session.beginTransaction();
		
		User dbUser = (User)session.load(User.class, 1);
		System.out.println("User:" + dbUser.getName()+" Goal: "+dbUser.getGoal());
		dbUser.setTotal(dbUser.getTotal()+50);
		
		session.getTransaction().commit();
		session.close();
		
		
		HibernateUtil.getAppSessionFactory().close();
	}
}

