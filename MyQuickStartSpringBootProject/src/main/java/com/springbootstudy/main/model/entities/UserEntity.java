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
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String userId;

	@Column(nullable = false)
	private Boolean emailVerification = false;

	@Column(nullable = false)
	private Date dateUserAdded;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEmailVerification() {
		return emailVerification;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEmailVerification(Boolean emailVerification) {
		this.emailVerification = emailVerification;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", userId=" + userId
				+ ", emailVerification=" + emailVerification + ", dateUserAdded=" + dateUserAdded + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
