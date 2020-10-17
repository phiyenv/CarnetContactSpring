package com.lip6.services;

import java.util.List;

import com.lip6.daos.DAOContact;
import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;

public class ContactService {

	private static DAOContact dao=new DAOContact();
	
	public static boolean AddContact(String firstName, String lastName, String email, String mobile,
			String landphone, String country, String city, String street, String zipcode)
	{
		Contact contact=new Contact(firstName,lastName,email);
		Address address=new Address(country,city,street,zipcode);
		contact.setAddress(address);
		
		PhoneNumber phone1=new PhoneNumber("mobile",mobile);
		PhoneNumber phone2=new PhoneNumber("LandLine",landphone);
		
		//Set Contact Object for phones, else the contact_id will be null
		
		phone1.setContact(contact);
		phone2.setContact(contact);
		
		contact.getPhones().add(phone1);
		contact.getPhones().add(phone2);
		
		
		return dao.addContact(contact);
	}
    
	public static boolean deleteContact(long id)
	{
		return dao.deleteContact(id);
	}
	
	public static boolean UpdateContact(long id, String firstName, String lastName, String email)
	{
		Contact contact=new Contact(firstName,lastName, email);
		contact.setId(id);
		
		return dao.updateContact(contact);
	}
	
	public static Contact findById(long id)
	{
	  return dao.findById(id);
	}
	
	public static List<Contact> findAll()
	{
		return dao.findAll();
	}
	
	
}

