package com.gauravpathak.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gauravpathak.request.NumberRequest;
import com.gauravpathak.service.IOperationService;

@RestController
@RequestMapping(value = "${app.prefix}")
public class NumberController {

	private static Logger logger = LoggerFactory.getLogger(NumberController.class);

	@Autowired
	private IOperationService service;

	@RequestMapping(value = "/numberoperations", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> numberOperation(@RequestBody NumberRequest numberRequest)
			throws Exception {
		Object res = service.operationService(numberRequest);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}