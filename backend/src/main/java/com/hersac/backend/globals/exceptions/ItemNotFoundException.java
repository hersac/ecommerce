package com.hersac.backend.globals.exceptions;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends MicroGlobalException {

	public ItemNotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

}
