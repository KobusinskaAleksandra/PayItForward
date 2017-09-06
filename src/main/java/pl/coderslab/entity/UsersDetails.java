package pl.coderslab.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UsersDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@ManyToOne
	private Cities city;
	@OneToOne
	private Users user;
	@OneToMany
	private List <Requests> request;
	@OneToMany
	private List <Responses> response;
	
	public Cities getCity() {
		return city;
	}
	public void setCity(Cities city) {
		this.city = city;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List <Responses> getResponse() {
		return response;
	}
	public void setResponse(List <Responses> response) {
		this.response = response;
	}
	public List <Requests> getRequest() {
		return request;
	}
	public void setRequest(List <Requests> request) {
		this.request = request;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public String toString () {
	return firstName + " " + lastName;	
	}
	
}
