package com.teja.dto;

import java.io.Serializable;

public class SerializedMyPostsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int min_num, max_num, uid;

	public int getMin_num() {
		return min_num;
	}

	public void setMin_num(int min_num) {
		this.min_num = min_num;
	}

	public int getMax_num() {
		return max_num;
	}

	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
}
