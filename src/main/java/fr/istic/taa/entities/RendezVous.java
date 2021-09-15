package fr.istic.taa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RendezVous {

	private Long id;
	private Date date;
	private Long duree;
	private String intitule;
	private Pro proCreator;
	private List<Creneaux> allCreneaux;
	
	
	
	public RendezVous() {
		super();
	}
	public RendezVous(Date date, Long duree, String intitule, Pro proCreator) {
		super();
		this.date = date;
		this.duree = duree;
		this.intitule = intitule;
		this.proCreator = proCreator;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDuree() {
		return duree;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
	}
	public String getIntitule() {
		return intitule;
	}
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	@OneToMany(mappedBy = "rdvPere", cascade = CascadeType.PERSIST)
	public List<Creneaux> getAllCreneaux() {
		return allCreneaux;
	}
	public void setAllCreneaux(List<Creneaux> allCreneaux) {
		this.allCreneaux = allCreneaux;
	}
	@ManyToOne
	public Pro getProCreator() {
		return proCreator;
	}
	public void setProCreator(Pro proCreator) {
		this.proCreator = proCreator;
	}
	
	
	
}
