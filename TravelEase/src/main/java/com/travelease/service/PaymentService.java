package com.travelease.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.travelease.exception.PaymentException;
import com.travelease.models.Payment;
import com.travelease.models.PaymentDTO;
import com.travelease.models.Session;

@Repository
public interface PaymentService {

	public Payment makePayment(PaymentDTO payment, Session session) throws PaymentException;
	
	public List<Payment> viewAllPayments();
}