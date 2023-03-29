package com.travelease.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserSession {
	
	@Id
	private Integer userId;
	private UserType userType;
	private String Key;
	private LocalDateTime timeStamp;
	public UserSession(Integer userId, UserType userType, String key, LocalDateTime timeStamp) {
		super();
		this.userId = userId;
		this.userType = userType;
		Key = key;
		this.timeStamp = timeStamp;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "UserSession userId=" + userId + ", userType=" + userType + ", Key=" + Key + ", timeStamp=" + timeStamp
				+ "";
	}
	
	
}
