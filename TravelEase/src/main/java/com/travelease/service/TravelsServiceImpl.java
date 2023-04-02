package com.travelease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.TravelsNotFoundException;
import com.travelease.models.Bus;
import com.travelease.models.Travels;
import com.travelease.repository.BusRepository;
import com.travelease.repository.TravelsRepository;


@Service
public class TravelsServiceImpl implements TravelsService{

	
	@Autowired
	TravelsRepository travelRepository;
	
	@Autowired
	BusRepository busRepository;
	
	
	
	@Override
	public Travels addTravel(Travels travels) {
		// TODO Auto-generated method stub
		
		Travels addedTravel = travelRepository.save(travels);
		
		return addedTravel;
	}

	@Override
	public Travels updateTravel(Travels travels) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		
		
		 Optional<Travels> gotTravels = travelRepository.findById(travels.getTravelsId());
		
		 if(gotTravels.get()==null) {
			 throw new TravelsNotFoundException("No travels found ");
		 }
		 
		 
		 
		 Travels foundTravels = travelRepository.save(travels);

		 
		return foundTravels;
	}

	@Override
	public Travels removeTravel(Integer id) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Travels> searchedTravels = travelRepository.findById(id);
		
		if(searchedTravels.isEmpty()) {
			throw new TravelsNotFoundException("No travles found with enterd id");
		}
		
		//All the associated buses will be released and not deleted
		
		searchedTravels.get().getBus().stream().forEach(s->{
			s.setTravels(null);
		});
		
		
		travelRepository.delete(searchedTravels.get());
		
		
		return searchedTravels.get();
		
		
	}

	@Override
	public Travels searchTravels(Integer id) throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Travels> searchedTravels = travelRepository.findById(id);
		
		if(searchedTravels.isEmpty()) {
			throw new TravelsNotFoundException("No travles found with enterd id");
		}
		
		return searchedTravels.get();
	}

	@Override
	public List<Travels> viewTravels() throws TravelsNotFoundException {
		// TODO Auto-generated method stub
		
		List<Travels> travelsList = travelRepository.findAll();
		
		
		if(travelsList.isEmpty()) {
			throw new TravelsNotFoundException("No travels available");
		}
		
		return travelsList;
	}

}
