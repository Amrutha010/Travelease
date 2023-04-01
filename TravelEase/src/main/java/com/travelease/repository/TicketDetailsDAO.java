package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.travelease.models.TicketDetails;

@Repository
public interface TicketDetailsDAO extends JpaRepository<TicketDetails, Integer>{

//	void save(TicketDetails td);

}
