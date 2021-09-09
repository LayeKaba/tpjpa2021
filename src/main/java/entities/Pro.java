package entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pro  extends Users{
	private String speciality;
	private List<RendezVous> allRdv;

	
	public Pro(String name, Department department, String speciality) {
		super(name, department);
		this.speciality = speciality;
	}


	public Pro() {
		// TODO Auto-generated constructor stub
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@OneToMany(mappedBy ="proCreator")
	public List<RendezVous> getAllRdv() {
		return allRdv;
	}


	public void setAllRdv(List<RendezVous> allRdv) {
		this.allRdv = allRdv;
	}


	@Override
	public String toString() {
		return super.toString()+"  speciality=" + speciality + "";
	}

	
	
	

}
