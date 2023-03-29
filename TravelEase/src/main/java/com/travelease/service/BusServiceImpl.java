package com.travelease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.BusNotFoundException;
import com.travelease.models.Bus;
import com.travelease.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService{

	@Autowired
	BusRepository busRepository;
	
	
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
		
		busRepository.delete(gotBus.get());
		
		return gotBus.get();
	}

}
