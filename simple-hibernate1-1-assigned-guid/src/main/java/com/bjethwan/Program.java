package com.bjethwan;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		
		//Transaction# 1
		session.beginTransaction();
		
		User user = new User();
		user.setId(CUID.getInstance().nextId());
		user.setName("Bipin");
		user.getProteinData().setGoal(250);
		
		Long userid = (Long)session.save(user);	
		session.getTransaction().commit();
		
		
		//Transaction# 2
		session.beginTransaction();
		
		User dbUser = (User)session.load(User.class, userid);
		System.out.println("User:" + dbUser.getName()+" Goal: "+dbUser.getProteinData().getGoal());
		dbUser.getProteinData().setTotal(dbUser.getProteinData().getTotal()+50);
		
		session.getTransaction().commit();
		session.close();
		
		
		HibernateUtil.getAppSessionFactory().close();
	}
}



