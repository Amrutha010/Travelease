package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelease.models.Booking;

public interface BookingDAO extends JpaRepository<Booking, Integer>{

}
