package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.HotelException;
import com.travelease.models.Hotel;
import com.travelease.service.HotelService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class HotelController {

	@Autowired
	HotelService hs;
	
	
	
	@PostMapping("/Hotel")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel pack){
		Hotel h = hs.createHotel(pack);
		return new ResponseEntity<>(h,HttpStatus.CREATED);
	}
			
	@GetMapping("/Hotel/{id}")
	public ResponseEntity<Hotel> searchHotelById(@PathVariable("id") Integer id) throws HotelException{
	
		Hotel h = hs.getHotelById(id);
		return new ResponseEntity<>(h,HttpStatus.FOUND);
	
	}
	@GetMapping("/AllHotels")
	public ResponseEntity<List<Hotel>> viewAllHotels() throws HotelException{
		List<Hotel> list = hs.AllHotels();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	
	@DeleteMapping("/Hotel/{id}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") Integer id) throws HotelException{
		Hotel h = hs.deleteHotel(id);
		return new ResponseEntity<>(h,HttpStatus.OK);
	}
	
	
	
	
	
}
