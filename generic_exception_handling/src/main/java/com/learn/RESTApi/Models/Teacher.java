package com.learn.RESTApi.Models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Teacher {

	private String module;

	private String firstName;

	private String lastName;

	private String email;
	
	public Teacher() {
		super();
	}
	public Teacher(String module, String firstName, String lastName, String email) {
		super();
		this.module = module;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
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

	@Override
	public String toString() {
		return "Teacher [module=" + module + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	
}
