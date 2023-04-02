package com.travelease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.SessionException;
import com.travelease.models.Session;
import com.travelease.repository.SessionDAO;

@Service
public class SessionServicesImpl implements SessionServices{
	
	@Autowired
	private SessionDAO sDao;
	
	@Override
	public Session getASessionByKey(String key) throws SessionException {
		// TODO Auto-generated method stub
		Session currentSession = sDao.findBySessionKey(key);
		if(currentSession==null)
			throw new SessionException("No session found with that session key");
		return currentSession;
	}
}
