package com.learn.RESTApi.Models;

public class Student {
	private String firstName;
	private String lastName;
	private int marks;
	private String email;
	
	public Student(String firstName, String lastName, int marks, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", marks=" + marks + "]";
	}
	
}
