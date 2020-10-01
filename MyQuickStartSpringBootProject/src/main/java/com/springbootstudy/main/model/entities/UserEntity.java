package com.springbootstudy.main.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String emailId;

	@Column(nullable = false)
	private Boolean emailVerification = false;

	@Column(nullable = false)
	private String encryptedPassword;

	@Column(nullable = false)
	private String recoverEmailAddress;

	@Column(nullable = false)
	private Date dateUserAdded;

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

	public Date getDateUserAdded() {
		return dateUserAdded;
	}

	public void setDateUserAdded(Date dateUserAdded) {
		this.dateUserAdded = dateUserAdded;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(Boolean emailVerification) {
		this.emailVerification = emailVerification;
	}

}
