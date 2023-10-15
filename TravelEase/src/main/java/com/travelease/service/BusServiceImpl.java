package com.travelease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.RouteAlreadyExistsException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.exception.TravelsAlreadyExistsException;
import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Bus;
import com.travelease.models.Route;
import com.travelease.models.Travels;
import com.travelease.repository.BusRepository;
import com.travelease.repository.RouteRepository;
import com.travelease.repository.TravelsRepository;

@Service
public class BusServiceImpl implements BusService{

	@Autowired
	BusRepository busRepository;
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	TravelsRepository travelRepossitory;
	
	
	@Override
	public Bus addNewBus(Bus bus) {
		// TODO Auto-generated method stub
		
		Bus addedBus = busRepository.save(bus);
		
		return addedBus;
	}

	@Override
	public List<Bus> getAllBus() throws BusNotFoundException {
		// TODO Auto-generated method stub
		List<Bus> buses = busRepository.findAll();
		
		if(buses.isEmpty()) {
			throw new BusNotFoundException("No buses avaialble");
		}
		
		return buses;
	}

	@Override
	public Bus getBusById(Integer id) throws BusNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Bus> gotBus = busRepository.findById(id);
		
		if(gotBus==null) {
			throw new BusNotFoundException("No bus found of entered id");
		}
		
		
		return gotBus.get();
	}

	

	@Override
	public Bus increaseBusCapacity(Integer id, Integer busCapacity) throws BusNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Bus> gotBus = busRepository.findById(id);
		
		if(gotBus==null) {
			throw new BusNotFoundException("No bus found of entered id");
		}
		
		gotBus.get().setCapacity(gotBus.get().getCapacity()+busCapacity);
		
		
		Bus updatedSeatsBus = busRepository.save(gotBus.get());
		
		return updatedSeatsBus;
	}

	@Override
	public Bus deletBus(Integer id) throws BusNotFoundException {
		// TODO Auto-generated method stub
		Optional<Bus> gotBus = busRepository.findById(id);
		
		if(gotBus==null) {
			throw new BusNotFoundException("No bus found of entered id");
		}
		
		
		Bus bus = gotBus.get();
		
		
		busRepository.delete(bus);
		
		
		return gotBus.get();
	}

	@Override
	public String addRoute(Integer id , Integer routeId) throws BusNotFoundException, RouteNotFoundException, RouteAlreadyExistsException {
		// TODO Auto-generated method stub
		
		Optional<Bus> gotBus = busRepository.findById(id);
		
		if(gotBus.isEmpty()) {
			throw new BusNotFoundException("No bus found by entered id");
		}
		
		 if(gotBus.get().getRoute()!=null) {
			  throw new RouteAlreadyExistsException("This bus is already associated with some other route");
		  }
		
		  Optional<Route> gotRoute =  routeRepository.findById(routeId);
				
		
		  if(gotRoute.isEmpty()) {
			  throw new RouteNotFoundException("No route found of enetered id");
		  }
		  
		  gotBus.get().setRoute(gotRoute.get());
		  
		  List<Bus> busList = gotRoute.get().getBus();
		  
		  busList.add(gotBus.get());
		  
		  gotRoute.get().setBus( busList);
		  
		  
		  
		  busRepository.save(gotBus.get());
		  routeRepository.save(gotRoute.get());
		  
		return "Route added successfully";
	}

	@Override
	public String addTravels(Integer id , Integer travelsId) throws BusNotFoundException, TravelsNotFoundException, TravelsAlreadyExistsException {
		// TODO Auto-generated method stub
		
		Optional<Bus> gotBus = busRepository.findById(id);
		
		if(gotBus.isEmpty()) {
			throw new BusNotFoundException("No bus found by entered id");
		}
		
		  Optional<Travels> gotTravels =  travelRepossitory.findById(travelsId);
			
			
		  
		  if(gotBus.get().getTravels()!=null) {
			  throw new TravelsAlreadyExistsException("This bus is already associated with some other Travels");
		  }
		  
		  if(gotTravels.isEmpty()) {
			  throw new TravelsNotFoundException("No Travels found of enetered id");
		  }
		  
		  gotBus.get().setTravels(gotTravels.get());
		  
		  List<Bus> busList = gotTravels.get().getBus();
		  
		  busList.add(gotBus.get());
		  
		  gotTravels.get().setBus( busList);
		  
		  
		  
		  busRepository.save(gotBus.get());
		  travelRepossitory.save(gotTravels.get());
		  
		return "Travels added successfully";
		  
		  
		
		
	}

}
