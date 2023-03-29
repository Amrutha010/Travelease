package com.travelease.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busID;
	@NotBlank
	@NotNull
	private String busType;
	@NotBlank
	@NotNull
	@Pattern(regexp = "[0-9]{5}$",message = "Bus number should have only numbers")
	private String busNumber;
	@NotBlank
	@NotNull
	@Size(max = 34,message = "bus capacity is the 34 only")
	private Integer capacity;
	
	
	// relationship variables , getter/Setters/Conrtuctor are yet be injected

	
	
	public Bus() {
		super();
	}


	public Bus(Integer busID, String busType, String busNumber, Integer capacity) {
		super();
		this.busID = busID;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
	}


	public Integer getBusID() {
		return busID;
	}


	public void setBusID(Integer busID) {
		this.busID = busID;
	}


	public String getBusType() {
		return busType;
	}


	public void setBusType(String busType) {
		this.busType = busType;
	}


	public String getBusNumber() {
		return busNumber;
	}


	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Bus [busID=" + busID + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ "]";
	}
	
	
	
	
}
