package com.travelease.service;


//import org.springframework.boot.web.servlet.server.Session;

import com.travelease.Exceptions.LoginException;
import com.travelease.models.LogIn;
import com.travelease.models.UserSession;
import com.travelease.models.UserType;

public interface LogInService {

	
//	public UserSessionDAO logIntoAccount(LogIn login) throws LoginException;
	
	public String logOutFromAccount(Integer userId, UserType userType)throws LoginException;
}
