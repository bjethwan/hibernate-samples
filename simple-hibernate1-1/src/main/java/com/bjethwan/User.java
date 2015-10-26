package com.bjethwan;

public class User {
	
	private int id;
	private String name;
	
	private ProteinData proteinData;
	
	public User(){
		setProteinData(new ProteinData());
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		proteinData.setUser(this);
		this.proteinData = proteinData;
	}
}
