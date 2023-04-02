package com.travelease.models;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotBlank(message = "customerName cannot be null")
	private String customerName;
	
	@NotBlank(message = "customerpassword cannot be null")
	private String customerPassword;
	
	@NotBlank(message = "customeraddress cannot be null")
	private String address;
	
	@NotBlank(message = "customeremail cannot be null")
	@Email
	private String email;
	
	@NotBlank(message = "customermobile cannot be null")
	@Size(min = 10, max = 10)
	private String mobile;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	@JsonIgnore
	private List<Booking> bookingList = new ArrayList<Booking>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonIgnore
	private List<Feedback> feedbacks = new ArrayList<>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, @NotNull String customerName, @NotNull String customerPassword,
			@NotNull String address, @NotNull @Email String email, @NotNull @Size(min = 10, max = 10) String mobile,
			List<Booking> bookingList, List<Feedback> feedbacks) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.bookingList = bookingList;
		this.feedbacks = feedbacks;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
	
	
}
