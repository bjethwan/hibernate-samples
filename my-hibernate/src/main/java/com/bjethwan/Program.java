package com.bjethwan;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {

		Session session = HibernateUtil.getAppSessionFactory().openSession();

		//Transaction# 1
		session.beginTransaction();



		Person tenant = new Person("Tenant");
		Person bipin = new Person("Bipin");
		Person shaurya = new Person("shaurya");

		Address address = new Address();
		address.setAddress("D-202 Rainbow Vistas");
		address.setCity("Hyderabad");
		address.setCountry("India");
		session.save(address);

		Address knpAddressShaurya = new Address();
		knpAddressShaurya.setAddress("LIG-637");
		knpAddressShaurya.setCity("Kanpur");
		knpAddressShaurya.setCountry("India");
		session.save(knpAddressShaurya);

		Address knpAddressBipin = new Address();
		knpAddressBipin.setAddress("Gumti");
		knpAddressBipin.setCity("Kanpur");
		knpAddressBipin.setCountry("India");
		session.save(knpAddressBipin);
		



		bipin.getAddresses().add(new PersonAddressEntryExit(bipin.getId(), address.getId(), new Date(2013-1900,0,1)));
		bipin.getAddresses().add(new PersonAddressEntryExit(bipin.getId(), knpAddressBipin.getId(), new Date(1981-1900,0,1), new Date(2004-1900, 0,1)));

		shaurya.getAddresses().add((new PersonAddressEntryExit(shaurya.getId(), address.getId(), new Date(2013-1900,0,1))));
		shaurya.getAddresses().add(new PersonAddressEntryExit(bipin.getId(), knpAddressShaurya.getId(), new Date(2010-1900,0,1), new Date(2011-1900, 0,1)));
		
		
		tenant.getAddresses().add(new PersonAddressEntryExit(tenant.getId(), address.getId(), new Date(2010-1900,0,1), new Date(2013-1900,0,1)));

		session.save(bipin);
		session.save(shaurya);
		session.save(tenant);

		session.getTransaction().commit();



		HibernateUtil.getAppSessionFactory().close();
	}
}


