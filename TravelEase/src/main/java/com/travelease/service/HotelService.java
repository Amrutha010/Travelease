package com.travelease.service;

import java.util.List;
import java.util.Optional;

import com.travelease.Exceptions.HotelException;
import com.travelease.models.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);

	public Hotel getHotelById(Integer id)throws HotelException ;
	
	public Optional<Hotel> deleteHotel(Integer id)throws HotelException;

	public List<Hotel> AllHotels()throws HotelException;

	
	
}
