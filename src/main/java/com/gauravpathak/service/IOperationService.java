package com.gauravpathak.service;

import com.gauravpathak.request.NumberRequest;
import com.gauravpathak.response.NumberOperationResponse;

public interface IOperationService {

	NumberOperationResponse operationService(NumberRequest numberRequest);
}
