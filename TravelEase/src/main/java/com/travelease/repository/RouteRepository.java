package com.travelease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Hotel;
import com.travelease.models.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{
	
	
	
}
