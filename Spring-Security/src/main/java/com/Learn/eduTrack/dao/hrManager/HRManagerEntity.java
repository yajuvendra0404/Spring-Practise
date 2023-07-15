package com.Learn.eduTrack.dao.hrManager;

public class HRManagerEntity {

	private String name; 
	private String email; 
	private String company; 
	private String password; 
	private String address; 
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phone_number) {
		this.phoneNumber = phone_number;
	}
	@Override
	public String toString() {
		return "HRManagerEntity [name=" + name + ", email=" + email + ", company=" + company + ", password=" + password
				+ ", address=" + address + ", phone_number=" + phoneNumber + "]";
	}
	
	
	
}
