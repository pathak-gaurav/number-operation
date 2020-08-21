package com.gauravpathak.exception;

public class NonNumericException extends RuntimeException {

	public NonNumericException() {
	}

	public NonNumericException(String message) {
		super(message);
	}

	public NonNumericException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonNumericException(Throwable cause) {
		super(cause);
	}

	public NonNumericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
