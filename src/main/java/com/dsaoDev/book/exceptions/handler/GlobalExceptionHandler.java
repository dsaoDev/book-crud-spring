package com.dsaoDev.book.exceptions.handler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsaoDev.book.exceptions.BookNotFoundException;
import com.dsaoDev.book.exceptions.EmptyListException;
import com.dsaoDev.book.exceptions.error.ErrorDescription;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

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


		// Validation handler
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
			Map<String, String> errorMap = new HashMap<>();

			ex.getBindingResult().getFieldErrors().forEach(error -> {
				errorMap.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		}

		@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
		public ResponseEntity<ErrorDescription> entityNotFoundTreatment(SQLIntegrityConstraintViolationException ex,
				HttpServletRequest request) {
			ErrorDescription erro = new ErrorDescription();
			erro.setTimestamp(Instant.now());
			erro.setStatus(HttpStatus.CONFLICT.value());
			erro.setError("Constraint error");
			erro.setMessage("the ISBN you typed is already taken");
			erro.setPath(request.getRequestURI());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		}

	}
