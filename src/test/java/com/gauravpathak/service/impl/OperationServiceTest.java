package com.gauravpathak.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gauravpathak.request.NumberRequest;
import com.gauravpathak.response.NumberOperationResponse;
import com.gauravpathak.utils.TestMockUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OperationServiceTest {

	@InjectMocks
	OperationService operationService;

	@Test
	public void testOperationService() throws Exception {
		TestMockUtil util = new TestMockUtil();
		NumberRequest numberRequest = util.getMockResponseClass("numberRequest.json", NumberRequest.class);
		NumberOperationResponse operationResponse = operationService.operationService(numberRequest);
		Assert.assertEquals("SUCCESS", operationResponse.getStatus());
	}
}
