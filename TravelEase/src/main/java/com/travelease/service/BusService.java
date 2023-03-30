package com.travelease.service;

import java.util.List;

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.RouteAlreadyExistsException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.exception.TravelsAlreadyExistsException;
import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Bus;

public interface BusService {

	
	public Bus addNewBus(Bus bus);
	
	public List<Bus> getAllBus() throws BusNotFoundException ;
	
	public Bus getBusById(Integer id) throws BusNotFoundException;

	
	public Bus increaseBusCapacity(Integer id , Integer busCapacity) throws BusNotFoundException;;
	
	public Bus deletBus(Integer id) throws BusNotFoundException;
	
	public String addRoute(Integer busId , Integer routeId) throws BusNotFoundException , RouteNotFoundException, RouteAlreadyExistsException;
	
	public String addTravels(Integer id , Integer travelsId) throws BusNotFoundException , TravelsNotFoundException,TravelsAlreadyExistsException;
}
