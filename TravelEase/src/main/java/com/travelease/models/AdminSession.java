package com.travelease.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
//public class AdminSession {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	@Column(unique =true)
//	private Integer adminId;
//	private String  key;
//	private LocalDateTime localDateTime;
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Integer getAdminId() {
//		return adminId;
//	}
//	public void setAdminId(Integer adminId) {
//		this.adminId = adminId;
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
//	@Override
//	public String toString() {
//		return "AdminSession [id=" + id + ", adminId=" + adminId + ", key=" + key + ", localDateTime=" + localDateTime
//				+ "]";
//	}
//	public AdminSession(Integer id, Integer adminId, String key, LocalDateTime localDateTime) {
//		super();
//		this.id = id;
//		this.adminId = adminId;
//		this.key = key;
//		this.localDateTime = localDateTime;
//	}
//	public AdminSession() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	
//	
//}
