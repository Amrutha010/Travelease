package com.travelease.service;

import com.travelease.exception.AdminException;
import com.travelease.models.Admin;

public interface AdminServices {

	public Admin addAdmin(Admin admin) throws AdminException;
	
	public Admin getAdminById(Integer adminID)throws AdminException;
	
	public Admin deleteAdminById(Integer adminID)throws AdminException;
	
	public Admin updateAdmin(Admin admin)throws AdminException;
	
	
}
