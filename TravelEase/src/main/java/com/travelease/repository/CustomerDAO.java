package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelease.models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
