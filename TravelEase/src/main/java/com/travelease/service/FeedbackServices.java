package com.travelease.service;

import java.util.List;

import com.travelease.exception.BookingException;
import com.travelease.exception.CustomerException;
import com.travelease.exception.FeedbackException;
import com.travelease.exception.PackagesException;
import com.travelease.models.Feedback;
import com.travelease.models.FeedbackDTO;

public interface FeedbackServices {

	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException, PackagesException;
	
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public List<Feedback> findFeedbackByCustomerId(Integer customerId) throws CustomerException;
	
	public List<Feedback> viewAllFeedback() throws FeedbackException;

	List<Feedback> findFeedbackByPackageId(Integer packageId) throws PackagesException;
	
}
