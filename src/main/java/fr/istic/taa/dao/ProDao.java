 package fr.istic.taa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import fr.istic.taa.entities.Pro;
import fr.istic.taa.entities.RendezVous;
import fr.istic.taa.entities.Users;



public class ProDao {
	
	private EntityManager manager;

	public ProDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void creerPro(String name, String adress,String speciality, String pseudo, String mdp)
	{
		Pro pro = new Pro(name, adress, speciality);
		manager.persist(pro);
		CompteDao compte = new CompteDao(manager);
		compte.createCompte(pro, pseudo, mdp);
		
	}
	
	public void listRendezVous(Pro pro)
	{
		List<RendezVous> resultList = manager.createQuery("Select a From RendezVous a where a.proCreator=:proCreator", RendezVous.class).setParameter("proCreator", pro).getResultList();
		System.out.println("num of RendezVous:" + resultList.size());
		for (RendezVous next : resultList) {
			System.out.println("next RendezVous: " + next);
		}
	}
	
	public void creerRendezvous(Pro pro, Date date, Long duree, String intitule)
	{
		if (pro.getUserCompte().isLogged())
		{
			RendezVousDao rendezVous= new RendezVousDao(manager);
			rendezVous.creerRendezVous( pro,date, duree, intitule);
		}
		else {
			System.out.println("Veuillez vous connecter!!!");
		}
	}
	
	public Users seLogIn(String pseudo, String mdp)
	{
		CompteDao compte = new CompteDao(manager);
		
		return compte.logIn( pseudo, mdp);
	}
	
	public void seLogOut(Users user)
	{
		CompteDao compte = new CompteDao(manager);
		compte.logOut(user);
		
	}
}
