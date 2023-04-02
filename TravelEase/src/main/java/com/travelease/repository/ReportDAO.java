package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Report;

@Repository
public interface ReportDAO extends JpaRepository<Report, Integer> {

}
