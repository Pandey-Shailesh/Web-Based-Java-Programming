package org.fi.boot.jpabootapp.dto;

public class ContactDTO {
	
	int contactId;
	String firstName;
	String lastName;
	String email;
	String phone;
	int dummyId;
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getDummyId() {
		return dummyId;
	}
	public void setDummyId(int dummyId) {
		this.dummyId = dummyId;
	}
	
}
