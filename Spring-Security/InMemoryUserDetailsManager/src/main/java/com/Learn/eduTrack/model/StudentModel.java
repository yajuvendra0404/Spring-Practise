package com.Learn.eduTrack.model;


public class StudentModel {
	
	private String name;
	private String marks;
	private String address;
	private String DOB;
	private String hobbies;
	
	public StudentModel(String name, String marks, String address, String dOB, String hobbies) {
		super();
		this.name = name;
		this.marks = marks;
		this.address = address;
		DOB = dOB;
		this.hobbies = hobbies;
	}
	
	@Override
	public String toString() {
		return "StudentModel [name=" + name + ", marks=" + marks + ", address=" + address + ", DOB=" + DOB
				+ ", hobbies=" + hobbies + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	
}
