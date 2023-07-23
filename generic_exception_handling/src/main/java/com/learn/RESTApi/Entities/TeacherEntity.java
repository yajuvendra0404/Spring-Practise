package com.learn.RESTApi.Entities;

import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity /* @Entites cannot be used as bean, they cannot be @Autowired. 
		   they are not managed by IOC container. 
		   they are to be managed by DAO and then DAO can be @Autowired */
@Table(name="teacher")
public class TeacherEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="module")
	private String module;
	
	
	
	@Override
	public String toString() {
		return "TeacherEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", module=" + module + "]";
	}

	public TeacherEntity() {
		super();
	}
	
	public TeacherEntity(String firstName, String lastName, String email, String module) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.module = module;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
	
	
}

