package fr.istic.taa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class Patient extends Users{

	

	private List<Creneaux> allCreneaux;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String adress) {
		super(name, adress);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy ="userTaked",  cascade = CascadeType.PERSIST)
	public List<Creneaux> getAllCreneaux() {
		return allCreneaux;
	}

	public void setAllCreneaux(List<Creneaux> allCreneaux) {
		this.allCreneaux = allCreneaux;
	}
}
