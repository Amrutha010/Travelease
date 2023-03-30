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

import com.travelease.Exceptions.PackagesException;
import com.travelease.models.Packages;
import com.travelease.service.PackagesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class PackagesController {
	
	@Autowired
	private PackagesService ps;
	
	@PostMapping("/Packages")
	public ResponseEntity<Packages> createPackages(@Valid @RequestBody Packages pkgs ) throws PackagesException{
		return new ResponseEntity<>(ps.createPackage(pkgs),HttpStatus.CREATED);
	}
	
	@GetMapping("/PackageById/{id}")
	public ResponseEntity<List<Packages>> allPackages(@PathVariable("id") Integer Id) {
		return new ResponseEntity<>(ps.AllPackages(Id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/Package/{id}")
	public ResponseEntity<Packages> deletePackage(@PathVariable("id") Integer Id ) throws PackagesException{
		return new ResponseEntity<>(ps.deletePackageById(Id),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/Packages")
	public ResponseEntity<List<Packages>> viewAllPackages()  {
		List<Packages>pgs=ps.AllPackages(null);
		return new ResponseEntity<>(pgs,HttpStatus.FOUND);
		
	}
	
}
