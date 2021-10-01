package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "Recurso no encontrado";

	private static final long serialVersionUID = -8279681828323552487L;

	public NotFoundException(String cause) {
		super(cause);
	}

	public NotFoundException() {
		super(DEFAULT_MESSAGE);
	}

}
