package com.travelease.service;

import java.util.List;

import com.travelease.exception.BusNotFoundException;
import com.travelease.models.Bus;

public interface BusService {

	
	public Bus addNewBus(Bus bus);
	
	public List<Bus> getAllBus() throws BusNotFoundException ;
	
	public Bus getBusById(Integer id) throws BusNotFoundException;

	
	public Bus increaseBusCapacity(Integer id , Integer busCapacity) throws BusNotFoundException;;
	
	public Bus deletBus(Integer id) throws BusNotFoundException;;
}
