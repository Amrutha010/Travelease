package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.RouteNotFoundException;
import com.travelease.models.Route;
import com.travelease.service.RouteService;

import jakarta.validation.Valid;

@RestController
public class RouteController {

	@Autowired
	RouteService routeService;
	

	@PostMapping("/route")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route){
		
		Route addedRoute = routeService.addRoute(route);
		
		return new ResponseEntity<Route>(addedRoute, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllTravels() throws RouteNotFoundException{
		
		List<Route> routeList = routeService.viewRoute();
		
		return new ResponseEntity<List<Route>>(routeList, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/route/{id}")
	public ResponseEntity<Route> findTravelsById(@PathVariable Integer id) throws RouteNotFoundException{
		
		Route gotRoute = routeService.searchRoute(id);
		
		return new ResponseEntity<Route>(gotRoute, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/route/update")
	public ResponseEntity<Route> updateTravels(@Valid @RequestBody Route route) throws RouteNotFoundException{
		
		Route gotRoute = routeService.updateRoute(route);
		
		return new ResponseEntity<Route>(gotRoute, HttpStatus.OK);
		
	}
	
	
	
}
