package com.travelease.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Pattern;


@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	@Pattern(regexp = "^[A-Z]\\w*$")
	private String routeFrom;
	@Pattern(regexp = "^[A-Z]\\w*$")
	private String routeTo;
	@Future
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime departureTime;
	@Future
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime arrivalTime;
	@Future
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate doj;
	@Pattern(regexp = "^[A-Z]\\w*$")
	private String pickUpPoint;
	private Double fare;
	
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany( mappedBy = "route" )
	private List<Bus> bus = new ArrayList<>();
	
	
	
	public Route() {
		super();
	}


	public Route(Integer routeId, @Pattern(regexp = "^[A-Z]\\w*$") String routeFrom,
			@Pattern(regexp = "^[A-Z]\\w*$") String routeTo, @Future LocalDateTime departureTime,
			@Future LocalDateTime arrivalTime, @Future LocalDate doj,
			@Pattern(regexp = "^[A-Z]\\w*$") String pickUpPoint, Double fare, List<Bus> bus) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickUpPoint = pickUpPoint;
		this.fare = fare;
		this.bus = bus;
	}


	public Integer getRouteId() {
		return routeId;
	}


	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}


	public String getRouteFrom() {
		return routeFrom;
	}


	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}


	public String getRouteTo() {
		return routeTo;
	}


	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}


	public LocalDateTime getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}


	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public LocalDate getDoj() {
		return doj;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}


	public String getPickUpPoint() {
		return pickUpPoint;
	}


	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}


	public Double getFare() {
		return fare;
	}


	public void setFare(Double fare) {
		this.fare = fare;
	}


	public List<Bus> getBus() {
		return bus;
	}


	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}


	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj + ", pickUpPoint=" + pickUpPoint
				+ ", fare=" + fare + ", bus=" + bus + "]";
	}


	

	
}
