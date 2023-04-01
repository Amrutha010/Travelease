package com.travelease.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Entity
public class Packages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageId;

	@NotNull
	@Pattern(regexp = "^[A-Za-z]$")
	@Size(min = 4,message = "Package Name sholud be more than 4 letters and Alphabest")
	
	private String packageName;

	@NotNull
	private String packageDescription;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "routeId")
	private Route routeId;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotelId")
	private Hotel hotel;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "busId")
	private Bus bus;
	
	
	@NotNull
	@Min(value=5000)
	private Double packageCost;

	
	private double packageRating;

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public Route getRouteId() {
		return routeId;
	}

	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}

	

	public Packages(Integer packageId, @NotNull String packageName, @NotNull String packageDescription,
			@NotNull Route routeId, @NotNull Hotel hotel, @NotNull Bus bus, @NotNull @Min(5000) Double packageCost,
			Integer getHotelId) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.routeId = routeId;
		this.hotel = hotel;
		this.bus = bus;
		this.packageCost = packageCost;
	
	}

	public Packages() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "Packages [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", routeId=" + routeId + ", hotel=" + hotel + ", bus=" + bus + ", packageCost="
				+ packageCost + "]";
	}

	public Integer getHotelId() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getPackageRating() {
		return packageRating;
	}

	public void setPackageRating(double packageRating) {
		this.packageRating = packageRating;
	}


	
	
}
