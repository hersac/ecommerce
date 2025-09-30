package com.hersac.backend.globals.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNoFoundException extends MicroGlobalException {

	public UsuarioNoFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

}
