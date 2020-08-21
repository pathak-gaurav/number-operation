package com.gauravpathak.constants;

public enum ServiceResponseCodes {

	VALIDATION_BAD_REQUEST("NUMERIC_FAILURE_ERR", "Numeric input expected, received invalid numbers in input");

	private String status;
	private String msg;

	private ServiceResponseCodes(String status, String msg) {
		this.status = status;
		this.msg = msg;

	}

	public String getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

}