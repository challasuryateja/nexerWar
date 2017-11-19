package com.teja.dto;

import java.io.Serializable;

public class MyPostsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int sno, uid;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
}
