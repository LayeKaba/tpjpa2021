package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Users {

	private Long id;
	
	private String name;
	private String adress;
	
	
	private Compte userCompte;

	public Users( String name, String adress) {
		super();
		this.name = name;
		this.adress = adress;
	}
	
	
	@OneToOne
	public Compte getUserCompte() {
		return userCompte;
	}



	public void setUserCompte(Compte userCompte) {
		this.userCompte = userCompte;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public  String getAdress() {
		return adress;
	}

	public Users() {
		super();
	}
	
}
