package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.UserSession;
import com.travelease.models.UserType;


//@Repository
//public interface UserSessionDAO extends JpaRepository<UserSession, Integer>{
//
//	public UserSessionDAO findByUserIdAndUserType(Integer userId, UserType userType);
//	
//	public UserSessionDAO findBySessionKey(String Key);
//}