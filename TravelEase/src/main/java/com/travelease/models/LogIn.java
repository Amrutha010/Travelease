package com.travelease.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class LogIn {
	
	@Id
	@NotNull
	private Integer UserId;
	
	private String userName;
	
	
	private String password;

	@Override
	public String toString() {
		return "LogIn [UserId=" + UserId + ", userName=" + userName + ", password=" + password + "]";
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
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

	public LogIn(@NotNull Integer userId, String userName,
			@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message = "Min 1 uppercase letter.\nMin 1 lowercase letter.\nMin 1 special character [@$!%*#?&].\nMin 1 number.\nMin 6 characters.") String password) {
		super();
		UserId = userId;
		this.userName = userName;
		this.password = password;
	}

	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
