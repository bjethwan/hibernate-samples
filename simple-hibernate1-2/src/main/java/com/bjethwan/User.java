package com.bjethwan;

public class User {
	
	private long id;
	private String name;
	
	private ProteinData proteinData;
	
	public User(){
		this.id = CUID.getInstance().nextId();
		setProteinData(new ProteinData());
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
		proteinData.setUser(this);
		this.proteinData = proteinData;
	}
}

