package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Compte;
import entities.Creneaux;
import entities.Patient;
import entities.RendezVous;

public class CreneauDao {

	private EntityManager manager;

	public CreneauDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void createCreneau(RendezVous rendezvous, Long duree)
	{
		if (rendezvous.getDuree() - duree < 0)
		{
			System.out.println("Hop pour ce rendez-vous il n'a pas assez de temps pour creer ce creneau");
		}
		else
		{
			Creneaux newCreneau = new Creneaux(rendezvous, duree);
			manager.persist(newCreneau);
			rendezvous.getAllCreneaux().add(newCreneau);
			rendezvous.setDuree(rendezvous.getDuree()-duree);
			manager.persist(rendezvous);
			
		}
	}
	
	public void reserverCreneau(Patient patient, Creneaux creneau)
	{
		if (patient.getUserCompte().isLogged())
		{
			if (creneau.isDisponible())
			{
				patient.getAllCreneaux().add(creneau);
				creneau.setUserTaked(patient);
				
				manager.persist(creneau);
				manager.persist(patient);
				System.out.println("Votre creneau à bien ete enregistre!!!");
			}
			else {
				
			}
				
		}
		else
			System.out.println("Veuillez vous connecter!!!");
	}
	
	
	
	public void listCreneau()
	{
		List<Creneaux> resultList = manager.createQuery("Select a From Creneaux a", Creneaux.class).getResultList();
		System.out.println("num of compte:" + resultList.size());
		for (Creneaux next : resultList) {
			System.out.println("next creneau: " + next);
		}
	}
	

}
