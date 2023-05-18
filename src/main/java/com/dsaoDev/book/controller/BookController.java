package com.dsaoDev.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsaoDev.book.dto.BookRequestDTO;
import com.dsaoDev.book.dto.BookResponseDTO;
import com.dsaoDev.book.entity.Book;
import com.dsaoDev.book.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping
	public ResponseEntity<BookResponseDTO> save(@RequestBody Book book) {
		return new ResponseEntity<BookResponseDTO>(bookService.save(book), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<BookResponseDTO>> findAll() {
		return ResponseEntity.ok(bookService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDTO> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<BookResponseDTO> update(@RequestBody BookRequestDTO bookRequestDTO,
			@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(bookService.update(bookRequestDTO, id));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(bookService.deleteById(id));
	}

}
