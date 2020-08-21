package com.gauravpathak.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gauravpathak.constants.NumberOperationServiceConstants;
import com.gauravpathak.constants.ServiceResponseCodes;
import com.gauravpathak.exception.NonNumericException;
import com.gauravpathak.response.NumericErrorResponse;

@ControllerAdvice
public class BaseController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		NumericErrorResponse numericErrorResponse = new NumericErrorResponse(NumberOperationServiceConstants.FAILED,
				ServiceResponseCodes.VALIDATION_BAD_REQUEST.getMsg());
		return new ResponseEntity<>(numericErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NonNumericException.class)
    public final ResponseEntity<Object> nonNumericHandleException(Exception ex, WebRequest request) throws Exception {
		NumericErrorResponse numericErrorResponse = new NumericErrorResponse(NumberOperationServiceConstants.FAILED,
				ServiceResponseCodes.VALIDATION_BAD_REQUEST.getMsg());
        return new ResponseEntity<>(numericErrorResponse, HttpStatus.NOT_FOUND);
    }

}
