package fr.istic.taa.dao;

import javax.persistence.EntityManager;

import fr.istic.taa.entities.Creneaux;
import fr.istic.taa.entities.Patient;
import fr.istic.taa.entities.Users;



public class PatientDao {

	private EntityManager manager;

	public PatientDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void creerPatient(String name, String adress, String pseudo, String mdp)
	{
		Patient patient = new Patient(name, adress);
		CompteDao compte = new CompteDao(manager);
		compte.createCompte(patient, pseudo, mdp);
	}
	
	public void reserverCreneau(Patient patient, Creneaux creneau)
	{
		CreneauDao creneaux = new CreneauDao(manager);
		creneaux.reserverCreneau(patient, creneau);
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
	
	public void modifierCreneau(Patient patient, Creneaux newCreneau)
	{
		
	}
	
}
