package com.dsaoDev.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaoDev.book.dto.BookDTO;
import com.dsaoDev.book.entity.Book;
import com.dsaoDev.book.repository.BookRepository;
import com.dsaoDev.book.util.BookUtility;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookUtility bookUtil;
	
	public BookDTO save(Book book) {
			bookUtil.checkIsbnSize(book);
			
			bookRepository.save(book);
			
			return new BookDTO(book);
			
	}
}
