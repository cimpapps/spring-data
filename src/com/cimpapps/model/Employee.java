package com.cimpapps.model;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int id;
	private String firstName;
	private String lastName;
	private String department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getLastName() + " " + getFirstName();
	}

}
