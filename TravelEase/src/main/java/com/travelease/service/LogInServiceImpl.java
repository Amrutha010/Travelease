package com.travelease.service;

import org.springframework.stereotype.Service;

import com.travelease.Exceptions.LoginException;
import com.travelease.models.LogIn;
import com.travelease.models.UserType;

@Service
public class LogInServiceImpl implements LogInService {

	

	@Override
	public String logOutFromAccount(Integer userId, UserType userType) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public UserSessionDAO logIntoAccount(LogIn login) throws LoginException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
