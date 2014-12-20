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

	/**
	 * automatic dirty checking
	 * 
	 * @param personId
	 * @param eventId
	 */
	public void addPersonToEventInOneTransaction(Long personId, Long eventId) 
	{
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session.load(Person.class, personId);
		Event anEvent = (Event) session.load(Event.class, eventId);
		aPerson.getEvents().add(anEvent);

		session.getTransaction().commit();
	}
	
	
	/**
	 * The call to update makes a detached object persistent again by binding it to a new unit of work, 
	 * so any modifications you made to it while detached can be saved to the database. 
	 * This includes any modifications (additions/deletions) you made to a collection of that entity object.
	 * 
	 * @param personId
	 * @param eventId
	 */
	public void addPersonToEventInTwoTransaction(Long personId, Long eventId) 
	{
        Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session
                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached
        Event anEvent = (Event) session.load(Event.class, eventId);

        session.getTransaction().commit();

        // End of first unit of work

        aPerson.getEvents().add(anEvent); // aPerson (and its collection) is detached

        // Begin second unit of work

        Session session2 = HibernateUtil.getAppSessionFactory().getCurrentSession();
        session2.beginTransaction();
        session2.update(aPerson); // Reattachment of aPerson

        session2.getTransaction().commit();
    }
	
	public void addPersonEmailAddress(Long personId, String emailAdddress)
	{
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person aPerson = (Person)session.load(Person.class, personId);
		aPerson.getEmailAddresses().add(emailAdddress);
		
		session.getTransaction().commit();
	}
}