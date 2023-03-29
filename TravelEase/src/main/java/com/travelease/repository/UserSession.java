package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelease.models.UserType;

public interface UserSession extends JpaRepository<UserSession, Integer>{

	public UserSession findByUserIdAndUserType(Integer userId, UserType userType);
	
	public UserSession findBySessionKey(String Key);
}