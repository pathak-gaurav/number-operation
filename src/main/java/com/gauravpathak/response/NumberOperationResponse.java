package com.gauravpathak.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberOperationResponse {

	private String status;
	private Results results;
}
