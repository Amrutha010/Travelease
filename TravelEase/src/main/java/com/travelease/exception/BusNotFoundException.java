package com.travelease.exception;

public class BusNotFoundException extends Exception{

	public BusNotFoundException(String message) {
		super(message);
		
	}
	 
	public String toString() {
		return getMessage();
	}
	
}
