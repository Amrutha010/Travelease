package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Session;
import com.travelease.models.UserType;

@Repository
public interface SessionDAO extends JpaRepository<Session, Integer>{

	public Session findByUserIdAndUserType(Integer userId, UserType userType);
	
	public Session findBySessionKey(String sessionKey);
}
