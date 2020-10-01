package com.springbootstudy.main.model;

public class UserDto extends User {

	private String encryptedPassword;

	private String recoverEmailAddress;

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getRecoverEmailAddress() {
		return recoverEmailAddress;
	}

	public void setRecoverEmailAddress(String recoverEmailAddress) {
		this.recoverEmailAddress = recoverEmailAddress;
	}

}
