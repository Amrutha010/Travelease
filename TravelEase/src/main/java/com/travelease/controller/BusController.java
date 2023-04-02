package com.travelease.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.AdminException;
import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.CustomerException;
import com.travelease.exception.LoginException;
import com.travelease.exception.RouteAlreadyExistsException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.exception.SessionException;
import com.travelease.exception.TravelsAlreadyExistsException;
import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Bus;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.service.BusService;
import com.travelease.service.SessionServices;

import jakarta.validation.Valid;


@RestController
public class BusController {

	@Autowired
	BusService busService;
	
	@Autowired
	private SessionServices sessionService;
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus , @RequestParam("sessionKey")String sessionKey) throws SessionException, AdminException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		System.out.println(bus);
		Bus addedBus = busService.addNewBus(bus);
		return new ResponseEntity<Bus>(addedBus, HttpStatus.ACCEPTED);
		}throw new AdminException("Please login with the correct credentials");
	}
	
	
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> getAllBusses(@RequestParam("sessionKey")String sessionKey) throws BusNotFoundException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
		List<Bus> buses = busService.getAllBus();
		
		return new ResponseEntity<List<Bus>>(buses, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
	}
	
	
	
	
	@GetMapping("/bus/{id}")
	public ResponseEntity<Bus> getBusByID(@PathVariable Integer id,@RequestParam("sessionKey")String sessionKey) throws BusNotFoundException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
		Bus bus = busService.getBusById(id);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
	}
	
	
		
	
	@PatchMapping("bus/updateSeats")
	public ResponseEntity<Bus> increaseBusCapacity(@RequestParam Integer id , @RequestParam Integer seats,@RequestParam("sessionKey")String sessionKey) throws BusNotFoundException, SessionException, AdminException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Bus gotBus = busService.increaseBusCapacity(id, seats);
		return new ResponseEntity<Bus>(gotBus, HttpStatus.OK);
	}throw new LoginException("Please login with the correct credentials");
	}
	
	
	
	@DeleteMapping("/bus")
	public ResponseEntity<Bus> deleteBus(@RequestParam Integer id,@RequestParam("sessionKey")String sessionKey) throws BusNotFoundException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Bus deletedBus = busService.deletBus(id);
		
		return new ResponseEntity<Bus>(deletedBus, HttpStatus.ACCEPTED);
		}throw new LoginException("Please login with the correct credentials");
	}

	
	
	@PatchMapping("/bus/updateRoute")
	public ResponseEntity<String> addNewROute(@RequestParam Integer busId , @RequestParam Integer routeId,@RequestParam("sessionKey")String sessionKey) throws BusNotFoundException, RouteNotFoundException, RouteAlreadyExistsException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		String res = busService.addRoute(busId, routeId);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
	}
	
	
	@PatchMapping("/bus/updateTravels")
	public ResponseEntity<String> addNewTravels(@RequestParam Integer busId , @RequestParam Integer travelsId,@RequestParam("sessionKey")String sessionKey) throws BusNotFoundException, TravelsNotFoundException, TravelsAlreadyExistsException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		String res = busService.addTravels(busId, travelsId);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
	}
	
	
	
}
