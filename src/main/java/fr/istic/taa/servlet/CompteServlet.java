package fr.istic.taa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.taa.dao.CompteDao;
import fr.istic.taa.entities.Patient;
import fr.istic.taa.entities.Pro;
import fr.istic.taa.entities.Users;

@WebServlet(name="compteservlet",
urlPatterns={"/CompteServlet"})
public class CompteServlet {
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		EntityManagerFactory factory =   
	 			 Persistence.createEntityManagerFactory("prod");
			EntityManager manager = factory.createEntityManager();
			CompteDao test = new CompteDao(manager);

			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				if (request.getParameter("type").equals("Professionnel"))
				{
					Pro pro = new Pro(request.getParameter("name"),request.getParameter("adresse"), request.getParameter("speciality"));
					test.createCompte(pro, request.getParameter("pseudo"),request.getParameter("mdp"));
				
				}
				else if (request.getParameter("type").equals("Patient"))
				{
					Patient patient = new Patient (request.getParameter("name"),request.getParameter("adresse"));
					test.createCompte(patient, request.getParameter("pseudo"),request.getParameter("mdp"));
				
				}
				//Users users = test.logIn("laye", "salut");
				//test.logOut(users);
				//test.logIn( "Kas", "salut");
				//users.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();

			test.listCompte();
				
	   	 manager.close();
			System.out.println("... done");

		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +			
				" <LI>Nom: "
				+ request.getParameter("name") + "\n" +
				" <LI>Specialité: "
				+ request.getParameter("speciality") + "\n" +
				" <LI>adresse: "
				+ request.getParameter("adresse") + "\n" +
				"</UL>\n" +				
				"</BODY></HTML>");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
}
