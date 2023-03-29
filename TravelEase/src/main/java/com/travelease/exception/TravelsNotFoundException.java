package com.travelease.exception;

public class TravelsNotFoundException extends Exception{

	public TravelsNotFoundException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return getMessage();
	}
}
