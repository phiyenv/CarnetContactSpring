package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.util.JpaUtil;

public class DAOAddress implements IDAOAddress  {

@Override
public boolean addAddress(String street, String city, String zip, String country) {
		
		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
	    boolean success=false;

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		// 3 : Instanciation Objet(s) m�tier (s)
		Address address = new Address(street,city, zip, country);
		
		
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		 
		
		em.persist(address);
		
		//ici l'objet est dans un �tat manag� par l'EM, pas besoin d'un nouveau persist
		address.setStreet("3 rue du hahahahahahah");
		
		// 5 : Fermeture transaction 
		tx.commit();
		
		//ici l'objet est dans un �tat d�tach� de l'EM, la modif ne sera pas commit�e
		address.setStreet("4 rue du hahahahhahahah");
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
		// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
		//Donc, pense bien à ce qu'elle soit la dernière action de votre application
		//JpaUtil.close();	
		
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return success;
		
	}
}
