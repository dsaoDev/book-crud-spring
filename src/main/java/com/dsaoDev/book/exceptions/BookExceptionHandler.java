package com.dsaoDev.book.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsaoDev.book.exceptions.error.StandardError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BookExceptionHandler {
	
	@ExceptionHandler(DataToLargeException.class)
	public ResponseEntity<StandardError> dataToLarge(DataToLargeException e, HttpServletRequest request){
		StandardError erro = new StandardError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.PAYLOAD_TOO_LARGE.value());
		erro.setError("Data too large");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(erro);
	}
}
