package com.travelease.models;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HotelAddress {

	@Pattern(regexp = "^[A-Z]{2}$")
	private String state;
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	private String city;
	
	private String landmark;
	
	@Pattern(regexp = "^\\d{6}$")
	private String pin;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	public HotelAddress(@Pattern(regexp = "^[A-Z]{2}$") String state, @Pattern(regexp = "^[A-Za-z\\s]+$") String city,
			String landmark, @Pattern(regexp = "^\\d{6}$") String pin) {
		super();
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.pin = pin;
	}
	public HotelAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, landmark, pin, state);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelAddress other = (HotelAddress) obj;
		return Objects.equals(city, other.city) && Objects.equals(landmark, other.landmark)
				&& Objects.equals(pin, other.pin) && Objects.equals(state, other.state);
	}
	@Override
	public String toString() {
		return "HotelAddress state=" + state + ", city=" + city + ", landmark=" + landmark + ", pin=" + pin + " ";
	}
	
	
}