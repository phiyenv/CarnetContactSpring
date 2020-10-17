package com.lip6.daos;

import java.util.List;

import com.lip6.entities.Contact;

public interface IDAOContact {

	
	public boolean addContact(Contact contact);

	public boolean deleteContact(long id);
	
	public boolean updateContact(Contact contact);
	
	public Contact findById(long id);
	
	public List<Contact> find(String keyword);
	
	public List<Contact> findAll();
}
