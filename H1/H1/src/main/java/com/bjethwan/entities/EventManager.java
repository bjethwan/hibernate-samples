package com.bjethwan.entities;

import org.hibernate.Session;

import java.util.*;


public class EventManager 
{

	public Long createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		Long ret = (Long)session.save(theEvent);
		session.getTransaction().commit();
		return ret;
	}
	
	public Long createAndStorePerson(String fname, String lname) {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person thePerson = new Person();
		thePerson.setFirstname(fname);
		thePerson.setLastname(lname);
		thePerson.setAge(fname.length()+lname.length());
		
		Long ret = (Long)session.save(thePerson);
		session.getTransaction().commit();
		return ret;
	}

	public List listEvents() {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = session.createQuery("from Event").list();
		session.getTransaction().commit();
		return result;
	}

	public void addPersonToEvent(Long personId, Long eventId) {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session.load(Person.class, personId);
		Event anEvent = (Event) session.load(Event.class, eventId);
		aPerson.getEvents().add(anEvent);

		session.getTransaction().commit();
	}
}