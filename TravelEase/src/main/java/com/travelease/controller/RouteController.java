package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.LoginException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.exception.SessionException;
import com.travelease.models.Route;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.service.RouteService;
import com.travelease.service.SessionServices;

import jakarta.validation.Valid;

@RestController
public class RouteController {

	@Autowired
	RouteService routeService;
	
	@Autowired
	private SessionServices sessionService;
	
	@PostMapping("/route")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route,@RequestParam("sessionKey")String sessionKey) throws SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Route addedRoute = routeService.addRoute(route);
		
		return new ResponseEntity<Route>(addedRoute, HttpStatus.ACCEPTED);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllTravels(@RequestParam("sessionKey")String sessionKey) throws RouteNotFoundException, LoginException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
		List<Route> routeList = routeService.viewRoute();
		
		return new ResponseEntity<List<Route>>(routeList, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@GetMapping("/route/{id}")
	public ResponseEntity<Route> findTravelsById(@PathVariable Integer id,@RequestParam("sessionKey")String sessionKey) throws RouteNotFoundException, LoginException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
		Route gotRoute = routeService.searchRoute(id);
		
		return new ResponseEntity<Route>(gotRoute, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	@PostMapping("/route/update")
	public ResponseEntity<Route> updateTravels(@Valid @RequestBody Route route,@RequestParam("sessionKey")String sessionKey) throws RouteNotFoundException, LoginException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		Route gotRoute = routeService.updateRoute(route);
		
		return new ResponseEntity<Route>(gotRoute, HttpStatus.OK);
		}throw new LoginException("Please login with the correct credentials");
		
	}
	
	
	
}
