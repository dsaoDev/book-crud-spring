package com.dsaoDev.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsaoDev.book.dto.BookDTO;
import com.dsaoDev.book.entity.Book;
import com.dsaoDev.book.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookDTO> save (@RequestBody Book book){
			BookDTO bookDTO;
			return new ResponseEntity<BookDTO>(bookDTO = bookService.save(book),HttpStatus.CREATED);
	}

}
