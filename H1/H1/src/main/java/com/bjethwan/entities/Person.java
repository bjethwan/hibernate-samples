package com.bjethwan.entities;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private Long id;
	private int age;
	private String firstname;
	private String lastname;
	private Set<Event> events = new HashSet<>();
	private Set<String> emailAddresses = new HashSet<>();


	public Person() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Set<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(Set<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public Set getEvents() {
		return events;
	}

	public void setEvents(Set events) {
		this.events = events;
	}
	
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person: Name: "+getFirstname()+" "+getLastname()+" Age: "+getAge()+"\n";
	}

}