package com.travelease.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.travelease.Exceptions.PaymentException;
import com.travelease.models.Payment;

import jakarta.websocket.Session;

@Repository
public interface PaymentService {

	public Payment makePayment(Payment payment, Session session) throws PaymentException;
	
	public List<Payment> viewAllPayments();
}