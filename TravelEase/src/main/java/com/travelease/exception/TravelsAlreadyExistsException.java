package com.travelease.exception;

public class TravelsAlreadyExistsException extends Exception{

	public TravelsAlreadyExistsException(String message) {
		super(message);
	}
	
	public String toString() {
		return getMessage();
	}
}
