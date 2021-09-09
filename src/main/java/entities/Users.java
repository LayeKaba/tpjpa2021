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
	private Department department;
	
	
	private Compte userCompte;

	public Users( String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}
	
	
	@OneToOne
	public Compte getUserCompte() {
		return userCompte;
	}



	public void setUserCompte(Compte userCompte) {
		this.userCompte = userCompte;
	}



	public void setDepartment(Department department) {
		this.department = department;
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
	@ManyToOne
	public  Department getDepartment() {
		return department;
	}
	public void setAdresse(Department department) {
		this.department = department;
	}
	public Users() {
		super();
	}
	
}
