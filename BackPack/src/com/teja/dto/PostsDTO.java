package com.teja.dto;

import java.io.Serializable;

public class PostsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int sno;
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
}
