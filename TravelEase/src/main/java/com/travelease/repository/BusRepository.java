package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{

}
