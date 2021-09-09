package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Compte;
import entities.Department;
import entities.Pro;
import entities.Users;
import jpa.JpaTest;

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
			test.createCompte(pro, "laye", "salut");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		//test.listEmployees();
			
   	 manager.close();
		System.out.println("... done");
	}

	private Users logIn(String pseudo, String mdp )
	{
		Compte result = manager.createQuery("Select a From Compte a where a.pseudo=:pseudo AND a.mdp=:mdp", Compte.class).setParameter(":pseudo", pseudo).setParameter(":mdp", mdp).getSingleResult();
		
		if (result != null)
		{
			result.setLogged(true);
			manager.persist(result);
			System.out.println("Vous etes deconnecté avec succes");
		}
		
		return result.getUserCount();
	}
	
	private void logOut(Users users)
	{
		Compte result = manager.createQuery("Select a From Compte a where a.pseudo=:pseudo", Compte.class).setParameter("pseudo", users.getUserCompte().getPseudo()).setParameter(":mdp", users.getUserCompte().getMpd()).getSingleResult();
		if (result!= null)
		{
			users.getUserCompte().setLogged(false);
			manager.persist(users);
			System.out.println("Vous etes deconnecté avec succes");
		}
	}
	
	private void createCompte(Users users, String pseudo, String mdp) {
		int numOfCompte = manager.createQuery("Select a From Compte a", Compte.class).getResultList().size();
		if (numOfCompte == 0) {
			if (existCompte(pseudo))
			{
				System.out.println("Ce compte existe deja!!!");
			}
			else
			{
				manager.persist(users);
				Compte newCompte = new Compte(pseudo,mdp);
				newCompte.setUserCount(users);
				manager.persist(newCompte);
			}
		}
	}

	private void listCompte() {
		List<Compte> resultList = manager.createQuery("Select a From Compte a", Compte.class).getResultList();
		System.out.println("num of compte:" + resultList.size());
		for (Compte next : resultList) {
			System.out.println("next compte: " + next);
		}
	}
	private boolean existCompte(String pseudo)
	{
		Compte result = manager.createQuery("Select a From Compte a where a.pseudo=:pseudo", Compte.class).setParameter("pseudo", pseudo).getSingleResult();
		
		if (result!= null)
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
