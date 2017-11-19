package com.teja.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
