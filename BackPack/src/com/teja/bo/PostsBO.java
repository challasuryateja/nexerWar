package com.teja.bo;

public class PostsBO {

	private int post_id, pic_count, bedrooms, bathrooms, avg_rating, uid;
	private String area, city;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getPic_count() {
		return pic_count;
	}

	public void setPic_count(int pic_count) {
		this.pic_count = pic_count;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public int getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
