package com.travelease.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;



@Entity
public class Packages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageId;

	@NotNull
	private String packageName;

	@NotNull
	private String packageDescription;
	
//	private Integer routeId;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_Id")
	private Hotel hotel;
	
//	private Bus bus;
	
	
	@NotNull
	private Double packageCost;
	
//	private PaymentDetails payment ;

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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}

//	public PaymentDetails getPayment() {
//		return payment;
//	}
//
//	public void setPayment(PaymentDetails payment) {
//		this.payment = payment;
//	}

	public Packages(Integer packageId, @NotNull String packageName, @NotNull String packageDescription,
			@NotNull Hotel hotel, @NotNull Double packageCost) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.hotel = hotel;
		this.packageCost = packageCost;
		//this.payment = payment;
	}

	@Override
	public String toString() {
		return "Packages [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", hotel=" + hotel + ", packageCost=" + packageCost + ", payment=" 
				+ "]";
	}

	public Packages() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
