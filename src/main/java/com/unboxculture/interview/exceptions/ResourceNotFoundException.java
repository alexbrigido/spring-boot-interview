package com.unboxculture.interview.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1433099144941689004L;
	
	private static final String msg = "Resource not found";
	
	public ResourceNotFoundException() {
		super(msg);
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
