package com.consist.lbv.app.api;

public class UserData {
	
	private String personalNumber;
	private String username;
	private String email;
	private String telefon;
	private String street;
	private String zipcode;
	private String town;
	
	
	public UserData(String personalNumber, String username, String email, String telefon, String street, String zipcode,
			String town) {
		super();
		this.personalNumber = personalNumber;
		this.username = username;
		this.email = email;
		this.telefon = telefon;
		this.street = street;
		this.zipcode = zipcode;
		this.town = town;
	}
	public String getPersonalNumber() {
		return personalNumber;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getStreet() {
		return street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getTown() {
		return town;
	}
	@Override
	public String toString() {
		return "UserData [personalNumber=" + personalNumber + ", username=" + username + ", email=" + email
				+ ", telefon=" + telefon + ", street=" + street + ", zipcode=" + zipcode + ", town=" + town + "]";
	}
	
	

}
