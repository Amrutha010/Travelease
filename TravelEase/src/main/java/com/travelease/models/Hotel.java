package com.travelease.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	private String hotelName;
	
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	private String hotelType;
	
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	private String hotelDescription;
	

	
	@Embedded
	private HotelAddress hotelAddress;
	
	@Min(value=1000)
	private Double Rent;
	
	
	private String Status;


	public Integer getHotelId() {
		return hotelId;
	}


	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
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


	public Double getRent() {
		return Rent;
	}


	public void setRent(Double rent) {
		Rent = rent;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public Hotel(Integer hotelId, @Pattern(regexp = "^[A-Za-z\\s]+$") String hotelName,
			@Pattern(regexp = "^[A-Za-z\\s]+$") String hotelType,
			@Pattern(regexp = "^[A-Za-z\\s]+$") String hotelDescription, HotelAddress hotelAddress,
			@Min(1000) Double rent, String status) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.hotelAddress = hotelAddress;
		Rent = rent;
		Status = status;
	}


	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Set<Packages> pSet = new HashSet<Packages>();

//	@Override
//	public String toString() {
//		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType
//				+ ", hotelDescription=" + hotelDescription + ", hotelAddress=" + hotelAddress + ", Rent=" + Rent
//				+ ", Status=" + Status + ", pSet=" + pSet + "]";
//	}

	
	
	
}
