package com.Learn.eduTrack.model;

public class TeacherModel {
	
	
 
	private String name; 
	private String email; 
	private String qualification; 
	private String department; 
	private String address; 
	private String phone; 
	private int age;
	
	
	
	@Override
	public String toString() {
		return "TeacherModel [ name=" + name + ", email=" + email 
				+ ", qualification=" + qualification + ", department=" + department + ", address=" + address
				+ ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	

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

	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
