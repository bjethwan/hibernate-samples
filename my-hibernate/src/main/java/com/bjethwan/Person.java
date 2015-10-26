package com.bjethwan;

import java.util.HashSet;
import java.util.Set;

public class Person {
	
	private long id;
	private String name;
	private Set<PersonAddressEntryExit> addresses;
	
	
	public Person(){
		this.setId(PUID.getInstance().nextId());
		this.setAddresses(new HashSet<PersonAddressEntryExit>());
	}
	
	public Person(String name){
		this();
		this.setName(name);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PersonAddressEntryExit> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<PersonAddressEntryExit> addresses) {
		this.addresses = addresses;
	}
	
}
