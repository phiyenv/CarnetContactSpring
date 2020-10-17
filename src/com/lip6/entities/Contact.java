package com.lip6.entities;


import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Contacts")
@NamedNativeQuery(name="Contact.FindContactById", query="SELECT id, firstname,"
		+ "lastname, email, id_address FROM contacts WHERE id=?", resultClass=Contact.class)
public class Contact implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id")
	private long id;
	
	private String firstName;
	private String lastName;
	private String email;
	
	//if you don't implement cascade in relation you should persist in entity manager
	@OneToOne (cascade =CascadeType.ALL)
	@JoinColumn(name="address_id")
    private Address address;
    
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="contact")
	private Set<PhoneNumber> phones =new HashSet<PhoneNumber>();

    
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="ContactsGroups",
	joinColumns=@JoinColumn(name="contact_id"),
	inverseJoinColumns=@JoinColumn(name="group_id"))
	private Set<Group> groups=new HashSet<>();
    
    

	public Contact(){
	}
	
    
	public Contact(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstname){
		this.firstName = firstname;
	}
	
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastname){
		this.lastName = lastname;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	

	public Set<PhoneNumber> getPhones() {
		return phones;
	}


	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}


	public Set<Group> getGroups() {
		return groups;
	}


	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address +  "]";
	}


	
	
	
}
