package com.travelease.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
//public class CustomerSession {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//	@Column(unique =true)
//	private Integer userId;
//	private String  key;
//	private LocalDateTime localDateTime;
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//	public String getKey() {
//		return key;
//	}
//	public void setKey(String key) {
//		this.key = key;
//	}
//	public LocalDateTime getLocalDateTime() {
//		return localDateTime;
//	}
//	public void setLocalDateTime(LocalDateTime localDateTime) {
//		this.localDateTime = localDateTime;
//	}
//	public CustomerSession(Integer id, Integer userId, String key, LocalDateTime localDateTime) {
//		super();
//		this.id = id;
//		this.userId = userId;
//		this.key = key;
//		this.localDateTime = localDateTime;
//	}
//	public CustomerSession() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public String toString() {
//		return "CustomerSession [id=" + id + ", userId=" + userId + ", key=" + key + ", localDateTime=" + localDateTime
//				+ "]";
//	}
//	
//	
//}
