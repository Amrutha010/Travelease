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
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Travels;
import com.travelease.service.TravelsService;

import jakarta.validation.Valid;

@RestController
public class TravelsController {

	
	@Autowired
	TravelsService travelsService;
	
	
	@PostMapping("/travels")
	public ResponseEntity<Travels> addTravels(@Valid @RequestBody Travels travels){
		
		
//		travels.getBus().stream().forEach(s->{
//			
//			s.setTravels(travels);
//		});
		
		Travels addedTravel = travelsService.addTravel(travels);
		
		
//		System.out.println(addedTravel.getBus().get(0).getTravels());
		
		return new ResponseEntity<Travels>(addedTravel, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/travels")
	public ResponseEntity<List<Travels>> getAllTravels() throws TravelsNotFoundException{
		
		List<Travels> travelsList = travelsService.viewTravels();
		
		return new ResponseEntity<List<Travels>>(travelsList, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/travels/{id}")
	public ResponseEntity<Travels> findTravelsById(@PathVariable Integer id) throws TravelsNotFoundException{
		
		Travels gotTravel = travelsService.searchTravels(id);
		
		return new ResponseEntity<Travels>(gotTravel, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/travels/{id}")
	public ResponseEntity<Travels> deletTravelsById(@PathVariable Integer id) throws TravelsNotFoundException{
		
		Travels gotTravel = travelsService.removeTravel(id);
		
		return new ResponseEntity<Travels>(gotTravel, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/travels/update")
	public ResponseEntity<Travels> updateTravels(@Valid @RequestBody Travels travels) throws TravelsNotFoundException{
		
		Travels gotTravel = travelsService.updateTravel(travels);
		
		return new ResponseEntity<Travels>(gotTravel, HttpStatus.OK);
		
	}
 	
}
