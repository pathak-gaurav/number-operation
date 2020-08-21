package com.gauravpathak.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {

	private Double sum;
	private String average;
	private List<Double> greaterThanAverage;

}
