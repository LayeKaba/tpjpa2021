package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compte {

	private Long id;
	private String pseudo;
	private String mpd;
	
	private Users userCount;
	private boolean isLogged=false;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public Compte() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMpd() {
		return mpd;
	}
	public Compte(String pseudo, String mpd) {
		super();
		this.pseudo = pseudo;
		this.mpd = mpd;
	}
	public void setMpd(String mpd) {
		this.mpd = mpd;
	}
	@OneToOne
	public Users getUserCount() {
		return userCount;
	}
	public void setUserCount(Users userCount) {
		this.userCount = userCount;
	}
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	
	
}
