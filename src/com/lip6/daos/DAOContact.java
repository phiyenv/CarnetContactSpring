package com.lip6.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.Group;
import com.lip6.entities.PhoneNumber;
import com.lip6.util.JpaUtil;

public class DAOContact implements IDAOContact {

	@Override
	public boolean addContact(Contact contact) {

		// Avant l'utilisation de classe JpaUtil
		// EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");

		// 1: obtenir une connexion et un EntityManager, en passant par la classe
		// JpaUtil

		boolean success = false;

		try {
			EntityManager em = JpaUtil.getEmf().createEntityManager();

			// 2 : Ouverture transaction
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.persist(contact);
			//em.persist(address);no need after implementing cascade
			// ici l'objet est dans un �tat manag� par l'EM, pas besoin d'un nouveau
			// persist
			//contact.setFirstName("Blanquito");

			// 5 : Fermeture transaction
			tx.commit();

			// ici l'objet est dans un �tat d�tach� de l'EM, la modif ne sera pas
			// commit�e
			//contact.setFirstName("Blanchard");

			// 6 : Fermeture de l'EntityManager et de unit� de travail JPA
			em.close();

			// 7: Attention important, cette action ne doit s'executer qu'une seule fois et
			// non pas à chaque instantiation du ContactDAO
			// Donc, pense bien à ce qu'elle soit la dernière action de votre application
			// JpaUtil.close();

			success = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return success;

	}

	
	@Override
	public boolean deleteContact(long id) {
		// TODO Auto-generated method stub
		boolean result=true;
		try
		{
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			Contact c=(Contact)em.find(Contact.class, id);
			if(c!=null)
				em.remove(c);
			
			tx.commit();
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
            result=false;
		}
		return result;
	}
	

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	 
	public Contact findById(long id) {
		
		Contact c=null;
		try
		{
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			
			c=(Contact)em.find(Contact.class, id);
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return c;
	}
	

	@Override
	public List<Contact> find(String keyword) {
		// TODO Auto-generated method stub
		List<Contact> contacts=new ArrayList<Contact>();
		try
		{
			final String nativeQuery="SELECT contact_id, firstName, lastName, email, address_id FROM contacts where firstname like %:keyword% or lastname like %:keyword% or email like %:keyword%";
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			
			contacts= em.createNativeQuery(nativeQuery, Contact.class).setParameter("keyword",keyword).getResultList();
			
			em.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return contacts;
	}

	public List<Contact> findAll(){
		List<Contact> contacts=new ArrayList<Contact>();
		try
		{
			
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			
			contacts= em.createQuery("from Contact", Contact.class).getResultList();
			
			em.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return contacts;
	}
}
