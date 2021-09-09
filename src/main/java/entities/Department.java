package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Department {

	private Long id;

	private String name;

	private List<Users> users = new ArrayList<Users>();

	public Department() {
		super();
	}

	public Department(String name) {
		this.name = name;
	}

	//@Id
	//@GeneratedValue
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

	public List<Users> getPro() {
		return users;
	}

	public void setPro(List<Users> users) {
		this.users = users;
	}
}

