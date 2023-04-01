package com.travelease.service;

import java.util.List;

import com.travelease.exception.BookingException;
import com.travelease.models.Booking;
import com.travelease.models.BookingDTO;
import com.travelease.models.Session;


public interface BookingService {
	public Booking makeBooking(BookingDTO bookingDTO, Session session) throws BookingException;

	public Booking ViewBookingById(Integer bookingId) throws BookingException;

	public List<Booking> viewAllBookings() throws BookingException;

	public Booking cancelBookingById(Integer bookingId) throws BookingException;

	
}
