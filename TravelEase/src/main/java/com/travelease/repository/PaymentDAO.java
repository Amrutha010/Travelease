package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelease.models.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Integer>{

}
