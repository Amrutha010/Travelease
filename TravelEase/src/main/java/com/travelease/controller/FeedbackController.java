package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelease.exception.BookingException;
import com.travelease.exception.CustomerException;
import com.travelease.exception.FeedbackException;
import com.travelease.exception.PackagesException;
import com.travelease.exception.SessionException;
import com.travelease.models.Feedback;
import com.travelease.models.FeedbackDTO;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.service.FeedbackServices;
import com.travelease.service.SessionServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired
	private FeedbackServices fServices;
	@Autowired
	private SessionServices sServices;
	
	@PostMapping("/addfeedback")
	public ResponseEntity<Feedback> addfeedback(@Valid @RequestBody FeedbackDTO feedback, @RequestParam("sessionKey")String sessionKey) throws FeedbackException, BookingException, PackagesException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.CUSTOMER) {
			return new ResponseEntity<Feedback>(fServices.addFeedback(feedback),HttpStatus.OK);
		}
		throw new FeedbackException("Please login with the correct credentials");
		
	}
	
	@GetMapping("/feedbackbyfeedbackid/{id}")
	public ResponseEntity<Feedback> findFeedbackByFeedbackId(@PathVariable("id") Integer id, @RequestParam("sessionKey")String sessionKey) throws FeedbackException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			return new ResponseEntity<>(fServices.findFeedbackByFeedbackId(id), HttpStatus.OK);
		}
		throw new FeedbackException("Please login with the correct credentials");
	}
	
	@GetMapping("/feedbackbycustomerid/{id}")
	public ResponseEntity<List<Feedback>> findFeedbackByCustomerId(@PathVariable("id") Integer id, @RequestParam("sessionKey")String sessionKey) throws FeedbackException, CustomerException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			return new ResponseEntity<List<Feedback>>(fServices.findFeedbackByCustomerId(id), HttpStatus.OK);
		}
		throw new FeedbackException("Please login with the correct credentials");
		
	}
	
	@GetMapping("/feedbackbypackageid/{id}")
	public ResponseEntity<List<Feedback>> findFeedbackByPackageId(@PathVariable("id") Integer id) throws FeedbackException, PackagesException, SessionException{

		return new ResponseEntity<List<Feedback>>(fServices.findFeedbackByPackageId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/viewallfeedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException{
		
		return new ResponseEntity<List<Feedback>>(fServices.viewAllFeedback(),HttpStatus.OK);
		
	}
	
	

}
