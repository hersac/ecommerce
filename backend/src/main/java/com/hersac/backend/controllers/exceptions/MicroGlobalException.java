package com.hersac.backend.controllers.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroGlobalException extends RuntimeException {

	private HttpStatus httpStatusCode;

	private String message;

	public MicroGlobalException(String message) {
		super(message);
	}

}
