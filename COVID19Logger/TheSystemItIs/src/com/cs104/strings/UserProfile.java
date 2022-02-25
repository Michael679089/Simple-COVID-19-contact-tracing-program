package com.cs104.strings;

// Import SimpleDateFormat
import java.text.SimpleDateFormat;
// Import Date
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserProfile {
	private final String userID;
	private FullName userFullName;
	private Calendar userBirthDate;
	private Calendar userEnterDateTime;
	private String userPhoneNumber;

	// SimpleDateFormat
	private final SimpleDateFormat monthDayYearFormat = new SimpleDateFormat("MM/dd/yyyy");
	private final SimpleDateFormat monthDayYearTimeFormat = new SimpleDateFormat("MM/dd/yyyy | HH:mma");

	// default constructor
	public UserProfile() {
		// TODO use the static method NameGenerator.randomUserID [DONE!]
		// to initialize a random userID on the newly created user
		this.userFullName = new FullName();
		this.userBirthDate = new GregorianCalendar();
		this.userEnterDateTime = new GregorianCalendar();
		this.userID = NameGenerator.randomUserID();
	}

	// Methods
	public void displayInfo() {
		System.out.println("UserID: " + this.userID);
		System.out.println("FullName: " + this.userFullName.getFirstName() + " " + this.userFullName.getMiddleInitial()
				+ " " + this.userFullName.getLastName());
		System.out.println("BirthDate: " + monthDayYearFormat.format(userBirthDate.getTime()));
		System.out.println("enterDateTime: " + monthDayYearTimeFormat.format(userEnterDateTime.getTime()));
		System.out.println("PhoneNumber: " + this.userPhoneNumber);
	}

	// TODO create accessors and mutators for the following conditions
	// 1. userID can not be modified by any class, but can be accessed [DONE!]
	// 2. userFullName can be modified and accessed by any class, however
	// you need to create:
	// a. four (4) getters for the full name, only first name, only middle name, and
	// only last name.
	// b. two (2) setters for the full name using the FullName Class and using the
	// strings
	// first name, middle name, and last name
	// 3. userBirthDate can be modified and accessed by any class
	// 4. userCreateDate can be only accessed

	// Setters
	public Boolean setPhoneNumber(String newPhoneNumber) {
		Boolean onlyDigits = false;

		// Check if each digit is a number.
		if (newPhoneNumber.length() == 11 && (newPhoneNumber.isEmpty() == false && newPhoneNumber.isBlank() == false)) {
			for (int i = 0; i <= newPhoneNumber.length() - 1; i++) {
				boolean isNumber = Character.isDigit(newPhoneNumber.charAt(i));
				if (isNumber == true) {
					onlyDigits = true;
				} 
				else if (isNumber == false) {
					onlyDigits = false;
					break;
				}
			}
		}

		// Set the userPhoneNumber to newPhoneNumber
		if (onlyDigits == true) {
			this.userPhoneNumber = newPhoneNumber;
		}
		return onlyDigits;
	}

	// Set BirthDate
	public void setFullBirthDate(int newBirthYear, int newBirthMonth, int newBirthDate) {
		this.userBirthDate.set(newBirthYear, newBirthMonth, newBirthDate);
	}

	public void setBirthYear(int newBirthYear) {
		this.userBirthDate.set(Calendar.YEAR, newBirthYear);
	}

	public void setBirthMonth(int newBirthMonth) {
		this.userBirthDate.set(Calendar.MONTH, newBirthMonth);
	}

	public void setBirthDate(int newBirthDate) {
		this.userBirthDate.set(Calendar.DATE, newBirthDate);
	}

	// set FullName
	public void setFullName(String newFirstName, String newMiddleName, String newLastName) {
		this.userFullName.setFirstName(newFirstName);
		this.userFullName.setMiddleName(newMiddleName);
		this.userFullName.setMiddleInitial(newMiddleName);
		this.userFullName.setLastName(newLastName);
	}

	public void setFirstName(String newFirstName) {
		this.userFullName.setFirstName(newFirstName);
	}

	public void setMiddleName(String newMiddleName) {
		this.userFullName.setMiddleName(newMiddleName);
		this.userFullName.setMiddleInitial(newMiddleName);
	}

	public void setLastName(String newLastName) {
		this.userFullName.setLastName(newLastName);
	}
	
	
	
	// Getters
	public String getUserID() {
		return this.userID;
	}

	public String getPhoneNumber() {
		return this.userPhoneNumber;
	}

	// Get Calendar & Date
	public Calendar getEnterDateTime() {
		return this.userEnterDateTime;
	}

	public Calendar getFullBirthDate() {
		return this.userBirthDate;
	}

	// Get FullName
	public String getFullName() {
		String tempFullName = this.userFullName.getFirstName() + " " + this.userFullName.getMiddleName() + " "
				+ this.userFullName.getLastName();
		return tempFullName;
	}

	public String getFirstName() {
		return this.userFullName.getFirstName();
	}

	public String getMiddleName() {
		return this.userFullName.getMiddleName();
	}

	public String getLastName() {
		return this.userFullName.getLastName();
	}

}
