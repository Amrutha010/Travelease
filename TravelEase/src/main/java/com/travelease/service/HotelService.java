package com.travelease.service;

import java.util.List;
import java.util.Optional;

import com.travelease.models.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);

	public Optional<Hotel> getHotelById(Integer id);
	
	public Optional<Hotel> deleteHotel(Integer id);

	public List<Hotel> AllHotels();

	
	
}
