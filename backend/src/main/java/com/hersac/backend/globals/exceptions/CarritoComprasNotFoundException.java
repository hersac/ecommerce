package com.hersac.backend.globals.exceptions;

import org.springframework.http.HttpStatus;

public class CarritoComprasNotFoundException extends MicroGlobalException {

	public CarritoComprasNotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

}
