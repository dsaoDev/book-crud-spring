package com.dsaoDev.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaoDev.book.dto.BookRequestDTO;
import com.dsaoDev.book.dto.BookResponseDTO;
import com.dsaoDev.book.entity.Book;
import com.dsaoDev.book.exceptions.BookNotFoundException;
import com.dsaoDev.book.repository.BookRepository;
import com.dsaoDev.book.util.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapper bookMapper;


	@Override
	public BookResponseDTO save(BookRequestDTO bookDTO) {
		Book book = bookMapper.convertToBook(bookDTO);
		return bookMapper.convertToDTO(bookRepository.save(book));
	}

	
	@Override
	public List<BookResponseDTO> findAll() {
		return bookMapper.listConverter(bookMapper.checkIfListIsEmpty(bookRepository.findAll()));
	}

	
	@Override
	public BookResponseDTO findById(Long id) {
		return bookMapper.convertToDTO(returnBook(id));
	}

	
	@Override
	public BookResponseDTO update(BookRequestDTO bookDTO, Long id) {
		Book book = returnBook(id);
		bookMapper.updateBookData(book, bookDTO);
		return bookMapper.convertToDTO(bookRepository.save(book));
	}

	
	@Override
	public String deleteById(Long id) {
		Book book = returnBook(id);
		bookRepository.deleteById(book.getId());
		return "Book which ID is " + id + " was deleted with Success";
	}

	// Re-uso do FindById
	public Book returnBook(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Id not found : " + id));
	}

}
