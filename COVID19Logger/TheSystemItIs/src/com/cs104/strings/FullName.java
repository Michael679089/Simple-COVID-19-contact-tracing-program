package com.cs104.strings;

public class FullName {
	
	private String firstName;
	private String middleName;
	private String lastName;
	// Custom Variables
	private String middleInitial;


	
	// Default Constructors
	public FullName() {
		this.firstName = "Dummy First Name";
		this.middleName = "DummyMiddleName";
		this.lastName = "Dummy LastName";
	}
	public FullName(String newFirstName, String newMiddleName, String newLastName) {
		this.firstName = newFirstName;
		this.middleName = newMiddleName;
		this.lastName = newLastName;
	}
	
	
	
	// getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	
	// setters
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	public void setMiddleName(String newMiddleName) {
		this.middleName = newMiddleName;
	}
	
	
	
	//TODO create a method that will return the Middle Initial [DONE!]
	public String getMiddleInitial() {
		return this.middleInitial;
	}
	public void setMiddleInitial(String newMiddleName) {
		String tempString = newMiddleName.toUpperCase().charAt(0) + ".";
		this.middleInitial = tempString;
	}
	
}