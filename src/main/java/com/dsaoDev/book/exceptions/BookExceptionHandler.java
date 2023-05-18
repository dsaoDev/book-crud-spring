package com.dsaoDev.book.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dsaoDev.book.exceptions.error.ErrorDescription;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BookExceptionHandler {

	// Tratamento de erro settando a toda descricao para a Exception(x)

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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	
	  @ExceptionHandler(SQLIntegrityConstraintViolationException.class) public
	  ResponseEntity<ErrorDescription>
	  entityNotFoundTreatment(SQLIntegrityConstraintViolationException ex,
	  HttpServletRequest request) { ErrorDescription erro = new ErrorDescription();
	  erro.setTimestamp(Instant.now());
	  erro.setStatus(HttpStatus.CONFLICT.value());
	  erro.setError("Constraint error");
	  erro.setMessage("the ISBN you typed is already taken");
	  erro.setPath(request.getRequestURI()); return
	  ResponseEntity.status(HttpStatus.CONFLICT).body(erro); }
	 
}
