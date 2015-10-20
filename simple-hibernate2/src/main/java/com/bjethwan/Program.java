package com.bjethwan;

import java.util.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getAppSessionFactory().openSession();
		
		//Transaction# 1
		session.beginTransaction();
		
		User user = new User();
		user.setName("Shaurya");
		user.getUserHistory().add(new UserHistory(new Date(), "Created new user Shaurya"));
		user.getProteinData().setGoal(100);
		user.getUserHistory().add(new UserHistory(new Date(), "Set protein goal as 100"));
		
		Integer userid = (Integer)session.save(user);	
		session.getTransaction().commit();
		
		
		//Transaction# 2
		session.beginTransaction();
		
		User dbUser = (User)session.load(User.class, userid);
		System.out.println("User:" + dbUser.getName()+" Goal: "+dbUser.getProteinData().getGoal());
		dbUser.getProteinData().setTotal(dbUser.getProteinData().getTotal()+5);
		dbUser.getUserHistory().add(new UserHistory(new Date(), "Existing total protein as 5"));
		
		session.getTransaction().commit();
		session.close();
		
		
		HibernateUtil.getAppSessionFactory().close();
	}
}


