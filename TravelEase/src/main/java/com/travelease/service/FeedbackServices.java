package com.travelease.service;

import java.util.List;

import com.travelease.Exceptions.CustomerException;
import com.travelease.Exceptions.FeedbackException;
import com.travelease.models.Feedback;
import com.travelease.models.FeedbackDTO;

public interface FeedbackServices {

	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException, PackageException;
	
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public List<Feedback> findFeedbackByCustomerId(Integer customerId) throws CustomerException;
	
	public List<Feedback> viewAllFeedback() throws FeedbackException;

	List<Feedback> findFeedbackByPackageId(Integer packageId) throws PackageException;
	
}
