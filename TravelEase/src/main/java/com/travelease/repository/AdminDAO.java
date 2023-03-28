package com.travelease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelease.models.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer>{

}
