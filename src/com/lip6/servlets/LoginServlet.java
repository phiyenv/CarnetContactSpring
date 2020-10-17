package com.lip6.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lip6.daos.DAOAddress;
import com.lip6.daos.DAOContact;
import com.lip6.entities.Contact;
import com.lip6.services.ContactService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOContact contact = new DAOContact();
		ContactService.AddContact("haha", "hoho", "haha.hoho@hotmail.com",
				"0610929674", "0136893423", "France", "Paris", "3 rue du try", "15630");

		/*
		Contact c = contact.findById(1);

		if (c != null)
			response.getWriter().append("Find Contact BY ID: Contact Name: " + c.getFirstName());

		c = contact.findByName("imad");

		if (c != null)
			response.getWriter().append("Find Contact BY Name: Contact Name: " + c.getFirstName());
		
		contact.deleteContact(1);
		*/
		
		List<Contact> cs = contact.findAll();
		
		
		    cs.forEach((Contact c) -> { try {
				response.getWriter().append("Find Contact BY ID: Contact Name: " + c.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}});
			

	}

}
