package com.travelease.service;


import java.util.List;
import java.util.Optional;

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.HotelException;
import com.travelease.exception.PackagesException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.models.Packages;

public interface PackagesService {
	
	public Packages createPackage(Packages pgs  ,Integer busId , Integer hotelId , Integer routeId) throws BusNotFoundException, RouteNotFoundException, HotelException;
	
	public List<Packages> AllPackages();
	
	public Packages getPackageById(Integer id) throws PackagesException;
	
	public Packages deletePackageById(Integer id) throws PackagesException;

	Packages updatePackages(Packages p);

	
}
