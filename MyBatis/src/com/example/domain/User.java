package com.example.domain;

import java.util.Date;

public class User {

	private int id;
	private String username;
	private String sex;
	private Date birthDay;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		User u = (User) obj;
		if (u.getId() == this.id)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "user: " + this.id + " " + this.username + " " + this.sex + " " + this.address;
	}
}
