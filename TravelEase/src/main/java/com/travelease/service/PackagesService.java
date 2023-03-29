package com.travelease.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.travelease.Exceptions.PackagesException;
import com.travelease.models.Packages;

public interface PackagesService {
	
	public Packages createPackage(Packages pgs) throws PackagesException;
	
	public List<Packages> AllPackages(Integer id);
	
	public Optional<Packages> getPackageById(Integer id) throws PackagesException;
	
	public Packages deletePackageById(Integer id) throws PackagesException;

	Packages updatePackages(Packages p) throws PackagesException;

	
}
