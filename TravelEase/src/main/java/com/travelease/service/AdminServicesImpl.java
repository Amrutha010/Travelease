package com.travelease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.AdminException;
import com.travelease.models.Admin;
import com.travelease.repository.AdminDAO;

@Service
public class AdminServicesImpl implements AdminServices{

	@Autowired
	private AdminDAO aDao;
	
	private EncryptService encrypt=new EncryptServiceImpl();
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminException {


		if(aDao.findByEmail(admin.getEmail()) != null)
				throw new AdminException("Admin already present with that email id");
        
        	String admin1= encrypt.EncryptPassword(admin.getPassword());
        	admin.setPassword(admin1);
		     return aDao.save(admin);	

	}

	@Override
	public Admin getAdminById(Integer adminID) throws AdminException {
		// TODO Auto-generated method stub
		return aDao.findById(adminID).orElseThrow(() -> new AdminException("No Admin found with that Id:- "+adminID));
	}

	@Override
	public Admin deleteAdminById(Integer adminID)throws AdminException{
		// TODO Auto-generated method stub
		Admin admin = aDao.findById(adminID).orElseThrow(() -> new AdminException("No Admin found with that Id:- "+adminID));
		aDao.delete(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		aDao.findById(admin.getAdminID()).orElseThrow(()-> new AdminException("No Admin found with the Id:-"+admin.getAdminID()));
		return aDao.save(admin);
	}


	

}
