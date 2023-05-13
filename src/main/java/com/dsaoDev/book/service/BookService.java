package com.dsaoDev.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaoDev.book.dto.BookDTO;
import com.dsaoDev.book.entity.Book;
import com.dsaoDev.book.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BookDTO save(Book book) {
			bookRepository.save(book);
			return new BookDTO(book);
	}
}
