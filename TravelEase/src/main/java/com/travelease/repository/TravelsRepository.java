package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Travels;

@Repository
public interface TravelsRepository extends JpaRepository<Travels, Integer>{

}
