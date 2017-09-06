package pl.coderslab.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String title;
	@ManyToOne
//	@NotNull
	private Users recipient;
	@ManyToOne
//	@NotNull
	private Users sender;
	@Size(min=10, max=2000)
	private String body;
//	@NotBlank
	private LocalDateTime send;
	
	public LocalDateTime getSend() {
		return send;
	}
	public void setSend(LocalDateTime send) {
		this.send = send;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String titile) {
		this.title = titile;
	}
	public Users getRecipient() {
		return recipient;
	}
	public void setRecipient(Users recipient) {
		this.recipient = recipient;
	}
	public Users getSender() {
		return sender;
	}
	public void setSender(Users sender) {
		this.sender = sender;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}