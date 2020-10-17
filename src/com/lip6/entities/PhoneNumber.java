package com.lip6.entities;

import javax.persistence.*;

@Entity
@Table(name="PhoneNumbers")
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String phoneKind;
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="contact_id")
	private Contact contact;

	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(String phoneKind, String phoneNumber) {
		super();
		
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
	
	

}
