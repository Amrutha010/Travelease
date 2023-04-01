package com.travelease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.BookingException;
import com.travelease.exception.CustomerException;
import com.travelease.exception.FeedbackException;
import com.travelease.exception.PackagesException;
import com.travelease.models.Feedback;
import com.travelease.models.FeedbackDTO;
import com.travelease.models.Packages;
import com.travelease.repository.FeedbackDAO;

@Service
public class FeedbackServicesImpl implements FeedbackServices{

	@Autowired
	private FeedbackDAO fDao;
	
	@Autowired
	private BookingService bServices;
	
	@Autowired
	private CustomerServices cServices;
	
	@Autowired
	private PackagesService pServices;

	@Override
	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException, PackagesException { //use feedbackDto
		
		Feedback newFeedback= new Feedback();
		newFeedback.setFeedback(feedback.getFeedback());
		newFeedback.setRating(feedback.getRating());
		newFeedback.setBooking(bServices.ViewBookingById(feedback.getBookingId()));
		newFeedback.setCustomer(bServices.ViewBookingById(feedback.getBookingId()).getCustomer());
		Packages p= pServices.getPackageById(feedback.getPackageId());
		
		newFeedback.setPackages(p);
		
		Feedback feedback2= fDao.save(newFeedback);
		
		List<Feedback> feedbacks= findFeedbackByPackageId(p.getPackageId());
		double sum=0;
		for (Feedback feedback21 : feedbacks) {
			sum+=feedback21.getRating();
		}
		double avg =sum/feedbacks.size();
		
		p.setPackageRating(avg);
		
		pServices.updatePackages(p);
		
		return feedback2;
		
	}

	@Override
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException {

		return fDao.findById(feedbackId)
				.orElseThrow(()-> 
				new FeedbackException("No feedback found with feedback Id:- "+feedbackId));
		
	}

	@Override
	public List<Feedback> findFeedbackByCustomerId(Integer customerId)throws CustomerException {
		
		return cServices.viewCustomer(customerId).getFeedbacks();
		
		
	}
	
	@Override
	public List<Feedback> findFeedbackByPackageId(Integer packageId) throws PackagesException{
		
		Packages mypackage=pServices.getPackageById(packageId);
		
		return fDao.findByPackages(mypackage);
		
	}
	
	

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		List <Feedback> feedbacks = fDao.findAll();
		
		if (feedbacks.size()==0) {
			throw new FeedbackException("No Feedbacks present");
		} else {
			return feedbacks;
		}
		
	}

}
