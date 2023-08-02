package com.entity;

import java.time.LocalDate;

public class Student {
	private int id;
	private String name;
	private String email;
	private String qualification;
	private String address;
	private LocalDate dob;

	// Constructor
	public Student(String name, String email, String qualification, String address, LocalDate dob) {

		this.name = name;
		this.email = email;
		this.qualification = qualification;
		this.address = address;
		this.dob = dob;
	}

	public Student() {

	}

	public Student(int id, String name, String email, String qualification, String address, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.qualification = qualification;
		this.address = address;
		this.dob = dob;
		this.id = id;
	}

	// Getters and Setters
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", qualification=" + qualification + ", address="
				+ address + ", dob=" + dob + "]";
	}
}
