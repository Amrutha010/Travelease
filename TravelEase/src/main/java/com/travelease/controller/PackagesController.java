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

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.HotelException;
import com.travelease.exception.LoginException;
import com.travelease.exception.PackagesException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.exception.SessionException;
import com.travelease.models.Packages;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.service.PackagesService;
import com.travelease.service.SessionServices;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;


@RestController
public class PackagesController {
	
	@Autowired
	private PackagesService ps;
	
	@Autowired
	private SessionServices sessionService;
	
	@PostMapping("/Packages")
	public ResponseEntity<Packages> createPackages(@Valid @RequestBody Packages pkgs,@RequestParam("sessionKey")String sessionKey , @RequestParam Integer busId , @RequestParam Integer hotelId , @RequestParam Integer routeId) throws PackagesException, BusNotFoundException, RouteNotFoundException, HotelException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			
		Packages pk= ps.createPackage(pkgs,busId,hotelId,routeId);
		
		return new ResponseEntity<>(pk,HttpStatus.CREATED);
	}
	throw new LoginException("Please login with the correct credentials");
}
	
	
	@GetMapping("/PackageById/{id}")

	public ResponseEntity<Packages> getPackagesbyId(@PathVariable("id") Integer Id,@RequestParam("sessionKey")String sessionKey) throws PackagesException, SessionException, LoginException {
		Session session = sessionService.getASessionByKey(sessionKey);
		
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
		

		Packages pk = ps.getPackageById(Id);
		
		return new ResponseEntity<>(pk,HttpStatus.FOUND);

	}
		throw new LoginException("Please login with the correct credentials");
	}
	
	@DeleteMapping("/Package/{id}")
	public ResponseEntity<Packages> deletePackage(@PathVariable("id") Integer Id ,@RequestParam("sessionKey")String sessionKey) throws PackagesException, SessionException, LoginException{
		Session session = sessionService.getASessionByKey(sessionKey);
		
		if(session.getUserType()==UserType.ADMIN) {

		Packages pk =  ps.deletePackageById(Id);
		
		return new ResponseEntity<>(pk,HttpStatus.ACCEPTED);

		}
		throw new LoginException("Please login with the correct credentials");

		
	}
	
	@GetMapping("/Packages")
	public ResponseEntity<List<Packages>> viewAllPackages(@PathVariable("id") Integer id,@RequestParam("sessionKey")String sessionKey) throws SessionException, LoginException  {
		Session session = sessionService.getASessionByKey(sessionKey);
		
		if(session.getUserType()==UserType.ADMIN||session.getUserType()==UserType.CUSTOMER) {
			
		List<Packages>pgs= ps.AllPackages(id);
		
		return new ResponseEntity<>(pgs,HttpStatus.FOUND);
		}
		throw new LoginException("Please login with the correct credentials");

		
	}
	
}
