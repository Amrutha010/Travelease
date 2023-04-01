package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.LoginException;
import com.travelease.exception.SessionException;
import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Session;
import com.travelease.models.Travels;
import com.travelease.models.UserType;
import com.travelease.service.SessionServices;
import com.travelease.service.TravelsService;

import jakarta.validation.Valid;

@RestController
public class TravelsController {

	
	@Autowired
	TravelsService travelsService;
	
	@Autowired
	private SessionServices sessionService;
	
	@PostMapping("/travels")
	public ResponseEntity<Travels> addTravels(@Valid @RequestBody Travels travels,@RequestParam("sessionKey")String sessionKey) throws LoginException, SessionException{

		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Travels addedTravel = travelsService.addTravel(travels);
		
		return new ResponseEntity<Travels>(addedTravel, HttpStatus.ACCEPTED);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@GetMapping("/travels")
	public ResponseEntity<List<Travels>> getAllTravels(@RequestParam("sessionKey")String sessionKey) throws TravelsNotFoundException, LoginException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		List<Travels> travelsList = travelsService.viewTravels();
		
		return new ResponseEntity<List<Travels>>(travelsList, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@GetMapping("/travels/{id}")
	public ResponseEntity<Travels> findTravelsById(@PathVariable Integer id,@RequestParam("sessionKey")String sessionKey) throws TravelsNotFoundException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Travels gotTravel = travelsService.searchTravels(id);
		
		return new ResponseEntity<Travels>(gotTravel, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@DeleteMapping("/travels/{id}")
	public ResponseEntity<Travels> deletTravelsById(@PathVariable Integer id,@RequestParam("sessionKey")String sessionKey) throws TravelsNotFoundException, LoginException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Travels gotTravel = travelsService.removeTravel(id);
		
		return new ResponseEntity<Travels>(gotTravel, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@PostMapping("/travels/update")
	public ResponseEntity<Travels> updateTravels(@Valid @RequestBody Travels travels,@RequestParam("sessionKey")String sessionKey) throws TravelsNotFoundException, LoginException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Travels gotTravel = travelsService.updateTravel(travels);
		
		return new ResponseEntity<Travels>(gotTravel, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
 	
}
