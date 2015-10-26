package com.bjethwan;

import java.util.Date;

public class UserHistory {
	
	private Date entryDate;
	private String entry;
	
	public UserHistory(){}
	public UserHistory(Date entryDate, String entry){
		this.entryDate=entryDate;
		this.entry=entry;
	}
	
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
}

