package com.entity;

public class Student {
	private int id;
	private String name;
	private String email;
	private String qualification;
	private String address;
	private String dob;

	// Constructor
	public Student(int id, String name, String email, String qualification, String address, String dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.qualification = qualification;
		this.address = address;
		this.dob = dob;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
