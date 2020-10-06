package com.springbootstudy.main.model;

public class UserDto extends User {

	private String userId;

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
