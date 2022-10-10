package com.microservice.guest.entity;


import lombok.*;


import org.hibernate.validator.constraints.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Guest")
public class Guest {

	@Transient
	public static final String SEQUENCE_NAME="guest_sequence";

	@Id
	private int guestId;



	@NotNull(message="Guest Name cannot be null")
	@Size(min=3,message="Guest Name should be minimum 3 Characters")
	private String guestName;
	@NotNull(message="Guest Contact cannot be null")
	@Size(min=10,max = 10,message="Guest Contact should be 10 digit number ")
	private String guestContact;
	@NotNull(message="Guest MailID cannot be null")
	@Email
	private String guestEmail;

	@NotNull(message="Guest Gender cannot be null")
	@Size(max=10,message="Guest Gender should be valid")
	private String guestGender;

	@NotNull(message="Guest Address cannot be null")
	@Size(min=4,message="Guest Address should be minimum 5 digits")
	private String guestAddress;

	public Guest(int guestId, String guestName, String guestContact, String guestEmail, String guestGender, String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestContact = guestContact;
		this.guestEmail = guestEmail;
		this.guestGender = guestGender;
		this.guestAddress = guestAddress;
	}



	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestContact() {
		return guestContact;
	}
	public void setGuestContact(String guestContact) {
		this.guestContact = guestContact;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}


	public Guest() {

	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestName=" + guestName + ", guestContact=" + guestContact
				+ ", guestEmail=" + guestEmail + ", guestGender=" + guestGender + ", guestAddress=" + guestAddress
				+ "]";
	}

}