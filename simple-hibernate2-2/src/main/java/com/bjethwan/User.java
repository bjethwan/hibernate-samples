package com.bjethwan;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private long id;
	private String name;
	
	private ProteinData proteinData;
	
	private Set<UserHistory> userHistory;
	
	private Set<String> userEmailAddresses;
	
	
	public User(){
		this.id = PUID.getInstance().nextId();
		setProteinData(new ProteinData());
		setUserHistory(new HashSet<UserHistory>());
		setUserEmailAddresses(new HashSet<String>());
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
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public Set<UserHistory> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(Set<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}


	public Set<String> getUserEmailAddresses() {
		return userEmailAddresses;
	}

	public void setUserEmailAddresses(Set<String> userEmailAddresses) {
		this.userEmailAddresses = userEmailAddresses;
	}
}

