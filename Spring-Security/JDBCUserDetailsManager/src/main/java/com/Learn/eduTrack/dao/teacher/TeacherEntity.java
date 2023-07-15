package com.Learn.eduTrack.dao.teacher;


public class TeacherEntity {
	
	private int id; 
	private String name; 
	private String email; 
	private String qualification; 
	private String department; 
	private String password;
	
	
	@Override
	public String toString() {
		return "TeacherEntity [id=" + id + ", name=" + name + ", email=" + email + ", qualification=" + qualification
				+ ", department=" + department + ", password=" + password + ", address=" + address + ", phone=" + phone
				+ ", age=" + age + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	private String address; 
	private String phone; 
	private int age;
}
