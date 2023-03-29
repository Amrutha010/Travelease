package com.travelease.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	@NotBlank(message = "this field should not be empty")
	private String routeFrom;
	@NotBlank(message = "this field should not be empty")
	private String routeTo;
	@Future
//	@DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
	@JsonFormat(pattern = "dd MMM uuuu hh:mm a")
	private LocalDateTime departureTime;
	@Future
	@JsonFormat(pattern = "dd MMM uuuu hh:mm a")
	private LocalDateTime arrivalTime;
	@Future
	@JsonFormat(pattern = "dd MMM uuuu")
	private LocalDate doj;
	@NotBlank(message = "this field should not be empty")
	private String pickUpPoint;
	private Double fare;
	
	
	public Route() {
		super();
	}


	

	public Route(Integer routeId, String routeFrom, String routeTo, LocalDateTime departureTime,
			LocalDateTime arrivalTime, LocalDate doj, String pickUpPoint, Double fare) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickUpPoint = pickUpPoint;
		this.fare = fare;
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


	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj + ", pickUpPoint=" + pickUpPoint
				+ ", fare=" + fare + "]";
	}
	
	
	
}
