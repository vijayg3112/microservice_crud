package com.user.demo.Microservicecrud.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRequestDTO {

	@NotEmpty(message = "first name must not be empty")
	private String firstName;
	@NotEmpty(message = "last name must not be empty")
	private String lastName;
	@NotEmpty(message = "emailId must not be empty")
	private String emailId;
	@NotEmpty
	@Size(min = 6, max = 10, message = "Phone number size does not match")
	private String phoneNumber;
	@NotEmpty(message = "address must not be empty")
	private String address;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
