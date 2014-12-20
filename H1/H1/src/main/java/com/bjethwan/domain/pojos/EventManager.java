package com.bjethwan.domain.pojos;

import org.hibernate.Session;

import java.util.*;


public class EventManager {

	public static void main(String[] args) {
		EventManager mgr = new EventManager();

		if (args[0].equals("store")) {
			mgr.createAndStoreEvent("My Event", new Date());
		}else if (args[0].equals("list")) {
			List events = mgr.listEvents();
			for (int i = 0; i < events.size(); i++) {
				Event theEvent = (Event) events.get(i);
				System.out.println(
						"Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
						);
			}
		}else if (args[0].equals("addpersontoevent")) {
            Long eventId = mgr.createAndStoreEvent("My Event", new Date());
            Long personId = mgr.createAndStorePerson("Foo", "Bar");
            mgr.addPersonToEvent(personId, eventId);
            System.out.println("Added person " + personId + " to event " + eventId);
        }

		HibernateUtil.getAppSessionFactory().close();
	}

	private Long createAndStoreEvent(String title, Date theDate) {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		Long ret = (Long)session.save(theEvent);
		session.getTransaction().commit();
		return ret;
	}
	
	private Long createAndStorePerson(String fname, String lname) {
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

	private List listEvents() {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = session.createQuery("from Event").list();
		session.getTransaction().commit();
		return result;
	}

	private void addPersonToEvent(Long personId, Long eventId) {
		Session session = HibernateUtil.getAppSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person aPerson = (Person) session.load(Person.class, personId);
		Event anEvent = (Event) session.load(Event.class, eventId);
		aPerson.getEvents().add(anEvent);

		session.getTransaction().commit();
	}
}