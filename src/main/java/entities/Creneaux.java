package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Creneaux {

	
	private Long id;
	
	private Long duree;
	private RendezVous rdvPere;
	private Patient userTaked;

	public Creneaux(RendezVous rendezvous, Long duree) {
		this.rdvPere= rendezvous;
		this.duree= duree;
	}

	@ManyToOne
	public Patient getUserTaked() {
		return userTaked;
	}

	public void setUserTaked(Patient userTaked) {
		this.userTaked = userTaked;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	public RendezVous getRdvPere() {
		return rdvPere;
	}

	public void setRdvPere(RendezVous rdvPere) {
		this.rdvPere = rdvPere;
	}
	
	public boolean isDisponible()
	{
		return this.getUserTaked()== null;
	}
}
