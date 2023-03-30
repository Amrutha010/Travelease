package com.travelease.service;

import java.util.List;

import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Travels;

public interface TravelsService {

	public Travels addTravel(Travels travels);
	
	public Travels updateTravel(Travels travels) throws TravelsNotFoundException;
	
	public Travels removeTravel(Integer id) throws TravelsNotFoundException;
	
	public Travels searchTravels(Integer id) throws TravelsNotFoundException;
	
	public List<Travels> viewTravels() throws TravelsNotFoundException;
}
