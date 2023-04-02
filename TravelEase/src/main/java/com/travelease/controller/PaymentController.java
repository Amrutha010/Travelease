package com.travelease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelease.exception.*;
import com.travelease.models.Payment;
import com.travelease.models.PaymentDTO;
import com.travelease.models.Session;
import com.travelease.models.UserType;
import com.travelease.service.PaymentService;
import com.travelease.service.SessionServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	SessionServices sessionService;
	
	
	@PostMapping("/makePayment")
	public ResponseEntity<Payment> makePayment(@Valid @RequestBody PaymentDTO pDto, @RequestParam("sessionKey") String sessionKey) throws PaymentException, AdminException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserType() == UserType.CUSTOMER) {
		return new ResponseEntity<Payment>(paymentService.makePayment(pDto, session), HttpStatus.OK);
	}
	throw new AdminException("Please login with the correct credentials");
	}

	@GetMapping("viewAllPayments")
	public ResponseEntity<List<Payment>> viewAllPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.viewAllPayments(), HttpStatus.OK);
	}

}