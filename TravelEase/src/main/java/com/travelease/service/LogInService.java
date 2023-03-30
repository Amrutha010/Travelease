package com.travelease.service;


//import org.springframework.boot.web.servlet.server.Session;

import com.travelease.Exceptions.LoginException;
import com.travelease.models.LogIn;
import com.travelease.models.UserType;

public interface LogInService {

	

	
	public String logIntoAccount(LogIn login) throws LoginException;
	
	public String logOutFromAccount(Integer userId, UserType userType)throws LoginException;
}
