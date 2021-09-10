package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entities.Compte;
import entities.Pro;
import entities.RendezVous;

public class RendezVousDao {

	private EntityManager manager;

	public RendezVousDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void creerRendezVous(Pro pro, Date date, Long duree, String intitule)
	{
		if (pro.getUserCompte().isLogged())
		{
		RendezVous rendezVous = new RendezVous(date, duree, intitule, pro);
		pro.getAllRdv().add(rendezVous);
		manager.persist(intitule);
		manager.persist(pro);
		}
		else {
			System.out.println("Veuillez vous connecter!!!");
		}
	}
	
	public  void RendezVous() {
		List<RendezVous> resultList = manager.createQuery("Select a From RendezVous a", RendezVous.class).getResultList();
		System.out.println("num of compte:" + resultList.size());
		for (RendezVous next : resultList) {
			System.out.println("next RendezVous: " + next);
		}
	}
	
}
