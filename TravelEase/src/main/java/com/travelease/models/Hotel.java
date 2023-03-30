package com.travelease.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
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
	

	@NotNull(message = "Please mention Hotel Address")
	@Embedded
	private HotelAddress hotelAddress;
	
	@NotNull
	private double Rent;
	
	@NotNull
	private String Status;

	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Packages> pSet = new HashSet<Packages>();

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

	public HotelAddress getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(HotelAddress hotelAddress) {
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

	public Set<Packages> getpSet() {
		return pSet;
	}

	public void setpSet(Set<Packages> pSet) {
		this.pSet = pSet;
	}

	public Hotel(Integer hotel_Id, @NotNull String hotelName, @NotNull String hotelType,
			@NotNull String hotelDescription,
			@NotNull(message = "Please mention Hotel Address") HotelAddress hotelAddress, @NotNull double rent,
			@NotNull String status, Set<Packages> pSet) {
		super();
		this.hotel_Id = hotel_Id;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.hotelAddress = hotelAddress;
		Rent = rent;
		Status = status;
		this.pSet = pSet;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hotel [hotel_Id=" + hotel_Id + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", hotelAddress=" + hotelAddress + ", Rent=" + Rent
				+ ", Status=" + Status + ", pSet=" + pSet + "]";
	}
	
	

	
	
	
	
}
