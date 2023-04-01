package com.travelease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.LoginException;
import com.travelease.models.LoginDTO;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.repository.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController("/user")
public class LoginController {

	@Autowired
	private LoginService lServices;
	
	@PostMapping("/login")
	public ResponseEntity<Session> login(@RequestBody LoginDTO loginDto) throws LoginException{
		System.out.println(loginDto);
		Session session = lServices.login(loginDto);
		return new ResponseEntity<Session>(session, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "userType") UserType userType)throws LoginException{
		String response =  lServices.logout(userId, userType);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
	}
}

