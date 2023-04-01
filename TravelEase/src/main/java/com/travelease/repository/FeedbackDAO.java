package com.travelease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Feedback;
import com.travelease.models.Packages;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback,Integer>{

	public List<Feedback> findByPackages(Packages packages);
	
}
