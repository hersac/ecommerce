package com.hersac.backend.globals.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends MicroGlobalException {
    public ClienteNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}
