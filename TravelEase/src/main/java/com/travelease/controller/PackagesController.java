package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.Exceptions.PackagesException;
import com.travelease.models.Packages;
import com.travelease.service.PackagesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/package")
public class PackagesController {
	
	@Autowired
	private PackagesService ps;
	
	@PostMapping("/createPackages")
	public ResponseEntity<Packages> createPackages(@Valid @RequestBody Packages pkgs ) throws PackagesException{
		return new ResponseEntity<Packages>(ps.createPackage(pkgs),HttpStatus.CREATED);
	}
	
	@GetMapping("/getPackageById/{id}")
	public ResponseEntity<List<Packages>> allPackages(@PathVariable("id") Integer Id) {
		return new ResponseEntity<List<Packages>>(ps.AllPackages(Id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deletePackage/{id}")
	public ResponseEntity<Packages> deletePackage(@PathVariable("id") Integer Id ) throws PackagesException{
		return new ResponseEntity<Packages>(ps.deletePackageById(Id),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/viewAllPackages")
	public ResponseEntity<List<Packages>> viewAllPackages()  {
		List<Packages>pgs=ps.AllPackages(null);
		return new ResponseEntity<List<Packages>>(pgs,HttpStatus.FOUND);
		
	}
	
}
