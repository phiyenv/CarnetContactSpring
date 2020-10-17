package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Groups")
public class Group {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="group_id")
	 private long Id;
	 
	 private String groupName;
	 
	 @ManyToMany(mappedBy="groups")
	 private Set <Contact> contacts=new HashSet<Contact>();

	public Group() {
		 
	 }
	 
	 public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	
	 
}
