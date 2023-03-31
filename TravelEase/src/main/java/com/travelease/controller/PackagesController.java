package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.HotelException;
import com.travelease.exception.PackagesException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.models.Packages;
import com.travelease.service.PackagesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class PackagesController {
	
	@Autowired
	private PackagesService ps;
	
	@PostMapping("/Packages")
	public ResponseEntity<Packages> createPackages(@Valid @RequestBody Packages pkgs ) throws PackagesException, BusNotFoundException, RouteNotFoundException, HotelException{
		Packages pk= ps.createPackage(pkgs);
		return new ResponseEntity<>(pkgs,HttpStatus.CREATED);
	}
	
	@GetMapping("/PackageById/{id}")
	public ResponseEntity<Packages> getPackagesbyId(@PathVariable("id") Integer Id) throws PackagesException {
		Packages pk = ps.getPackageById(Id);
		return new ResponseEntity<>(pk,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/Package/{id}")
	public ResponseEntity<Packages> deletePackage(@PathVariable("id") Integer Id ) throws PackagesException{
		Packages pk =  ps.deletePackageById(Id);
		return new ResponseEntity<>(pk,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/Packages")
	public ResponseEntity<List<Packages>> viewAllPackages(@PathVariable("id") Integer id)  {
		List<Packages>pgs= ps.AllPackages(id);
		
		return new ResponseEntity<>(pgs,HttpStatus.FOUND);
		
	}
	
}
