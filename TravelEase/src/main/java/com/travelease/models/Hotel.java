package com.travelease.models;

import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotel_Id;
	@NotNull
	private String hotelName;
	
	@NotNull
	private String hotelType;
	@NotNull
	private String hotelDescription;
	@NotNull
	private String hotelAddress;
	
	@NotNull
	private double Rent;
	
	@NotNull
	private String Status;

	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	@JsonIgnore
	private Packages packages;

	public Integer getHotel_Id() {
		return hotel_Id;
	}

	public void setHotel_Id(Integer hotel_Id) {
		this.hotel_Id = hotel_Id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public double getRent() {
		return Rent;
	}

	public void setRent(double rent) {
		Rent = rent;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public Hotel(Integer hotel_Id, @NotNull String hotelName, @NotNull String hotelType,
			@NotNull String hotelDescription, @NotNull String hotelAddress, @NotNull double rent,
			@NotNull String status, Packages packages) {
		super();
		this.hotel_Id = hotel_Id;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.hotelAddress = hotelAddress;
		Rent = rent;
		Status = status;
		this.packages = packages;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(Rent, Status, hotelAddress, hotelDescription, hotelName, hotelType, hotel_Id, packages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Double.doubleToLongBits(Rent) == Double.doubleToLongBits(other.Rent)
				&& Objects.equals(Status, other.Status) && Objects.equals(hotelAddress, other.hotelAddress)
				&& Objects.equals(hotelDescription, other.hotelDescription)
				&& Objects.equals(hotelName, other.hotelName) && Objects.equals(hotelType, other.hotelType)
				&& Objects.equals(hotel_Id, other.hotel_Id) && Objects.equals(packages, other.packages);
	}

	@Override
	public String toString() {
		return "Hotel [hotel_Id=" + hotel_Id + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", hotelAddress=" + hotelAddress + ", Rent=" + Rent
				+ ", Status=" + Status + ", packages=" + packages + "]";
	}
	
	
	
}
