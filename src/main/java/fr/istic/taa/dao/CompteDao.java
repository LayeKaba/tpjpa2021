package fr.istic.taa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.entities.Compte;
import fr.istic.taa.entities.Patient;
import fr.istic.taa.entities.Pro;
import fr.istic.taa.entities.Users;


public class CompteDao {
	private EntityManager manager;

	public CompteDao(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory =   
 			 Persistence.createEntityManagerFactory("prod");
		EntityManager manager = factory.createEntityManager();
		CompteDao test = new CompteDao(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Pro pro = new Pro("Laye","Rennes", "derma");
			Pro pro1 = new Pro("Laye1","Rennes", "neuro");
			Pro pro2 = new Pro("Laye3","Rennes", "Kine");
			Patient patient = new Patient("Kas","Rennes");
			Patient patient2 = new Patient("Kas1","Rennes");
			test.createCompte(pro, "laye", "salut");
			test.createCompte(pro1, "laye1", "mdp");
			test.createCompte(pro2, "laye2", "salut");
			test.createCompte(patient, "Kas", "salut");
			test.createCompte(patient2, "Kas2", "salut");
			Users users = test.logIn("laye", "salut");
			test.logOut(users);
			test.logIn( "Kas", "salut");
			//users.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listCompte();
			
   	 manager.close();
		System.out.println("... done");
	}

	public Users logIn(String pseudo, String mdp )
	{
		List<Compte> result = manager.createQuery("Select a From Compte a where a.pseudo= :pseudo AND a.mpd=:mdp", Compte.class).setParameter("pseudo", pseudo).setParameter("mdp", mdp).getResultList();
		
		if (result != null && result.size()==1)
		{
			Compte compte = result.get(0);
			
			compte.setLogged(true);
			manager.persist(compte);
			System.out.println("Vous etes connecté avec succes");
			return result.get(0).getUserCount();
		}
		else System.out.println("Votre speudo ou mot de passe est incorrect");
		
		return new Users();
	}
	
	public void logOut(Users users)
	{
		Compte result = manager.createQuery("Select a From Compte a where a.pseudo=:pseudo ", Compte.class).setParameter("pseudo", users.getUserCompte().getPseudo()).getSingleResult();
		if (result!= null)
		{
			users.getUserCompte().setLogged(false);
			manager.persist(users);
			manager.persist(result);
			System.out.println("Vous etes deconnecté avec succes");
		}
	}
	
	public  void createCompte(Users users, String pseudo, String mdp)
	{
			if (existCompte(pseudo)) 
			{
				System.out.println("Ce compte existe deja!!!");
			}
			else
			{
				//if (users.isExists())
				{
					Compte newCompte = new Compte(pseudo,mdp);
					newCompte.setUserCount(users);
					users.setUserCompte(newCompte);
					manager.persist(users);
					manager.persist(newCompte);
				}
			}
		
	}

	public void listCompte() {
		List<Compte> resultList = manager.createQuery("Select a From Compte a", Compte.class).getResultList();
		System.out.println("num of compte:" + resultList.size());
		for (Compte next : resultList) {
			System.out.println("next compte: " + next);
		}
	}
	private boolean existCompte(String pseudo)
	{
		Long result = manager.createQuery("select count(a) From Compte a where a.pseudo=:pseudo", Long.class).setParameter("pseudo", pseudo).getSingleResult();
		
		if (result>0)
			return true;
		else
			return false;
	}
	private Compte getCompte(String pseudo)
	{
		Compte result = manager.createQuery("Select a From Compte a where a.pseudo=:pseudo", Compte.class).setParameter(":pseudo", pseudo).getSingleResult();
		
		return result;
	}
	

}
