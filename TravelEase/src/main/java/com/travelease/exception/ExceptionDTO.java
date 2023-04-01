package com.travelease.exception;

import java.time.LocalDateTime;

public class ExceptionDTO {
	
	private LocalDateTime dateAndTime;
	
	private String message;
	
	private String desc;

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	

}

