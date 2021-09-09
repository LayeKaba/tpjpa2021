package dao;

import javax.persistence.EntityManager;

import entities.Patient;
import entities.RendezVous;

public class CreneauDao {

	private EntityManager manager;

	public CreneauDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void createCreneau(RendezVous rendezvous, Patient patient)
	{
		
	}
	

}
