package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person implements java.io.Serializable {

	private Date DOB;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String address;
	private String phone_number;
	private String email_address;

	
	
	
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) throws PersonException
	{
		Calendar today = Calendar.getInstance();
		Calendar BD = Calendar.getInstance();
		BD.setTime(DOB);
		double yearOfBD = BD.get(Calendar.YEAR);
		double yearOftoday = today.get(Calendar.YEAR);
		if(yearOftoday - yearOfBD >= 100) 
		{
			throw new PersonException(this);
		}else 
		{
			this.DOB = DOB;
		}
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setPhone(String newPhone_number) throws PersonException 
	{
		String Regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		boolean bol = Pattern.matches(Regex, newPhone_number);
		if(!bol) 
		{
			throw new PersonException(this);
		}else 
		{
			this.phone_number = newPhone_number;
		}
	
	}

	public String getPhone() {
		return phone_number;
	}

	public void setEmail(String newEmail) {
		email_address = newEmail;
	}

	public String getEmail() {
		return email_address;
	}
	
	public Person() {

	}

	public Person(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email) throws PersonException
	{
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.setDOB(DOB);
		this.address = Address;
		this.setPhone(Phone_number);
		this.email_address = Email;
		
	}

	public void PrintName() {
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' '
				+ this.LastName);
	}

	public void PrintDOB() {
		System.out.println(this.DOB);
	}

	public int PrintAge() {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;
		birthDate.setTime(this.DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}

		System.out.println("age is " + age);

		return age;

	}
}