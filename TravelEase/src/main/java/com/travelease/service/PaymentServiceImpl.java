package com.travelease.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelease.Exceptions.PaymentException;
import com.travelease.models.Payment;

import jakarta.websocket.Session;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public Payment makePayment(Payment payment, Session session) throws PaymentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> viewAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

}
