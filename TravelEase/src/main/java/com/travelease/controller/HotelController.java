package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.HotelException;
import com.travelease.exception.LoginException;
import com.travelease.exception.SessionException;
import com.travelease.models.Hotel;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.service.HotelService;
import com.travelease.service.SessionServices;

import jakarta.validation.Valid;

@RestController
public class HotelController {

	@Autowired
	HotelService hs;
	
	@Autowired
	private SessionServices sessionService;
	
	@PostMapping("/Hotel")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel pack,@RequestParam("sessionKey")String sessionKey) throws SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Hotel h = hs.createHotel(pack);
		return new ResponseEntity<>(h,HttpStatus.CREATED);
		}throw new LoginException("Please login with the correct credentials");
	}
	//admin
			
	@GetMapping("/Hotel/{id}")
	public ResponseEntity<Hotel> searchHotelById(@PathVariable("id") Integer id,@RequestParam("sessionKey")String sessionKey) throws HotelException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
		Hotel h = hs.getHotelById(id);
		return new ResponseEntity<>(h,HttpStatus.FOUND);
		}throw new LoginException("Please login with the correct credentials");
	}
	//admin,cstomer
	
	@GetMapping("/AllHotels")
	public ResponseEntity<List<Hotel>> viewAllHotels(@RequestParam("sessionKey")String sessionKey) throws HotelException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		List<Hotel> list = hs.AllHotels();
		return new ResponseEntity<>(list,HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
	}
	
	
	@DeleteMapping("/Hotel/{id}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") Integer id,@RequestParam("sessionKey")String sessionKey) throws HotelException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Hotel h = hs.deleteHotel(id);
		return new ResponseEntity<>(h,HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
	}
	
	
	
	
	
}
