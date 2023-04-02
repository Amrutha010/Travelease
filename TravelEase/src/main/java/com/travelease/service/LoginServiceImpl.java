package com.travelease.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.LoginException;
import com.travelease.models.Admin;
import com.travelease.models.Customer;
import com.travelease.models.LoginDTO;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.repository.AdminDAO;
import com.travelease.repository.CustomerDAO;
import com.travelease.repository.SessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private SessionDAO sDao;
	
	@Autowired
	private AdminDAO aDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	@Override
	public Session login(LoginDTO loginDto) throws LoginException {
		// TODO Auto-generated method stub
		
		Session mainSession = null;
		if(loginDto.getUserType()==UserType.ADMIN) {
			Admin admin =  aDao.findByEmail(loginDto.getEmail());
		
			if(admin == null)
				throw new LoginException("Admin not present with that email");
			
			Optional<Session> currentSession =  sDao.findById(admin.getAdminID());
			
			if(currentSession.isPresent())
				throw new LoginException("This user is already logged in");
			
			if(admin.getPassword().equals(loginDto.getPassword())) {
				String key = RandomString.make(6);
				
				Session session = new Session();
				session.setSessionKey(key);
				session.setUserId(admin.getAdminID());
				session.setUserType(loginDto.getUserType());
				session.setTimeStamp(LocalDateTime.now());
				mainSession =  sDao.save(session);	
			}
			else
				throw new LoginException("Please enter the correct password");
		}
		else {
			Customer customer = cDao.findByEmail(loginDto.getEmail());
			if(customer == null)
				throw new LoginException("Customer not present with the email:-"+loginDto.getEmail());
			
			Optional<Session> currentSession = sDao.findById(customer.getCustomerId());
			
			if(currentSession.isPresent())
				throw new LoginException("This user is already logged in");
		
			if(customer.getCustomerPassword().equals(loginDto.getPassword())) {
				String key = RandomString.make(6);
				
				Session session = new Session();
				session.setSessionKey(key);
				session.setUserId(customer.getCustomerId());
				session.setUserType(loginDto.getUserType());
				session.setTimeStamp(LocalDateTime.now());
				mainSession = sDao.save(session);;
			}
			else {
				throw new LoginException("Please enter the correct password");
			}
		}
		return mainSession;
	}

	@Override
	public String logout(Integer userId, UserType userType) throws LoginException {
		Session session = sDao.findByUserIdAndUserType(userId, userType);
		
		if(session == null)
			throw new LoginException("No user logged in with that User Id and Type");
		
		sDao.delete(session);
		
		return "Logged Out successfully!";
	}


}
