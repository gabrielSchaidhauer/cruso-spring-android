package com.ogabriel.minicurso.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerHandling(NullPointerException npe) {
		return new ResponseEntity<>("Erro de NullPointer", HttpStatus.BAD_REQUEST);
	}
}
