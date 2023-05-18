package com.dsaoDev.book.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsaoDev.book.exceptions.error.ErrorDescription;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BookExceptionHandler {
	
	//Tratamento de erro settando a toda descricao para a Exception(x)
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDescription> entityNotFoundTreatment(BookNotFoundException ex,
			HttpServletRequest request) {
		ErrorDescription erro = new ErrorDescription();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setError("Entity not found");
		erro.setMessage(ex.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ErrorDescription> emptyListTreatment(EmptyListException elException,
			HttpServletRequest request) {
		ErrorDescription erro = new ErrorDescription();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setError("Empty list");
		erro.setMessage(elException.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	
	
}
