package com.travelease.service;

import com.travelease.exception.SessionException;
import com.travelease.models.Session;

public interface SessionServices {

	public Session getASessionByKey(String key) throws SessionException;
}
