package com.travelease.service;

import com.travelease.models.User;

public interface UserService {
	
	public User addNewUser(User userDetails);
	public User signIn(User userDetails);
	public User signOut(User userDetails);
}
