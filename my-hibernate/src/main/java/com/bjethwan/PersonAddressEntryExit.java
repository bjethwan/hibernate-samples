package com.bjethwan;

import java.util.Date;

public class PersonAddressEntryExit {

	private PersonAddressId personAddressId;
	private Date exitDate;


	public PersonAddressEntryExit() {
		super();
	}
	
	public PersonAddressEntryExit(long personId, long addressId, Date entryDate) {
		this.personAddressId = new PersonAddressId(personId,addressId, entryDate);
	}
	
	public PersonAddressEntryExit(long personId, long addressId, Date entryDate, Date exitDate) {
		this.personAddressId = new PersonAddressId(personId,addressId, entryDate);
		this.exitDate = exitDate;
	}


	public PersonAddressId getPersonAddressId() {
		return personAddressId;
	}


	public void setPersonAddressId(PersonAddressId personAddressId) {
		this.personAddressId = personAddressId;
	}


	public Date getExitDate() {
		return exitDate;
	}


	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}


	



}
