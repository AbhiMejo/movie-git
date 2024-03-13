package com.example.user.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Login_Credentials")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long loginID;
	private String firstName;
	private String lastName;
	private String emailId;
	private long mobileNumber;
	private String password;
	public Long getLoginID() {
		return loginID;
	}
	public void setLoginID(Long loginID) {
		this.loginID = loginID;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "login [loginID=" + loginID + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	
}
