package com.travelease.service;

import com.travelease.exception.LoginException;
import com.travelease.models.LoginDTO;
import com.travelease.models.Session;
import com.travelease.models.UserType;

public interface LoginService {
	public Session login(LoginDTO loginDto) throws LoginException;
	
	public String logout(Integer userId, UserType userType)throws LoginException;
}
