package com.travelease.service;

import javax.security.auth.login.LoginException;

import com.travelease.models.CurrentUserSession;
import com.travelease.models.LogIn;
public interface LoginService {

	public String logIntoAccount(LogIn dto) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;

	public String logInAsUser(LogIn loginDTO) throws LoginException;

	public boolean isLoggedIn(String key) throws LoginException;

}
