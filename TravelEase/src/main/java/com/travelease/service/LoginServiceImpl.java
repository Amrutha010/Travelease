package com.travelease.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.models.Admin;
import com.travelease.models.CurrentUserSession;
import com.travelease.models.LogIn;
@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public String logIntoAccount(LogIn dto) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logInAsUser(LogIn loginDTO) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLoggedIn(String key) throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}
	

	



}