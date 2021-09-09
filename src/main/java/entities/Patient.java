package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient extends Users{

	

	private List<Creneaux> allCreneaux;
	
	@OneToMany(mappedBy ="userTaked",  cascade = CascadeType.PERSIST)
	public List<Creneaux> getAllCreneaux() {
		return allCreneaux;
	}

	public void setAllCreneaux(List<Creneaux> allCreneaux) {
		this.allCreneaux = allCreneaux;
	}
}
