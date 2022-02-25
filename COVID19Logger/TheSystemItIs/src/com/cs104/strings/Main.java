package com.cs104.strings;

import java.io.BufferedReader;
// Import IOException
import java.io.IOException;
import java.io.InputStreamReader;
//Import date
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		// TODO Make Simple COVID-19 Store Visitor Log for contact-tracing
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		// Variables
		// Settings
		final String password = "password";
		boolean isAdmin = false;
		char charInput1 = 0;
		char charInput2 = 0;
		int max = 10;
		int charHowMany = 0;
		int threadSleep = 0;
		
		// For Visitor
		int intBirthMonth;
		int intBirthDate;
		int intBirthYear;
		String firstNameInput;
		String middleNameInput;
		String lastNameInput;
		String passwordInput;

		// Objects
		NameGenerator.randomUserID();
		SimpleDateFormat monthDayYearTimeFormat = new SimpleDateFormat("MM/dd/yyyy | HH:mma");
		Date newDate = new Date();

		// Lists
		ArrayList<UserProfile> userList = new ArrayList<UserProfile>();

		while (charInput1 != 'Q') {
			// TODO [Step #1] Allow the user to choose if he/she is a store visitor or an
			// administrator
			System.out.println("Hello and Welcome To my Store!");
			System.out.println("Are you a visitor or an admin?");
			System.out.println("[1] - Admin");
			System.out.println("[2] - Visitor");
			System.out.println("[Q] - Quit");
			System.out.print("Input: ");
			charInput1 = reader.readLine().charAt(charHowMany);

			// TODO [Step #4] If the user is Admin, ask for a password. Display if he/she
			// successfully logged in or failed.
			if (charInput1 == '1') {
				isAdmin = false;
				System.out.println("What's the Password?");
				System.out.print("Input: ");
				passwordInput = reader.readLine();

				while (passwordInput.isBlank() || passwordInput.isEmpty()) {
					passwordInput = reader.readLine();
				}
				
				if (passwordInput.contentEquals(password) == true) {
					System.out.println("(correct password)");
					isAdmin = true;

					// TODO [Step #5] The Admin Should be able to search users on the following
					// category.
					// 1. Date and Time Users Entered
					// 2. Using the First Name
					// 3. Using the Last Name
					// 4. Using the Phone Number

					// TODO [Step #6]Display the Research Results 10 at a Time, DO NOT DISPLAY THEIR
					// NAMES. Instead, display on the following.
					// (1) Their random UserID / Their Phone Number / Their Enter Date Time.

					// TODO [Step #7] Let the Admin finish the search and opt to log out.
					while (isAdmin == true && charInput2 != 'Q') {
						System.out.println("[Admin Panel]");
						System.out.println("List Size: " + userList.size());
						System.out.println("[1] - Search according to (Date & Time)");
						System.out.println("[2] - Search according to (First Name)");
						System.out.println("[3] - Search according to (Last Name)");
						System.out.println("[4] - Searhc according to (Phone#)");
						System.out.println("[Q] - Quit [Admin Panel]");
						System.out.print("Input: ");
						charInput2 = reader.readLine().charAt(charHowMany);
						//Variables
						int iterCount = 1;
						int relatedSearchCount = 0;
						int index = 0;
						//For Option 1
						String tempEnterDateTime;
						int inputMonth = 0;
						int inputDate = 0;
						int inputYear = 0;
						int inputHour = 0;
						int inputMinute = 0;
						//For Option 2
						String firstNameSearch;
						//For Option 3
						String lastNameSearch;
						//For Option 4
						String phoneNumSearch;
						
						
						
						// Option 1 - According to Date and Time
						if (charInput2 == '1') {
							Calendar newCalendar = new GregorianCalendar();
							relatedSearchCount = 0;
							iterCount = 1;
							index = 4;
							
							System.out.println("Search for the Enter Date Time of A user");
							System.out.print("Input Month (1 - 12):");
							inputMonth = Integer.parseInt(reader.readLine());
							
							System.out.print("Input Date (1 - 31, 1 - 28 or 1-29 depending on month):");
							inputDate= Integer.parseInt(reader.readLine());
							
							System.out.print("Input Year (1 - present year):");
							inputYear= Integer.parseInt(reader.readLine());
							
							System.out.print("Input Hour (0 - 23):");
							inputHour = Integer.parseInt(reader.readLine());
							
							System.out.print("Input Minute (1 - 59):");
							inputMinute= Integer.parseInt(reader.readLine());
							
							inputMonth -= 1;
							newCalendar.set(inputYear, inputMonth, inputDate, inputHour, inputMinute);
							tempEnterDateTime = monthDayYearTimeFormat.format(newCalendar.getTime());
							ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

							for (UserProfile i : userList) {
								list.add(new ArrayList<String>(Arrays.asList(i.getFirstName(), i.getLastName(),
										i.getUserID(), i.getPhoneNumber(),
										monthDayYearTimeFormat.format(i.getEnterDateTime().getTime()))));
							}

							// 0 - FirstName / 1 - LastName / 2 - UserID / 3 - Phone# / 4 - EnterDateAndTime
							for (ArrayList<String> i : list) {
								if (i.get(index).contentEquals(tempEnterDateTime)) {
									relatedSearchCount++;
								}
							}
							
							System.out.println("Available: " + relatedSearchCount);
							System.out.println("");
							for (ArrayList<String> i : list) {
								if (iterCount <= max && i.get(index).contentEquals(tempEnterDateTime)) {
									System.out.println("UserID: " + i.get(2));
									System.out.println("Phone#: " + i.get(3));
									System.out.println("EnterDate&Time: " + i.get(4));
									System.out.println("");
									Thread.sleep(threadSleep);
									iterCount++;
								}
							}

							if (userList.size() == 0) {
								System.out.println("(List is empty)");
							}
						}
						
						
						
						else if (charInput2 == '2') {
							firstNameSearch = "";
							relatedSearchCount = 0;
							iterCount = 1;
							index = 0;
							
							System.out.println("Search for the Enter Date Time of A user");
							System.out.print("Input firstName of the User:");
							firstNameSearch = reader.readLine();
							
							ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

							for (UserProfile i : userList) {
								list.add(new ArrayList<String>(Arrays.asList(i.getFirstName(), i.getLastName(),
										i.getUserID(), i.getPhoneNumber(),
										monthDayYearTimeFormat.format(i.getEnterDateTime().getTime()))));
							}

							// 0 - FirstName / 1 - LastName / 2 - UserID / 3 - Phone# / 4 - EnterDateAndTime
							for (ArrayList<String> i : list) {
								if (i.get(index).contentEquals(firstNameSearch)) {
									relatedSearchCount++;
								}
							}
							
							System.out.println("Available: " + relatedSearchCount);
							System.out.println("");
							for (ArrayList<String> i : list) {
								if (iterCount <= max && i.get(index).contentEquals(firstNameSearch)) {
									System.out.println("UserID: " + i.get(2));
									System.out.println("Phone#: " + i.get(3));
									System.out.println("EnterDate&Time: " + i.get(4));
									System.out.println("");
									Thread.sleep(threadSleep);
									iterCount++;
								}
							}

							if (userList.size() == 0) {
								System.out.println("(List is empty)");
							}
						}
						
						
						
						else if (charInput2 == '3') {
							lastNameSearch = "";
							relatedSearchCount = 0;
							iterCount = 1;
							index = 1;
							
							System.out.println("Search for the Enter Date Time of A user");
							System.out.print("Input firstName of the User:");
							lastNameSearch = reader.readLine();
							
							ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

							for (UserProfile i : userList) {
								list.add(new ArrayList<String>(Arrays.asList(i.getFirstName(), i.getLastName(),
										i.getUserID(), i.getPhoneNumber(),
										monthDayYearTimeFormat.format(i.getEnterDateTime().getTime()))));
							}

							// 0 - FirstName / 1 - LastName / 2 - UserID / 3 - Phone# / 4 - EnterDateAndTime
							for (ArrayList<String> i : list) {
								if (i.get(index).contentEquals(lastNameSearch)) {
									relatedSearchCount++;
								}
							}
							
							System.out.println("Available: " + relatedSearchCount);
							System.out.println("");
							for (ArrayList<String> i : list) {
								if (iterCount <= max && i.get(index).contentEquals(lastNameSearch)) {
									System.out.println("UserID: " + i.get(2));
									System.out.println("Phone#: " + i.get(3));
									System.out.println("EnterDate&Time: " + i.get(4));
									System.out.println("");
									Thread.sleep(threadSleep);
									iterCount++;
								}
							}

							if (userList.size() == 0) {
								System.out.println("(List is empty)");
							}
						}
						
						
						
						else if (charInput2 == '4') {
							phoneNumSearch = "";
							relatedSearchCount = 0;
							iterCount = 1;
							index = 3;
							
							System.out.println("Search for the Enter Date Time of A user");
							System.out.print("Input firstName of the User (Input an 11-Digit Phone#):");
							phoneNumSearch = reader.readLine();
							while (phoneNumSearch.length() != 11) {
								phoneNumSearch = reader.readLine();
							}
							
							ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

							for (UserProfile i : userList) {
								list.add(new ArrayList<String>(Arrays.asList(i.getFirstName(), i.getLastName(),
										i.getUserID(), i.getPhoneNumber(),
										monthDayYearTimeFormat.format(i.getEnterDateTime().getTime()))));
							}

							// 0 - FirstName / 1 - LastName / 2 - UserID / 3 - Phone# / 4 - EnterDateAndTime
							for (ArrayList<String> i : list) {
								if (i.get(index).contentEquals(phoneNumSearch)) {
									relatedSearchCount++;
								}
							}
							
							System.out.println("Available: " + relatedSearchCount);
							System.out.println("");
							for (ArrayList<String> i : list) {
								if (iterCount <= max && i.get(index).contentEquals(phoneNumSearch)) {
									System.out.println("UserID: " + i.get(2));
									System.out.println("Phone#: " + i.get(3));
									System.out.println("EnterDate&Time: " + i.get(4));
									System.out.println("");
									Thread.sleep(threadSleep);
									iterCount++;
								}
							}

							if (userList.size() == 0) {
								System.out.println("(List is empty)");
							}
						}
						
						
						
						else if (charInput2 == 'Q') {
							isAdmin = false;
							charInput2 = ' ';
							charInput1 = ' ';
						}
					}
				}
				
				
				
				else if (passwordInput.contentEquals(password) == false) {
					// keeping the password hidden
					passwordInput = null;
					isAdmin = false;
					System.out.println("[Error](Incorrect Password)");
				}
			}

			// TODO [Step #2] If the user is visitor = ask their FullName, BirthDate &
			// PhoneNumber.
			// TODO [Step #3] The System should provide a random UserID for anonymity.
			// It should also automatically register the time when the user successfully
			// completed the form, named EnterDateTime
			else if (charInput1 == '2') {
				UserProfile newUser = new UserProfile();
				System.out.println("[Creating Visitor Information]");
				System.out.println("Please input the following");
				System.out.println("What's your Full Name?");
				System.out.print("Input First Name: ");
				firstNameInput = reader.readLine();
				System.out.print("Input Middle Name: ");
				middleNameInput = reader.readLine();
				System.out.print("Input Last Name: ");
				lastNameInput = reader.readLine();
				while ((firstNameInput.isBlank() == true || firstNameInput.isEmpty() == true)
						|| (middleNameInput.isBlank() == true || middleNameInput.isEmpty() == true)
						|| (lastNameInput.isBlank() == true || lastNameInput.isEmpty() == true)) {
					System.out.println("[Error] Inputs are either empty or blank");
					System.out.print("Input First Name: ");
					firstNameInput = reader.readLine();
					System.out.print("Input Middle Name: ");
					middleNameInput = reader.readLine();
					System.out.print("Input Last Name: ");
					lastNameInput = reader.readLine();
				}
				newUser.setFullName(firstNameInput, middleNameInput, lastNameInput);

				// Ask the visitor their BirthDate
				Boolean leapYear;
				leapYear = false;
				intBirthMonth = 0;
				intBirthDate = 0;
				intBirthYear = 0;
				System.out.println("What's your BirthDate?");
				System.out.print("Input your BirthYear (must be above 0): ");
				intBirthYear = Integer.parseInt(reader.readLine());

				// Check if (Year must be not < 0)
				while (intBirthYear <= 0) {
					System.out.print("[Error](above 0):");
					intBirthYear = Integer.parseInt(reader.readLine());
				}

				// Check if the year is a Leap Year or not
				if ((intBirthYear % 4) == 0) {
					leapYear = true;
				} else if ((intBirthYear % 4) > 0) {
					leapYear = false;
				}
				System.out.println("LeapYear = " + leapYear);
				System.out.print("Input you BirthMonth (must be between 1-12):");
				intBirthMonth = Integer.parseInt(reader.readLine());
				while (intBirthMonth > 12 || intBirthMonth <= 0) {
					System.out.print("[Error](must be between 1-12):");
					intBirthMonth = Integer.parseInt(reader.readLine());
				}

				// Check which BirthMonth they Input
				if (intBirthMonth == 1 || intBirthMonth == 3 || intBirthMonth == 5 || intBirthMonth == 7
						|| intBirthMonth == 8 || intBirthMonth == 10 || intBirthMonth == 12) {
					System.out.print("Input your BirthDate (must be between 1-31):");
					intBirthDate = Integer.parseInt(reader.readLine());
					while ((intBirthDate <= 0 || intBirthDate > 31)) {
						System.out.print("[Error](must be between 1-31):");
						intBirthDate = Integer.parseInt(reader.readLine());
					}
				} else if (intBirthMonth == 4 || intBirthMonth == 6 || intBirthMonth == 9 || intBirthMonth == 11) {
					System.out.print("Input your BirthDate (must be between 1-30):");
					intBirthDate = Integer.parseInt(reader.readLine());
					while ((intBirthDate <= 0 || intBirthDate > 30)) {
						System.out.print("[Error](must be between 1-30):");
						intBirthDate = Integer.parseInt(reader.readLine());
					}
				}

				// Check if February is Leap Year or Not Leap Year
				else if (intBirthMonth == 2) {
					// If your BrirthYear is not a leap Year
					if (leapYear == false) {
						System.out.print("Input your BirthDate (must be between 1-28):");
						intBirthDate = Integer.parseInt(reader.readLine());
						while ((intBirthDate <= 0 || intBirthDate > 28)) {
							System.out.print("[Error](must be between 1-28):");
							intBirthDate = Integer.parseInt(reader.readLine());
						}
					}
					// If your BirthYear is a leap Year
					if (leapYear == true) {
						System.out.print("Input your BirthDate (must be between 1-29):");
						intBirthDate = Integer.parseInt(reader.readLine());
						while ((intBirthDate <= 0 || intBirthDate > 29)) {
							System.out.print("[Error](must be between 1-29):");
							intBirthDate = Integer.parseInt(reader.readLine());
						}
					}
				}
				intBirthMonth -= 1;
				newUser.setFullBirthDate(intBirthYear, intBirthMonth, intBirthDate);

				// Ask the User what's their Phone Number
				System.out.println("What's your Phone Number (must be an 11-digit format, only digits)");
				System.out.print("Phone #:");
				firstNameInput = reader.readLine();
				while (firstNameInput.length() < 11 || newUser.setPhoneNumber(firstNameInput) == false) {
					System.out.print("[Error](must be an 11-digit format, only digits):");
					firstNameInput = reader.readLine();
				}

				newUser.displayInfo();
				userList.add(newUser);
				System.out.println("");
			}
		}

		if (charInput1 == 'Q') {
			System.out.println("Thanks for stopping by!");
			System.out.println(monthDayYearTimeFormat.format(newDate));
		}

		// End of Code
	}
}

/*
 * UPDATES on this project: 
 * + Improved the search category, so now if there are duplicate names, it will still show both the userID, Phone# and EnterDateTime of the user. 
 * + Password is now on the Main Class
 * + Admin can search by typing in Integers or Strings
 * + Removed the Deprecated setDate Methods and replaced it with Calendar.
 */
