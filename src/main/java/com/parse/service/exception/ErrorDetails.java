package com.parse.service.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

	private String details;
	private String expectedError;
	private String actualError;
	private Date timestamp;

	public ErrorDetails(Date timestamp, String expectedError, String actualError, String details) {
		super();
		this.timestamp = timestamp;
		this.actualError = actualError;
		this.details = details;
		this.expectedError = expectedError;
	}
}
