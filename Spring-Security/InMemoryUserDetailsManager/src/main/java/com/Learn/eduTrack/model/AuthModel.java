package com.Learn.eduTrack.model;

public class AuthModel {
	
	private String email;
	private String Password;
	
	public AuthModel(String email, String password) {
		super();
		this.email = email;
		Password = password;
	}
	@Override
	public String toString() {
		return "AuthModel [email=" + email + ", Password=" + Password + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
