package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	
	public Customer findByEmail(String email);
}

