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

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.RouteAlreadyExistsException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.exception.TravelsAlreadyExistsException;
import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Bus;

import com.travelease.service.BusService;

import jakarta.validation.Valid;


@RestController
public class BusController {

	@Autowired
	BusService busService;
	
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus){
		
		System.out.println(bus);
		
		Bus addedBus = busService.addNewBus(bus);
		
		return new ResponseEntity<Bus>(addedBus, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> getAllBusses() throws BusNotFoundException{
		
		List<Bus> buses = busService.getAllBus();
		
		return new ResponseEntity<List<Bus>>(buses, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/bus/{id}")
	public ResponseEntity<Bus> getBusByID(@PathVariable Integer id) throws BusNotFoundException{
		
		Bus bus = busService.getBusById(id);
		
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}
	
		
	
	@PatchMapping("bus/updateSeats")
	public ResponseEntity<Bus> increaseBusCapacity(@RequestParam Integer id , @RequestParam Integer seats) throws BusNotFoundException{
		
		Bus gotBus = busService.increaseBusCapacity(id, seats);
		
		return new ResponseEntity<Bus>(gotBus, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/bus")
	public ResponseEntity<Bus> deleteBus(@RequestParam Integer id) throws BusNotFoundException{
		
		Bus deletedBus = busService.deletBus(id);
		
		return new ResponseEntity<Bus>(deletedBus, HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PatchMapping("/bus/updateRoute")
	public ResponseEntity<String> addNewROute(@RequestParam Integer busId , @RequestParam Integer routeId) throws BusNotFoundException, RouteNotFoundException, RouteAlreadyExistsException{
		
		String res = busService.addRoute(busId, routeId);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	
	@PatchMapping("/bus/updateTravels")
	public ResponseEntity<String> addNewTravels(@RequestParam Integer busId , @RequestParam Integer travelsId) throws BusNotFoundException, TravelsNotFoundException, TravelsAlreadyExistsException{
		
		String res = busService.addTravels(busId, travelsId);
		
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	

	
	
}
