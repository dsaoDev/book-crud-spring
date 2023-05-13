package com.dsaoDev.book.exceptions;

public class DataToLargeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataToLargeException(String message) {
		super(message);
	}

}
