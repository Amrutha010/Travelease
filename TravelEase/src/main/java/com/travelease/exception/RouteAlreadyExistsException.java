package com.travelease.exception;

public class RouteAlreadyExistsException extends Exception{

	public RouteAlreadyExistsException(String message) {
		super(message);
	}
	
	public String toString() {
		return getMessage();
	}
}
