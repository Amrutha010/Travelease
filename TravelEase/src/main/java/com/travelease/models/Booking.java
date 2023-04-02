package com.travelease.models;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@NotBlank(message = "description cannot be null")
	private String description;
	@NotBlank(message = "bookingTitle cannot be null")
	private String bookingTitle;
	
	private LocalDateTime bookingDate;

	private Double totalCost;


	private BookingStatus bookingStatus = BookingStatus.PAYMENT_PENDING;
	
	@NotNull(message = "Number Of Person Cannot Be Null")
	@Min(value = 1, message = "Number Of Person Should Be Atleast 1")
	private Integer noOfPersons;	


	@ManyToOne
	@JoinColumn(name = "customerId" )
	@NotNull(message = "customer cannot be null")
	@JsonIgnore
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "packageId")
	@NotNull(message = "package cannot be null")
	@JsonIgnore
	private Packages packages;

	@OneToOne
	@PrimaryKeyJoinColumn
	@NotNull
	@JsonIgnore
	private TicketDetails ticket;

	public Booking() {
	}

	
	
	
	
	public Booking(int bookingId, @NotBlank(message = "description cannot be null") String description,
			@NotBlank(message = "bookingTitle cannot be null") String bookingTitle, LocalDateTime bookingDate,
			Double totalCost, BookingStatus bookingStatus,
			@NotNull(message = "Number Of Person Cannot Be Null") @Min(value = 1, message = "Number Of Person Should Be Atleast 1") Integer noOfPersons,
			@NotNull(message = "customer cannot be null") Customer customer,
			@NotNull(message = "package cannot be null") Packages packages, @NotNull TicketDetails ticket) {
		super();
		this.bookingId = bookingId;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
		this.bookingStatus = bookingStatus;
		this.noOfPersons = noOfPersons;
		this.customer = customer;
		this.packages = packages;
		this.ticket = ticket;
	}





	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public TicketDetails getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}

