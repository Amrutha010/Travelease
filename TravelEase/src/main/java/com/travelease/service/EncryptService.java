package com.travelease.service;

import com.travelease.models.Admin;

public interface EncryptService {

	public String EncryptPassword(String str);
	public Admin DecryptPassword(Admin admin);
}
