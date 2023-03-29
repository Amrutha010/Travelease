package com.travelease.exception;

public class RouteNotFoundException extends Exception{

	public RouteNotFoundException(String message) {
		super(message);
	}
	
	public String toString() {
		return getMessage();
	}
}
