package com.bjethwan;

import java.util.Date;
import java.util.List;

import com.bjethwan.entities.Event;
import com.bjethwan.entities.EventManager;
import com.bjethwan.entities.HibernateUtil;

public class Main 
{
	public static void main(String[] args) 
	{
		EventManager mgr = new EventManager();

		if (args[0].equals("store")) 
		{
			mgr.createAndStoreEvent("My Event", new Date());
		}
		else if (args[0].equals("list")) 
		{
			List events = mgr.listEvents();
			for (int i = 0; i < events.size(); i++) {
				Event theEvent = (Event) events.get(i);
				System.out.println(
						"Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
						);
			}
		}
		else if (args[0].equals("addpersontoevent")) 
		{
            Long eventId = mgr.createAndStoreEvent("My Event", new Date());
            Long personId = mgr.createAndStorePerson("Foo", "Bar");
            mgr.addPersonToEventInOneTransaction(personId, eventId);
            System.out.println("Added person " + personId + " to event " + eventId);
        }
		else if (args[0].equals("addpersontoevent2")) 
		{
            Long eventId = mgr.createAndStoreEvent("My Event", new Date());
            Long personId = mgr.createAndStorePerson("Bipin", "Jethwani");
            mgr.addPersonToEventInTwoTransaction(personId, eventId);
            System.out.println("Added person " + personId + " to event " + eventId);
        }
		else if (args[0].equals("addpersonemail")) 
		{
            Long personId = mgr.createAndStorePerson("Shaurya", "Jethwani");
            mgr.addPersonEmailAddress(personId, "test.test@yahoo.com");
            System.out.println("Added person " + personId + " email address as " + "test.test@yahoo.com");
        }

		HibernateUtil.getAppSessionFactory().close();
	}
}
