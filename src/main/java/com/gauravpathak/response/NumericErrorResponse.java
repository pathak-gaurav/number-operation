package com.gauravpathak.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumericErrorResponse {
	
	private String status;
	private String msg;

}
