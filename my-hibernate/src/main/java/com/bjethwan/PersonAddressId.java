package com.bjethwan;

import java.io.Serializable;
import java.util.Date;

public class PersonAddressId implements Serializable{
	
	private long personId;
	private long addressId;
	private Date entryDate;
	
	
	
	public PersonAddressId() {
		super();
	}
	
	
	public PersonAddressId(long personId, long addressId, Date entryDate) {
		super();
		this.personId = personId;
		this.addressId = addressId;
		this.entryDate = entryDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (addressId ^ (addressId >>> 32));
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + (int) (personId ^ (personId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonAddressId other = (PersonAddressId) obj;
		if (addressId != other.addressId)
			return false;
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	
	

}
