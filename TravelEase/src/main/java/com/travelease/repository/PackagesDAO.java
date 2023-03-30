package com.travelease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Packages;

@Repository
public interface PackagesDAO extends JpaRepository<Packages, Integer> {

//	void delete(Optional<Packages> opt);

	
}