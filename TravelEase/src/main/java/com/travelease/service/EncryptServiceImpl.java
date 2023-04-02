package com.travelease.service;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.stereotype.Service;

import com.travelease.models.Admin;

@Service
public class EncryptServiceImpl implements EncryptService{

	@Override
	public String EncryptPassword(String str) {
		
         
		java.util.Base64.Encoder encoder = Base64.getEncoder();
        String originalString = str;
        String encodedString = encoder.encodeToString(originalString.getBytes());



		return encodedString;
	}
	
	@Override
	public Admin DecryptPassword(Admin admin) {
		

        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(admin.getPassword());


        admin.setPassword(new String(bytes));
		return admin;
	}
}
