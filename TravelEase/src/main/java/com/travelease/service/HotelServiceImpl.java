package com.travelease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.Exceptions.HotelException;
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
	public Hotel getHotelById(Integer id) throws HotelException {
		return hotelDAO.findById(id).
				orElseThrow(() -> new HotelException("Hotel Not Found With Hotel ID :" + id));
	
	}


	@Override
	public List<Hotel> AllHotels() {
		return hotelDAO.findAll();
	}

	@Override
	public Hotel deleteHotel(Integer id)throws HotelException{
		Hotel htl = hotelDAO.findById(id).get();
		
		if(htl ==null)
			throw new HotelException("Hotel Not Found");
			hotelDAO.delete(htl);
		
		return htl;
	}

}
