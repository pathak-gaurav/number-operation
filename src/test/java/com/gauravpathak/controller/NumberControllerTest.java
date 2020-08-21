package com.gauravpathak.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gauravpathak.request.NumberRequest;
import com.gauravpathak.response.NumberOperationResponse;
import com.gauravpathak.service.IOperationService;
import com.gauravpathak.utils.TestMockUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTest {

	@Mock
	IOperationService service;

	@InjectMocks
	NumberController numberController;

	@Test
	public void testNumberOperation() throws Exception {
		TestMockUtil util = new TestMockUtil();
		NumberRequest numberRequest = util.getMockResponseClass("numberRequest.json", NumberRequest.class);
		NumberOperationResponse response = util.getMockResponseClass("numberResponse.json", NumberOperationResponse.class);
		Mockito.when(service.operationService(numberRequest)).thenReturn(response);
		ResponseEntity<Object> responseEntity = numberController.numberOperation(numberRequest);
		Assert.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}

}
