package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Responses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@NotBlank
	private Requests request;
	@ManyToOne
	@NotBlank
	private UsersDetails user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Requests getRequest() {
		return request;
	}
	public void setRequest(Requests request) {
		this.request = request;
	}
	public UsersDetails getUser() {
		return user;
	}
	public void setUser(UsersDetails user) {
		this.user = user;
	}
}
