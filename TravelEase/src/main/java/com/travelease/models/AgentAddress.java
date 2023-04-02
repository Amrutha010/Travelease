package com.travelease.models;


import jakarta.validation.constraints.Pattern;

public class AgentAddress {

	
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	private String city;
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	private String state;
	@Pattern(regexp = "^\\d{6}$")
	private String pincode;
	
	
	
	public AgentAddress() {
		super();
	}



	public AgentAddress(String city, String state, String pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "AgentAddress [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
