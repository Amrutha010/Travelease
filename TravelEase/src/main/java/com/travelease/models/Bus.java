package com.travelease.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busID;
	@Pattern(regexp = "^[A-Z]\\w*$")
	@Size(min = 3,message = "type should be more then two letters")
	private String busType;
	@Pattern(regexp = "[0-9]{5}$",message = "Bus number should have only numbers")
	private String busNumber;
	@Max(value  = 34,message = "bus capacity is the 34 only")
	private Integer capacity;
	
	


	//relations part starting
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Route_Id")
	private Route route;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Travels_Id")
	private Travels travels;
	
	//relations part ending
	
	
	public Bus() {
		super();
	}

	public Bus(Integer busID, @NotBlank(message = "this field should not be empty") String busType,
			@Pattern(regexp = "[0-9]{5}$", message = "Bus number should have only numbers") String busNumber,
			@Max(value = 34, message = "bus capacity is the 34 only") Integer capacity, Route route, Travels travels) {
		super();
		this.busID = busID;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.route = route;
		this.travels = travels;
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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Travels getTravels() {
		return travels;
	}

	public void setTravels(Travels travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "Bus [busID=" + busID + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ ", route=" + route + ", travels=" + travels + "]";
	}


	
	
	
	
}
