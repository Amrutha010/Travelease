package com.travelease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.models.Hotel;
import com.travelease.repository.HotelDAO;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDAO hotelDAO;
	
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelDAO.save(hotel);
	}

	@Override
	public Optional<Hotel> getHotelById(Integer id) {
		return hotelDAO.findById(id);
	}


	@Override
	public List<Hotel> AllHotels() {
		return hotelDAO.findAll();
	}

	@Override
	public Optional<Hotel> deleteHotel(Integer id) {
		Optional<Hotel> opt = hotelDAO.findById(id);
		
		if(opt.isEmpty()) ;
			
			Hotel htl= opt.get();
			hotelDAO.delete(opt);
		
		return opt;
	}

}
