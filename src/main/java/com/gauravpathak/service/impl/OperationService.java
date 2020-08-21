package com.gauravpathak.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gauravpathak.constants.NumberOperationServiceConstants;
import com.gauravpathak.exception.NonNumericException;
import com.gauravpathak.request.NumberRequest;
import com.gauravpathak.response.NumberOperationResponse;
import com.gauravpathak.response.Results;
import com.gauravpathak.service.IOperationService;

@Service
public class OperationService implements IOperationService {

	private static final Logger logger = LoggerFactory.getLogger(OperationService.class);

	@Override
	public NumberOperationResponse operationService(NumberRequest numberRequest) {
		numberRequest.getInput().forEach(num -> {
			if (StringUtils.isEmpty(num)) {
				throw new NonNumericException();
			}
		});

		Double sum = sumOfNumbers(numberRequest);
		Long count = (long) numberRequest.getInput().size();
		Double average = sum / count;
		List<Double> aboveAverageList = aboveAverage(average, numberRequest);
		return createNumberOperationResponse(sum, average, aboveAverageList);
	}

	private NumberOperationResponse createNumberOperationResponse(Double sum, Double average,
																  List<Double> aboveAverageList) {
		NumberOperationResponse numberResponse = new NumberOperationResponse();
		Results result = new Results();
		DecimalFormat df = new DecimalFormat("#.##");
		result.setAverage(df.format(average));
		result.setGreaterThanAverage(aboveAverageList);
		result.setSum(sum);
		numberResponse.setStatus(NumberOperationServiceConstants.SUCCESS);
		numberResponse.setResults(result);
		return numberResponse;
	}

	private List<Double> aboveAverage(Double average, NumberRequest numberRequest) {
		List<Double> inputNumber = numberRequest.getInput();
		return inputNumber.stream().filter(number -> number > average).collect(Collectors.toList());
	}

	private Double sumOfNumbers(NumberRequest numberRequest) {
		return numberRequest.getInput().stream().mapToDouble(Double::doubleValue).sum();
	}
}
