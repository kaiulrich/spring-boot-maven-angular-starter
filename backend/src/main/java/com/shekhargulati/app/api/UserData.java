package com.shekhargulati.app.api;

public class UserData {
	
	private String errormessage;
	
	private String personalNumber;
	private String firstname;
	private String secondname;
	
	public UserData(String personalNumber, String firstname, String secondname) {
		super();
		this.errormessage = null;
		this.personalNumber = personalNumber;
		this.firstname = firstname;
		this.secondname = secondname;
	}
	
	public UserData(String errormessage, String personalNumber) {
		super();
		this.errormessage = errormessage;
		this.personalNumber = personalNumber;
		this.firstname = null;
		this.secondname = null;
	}
	public String getPersonalNumber() {
		return personalNumber;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getSecondname() {
		return secondname;
	}

	public String getErrormessage() {
		return errormessage;
	}
	
	
	
	

}
