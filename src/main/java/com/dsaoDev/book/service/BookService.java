package com.dsaoDev.book.service;

import java.util.List;

import com.dsaoDev.book.dto.BookResponseDTO;
import com.dsaoDev.book.dto.BookRequestDTO;
import com.dsaoDev.book.entity.Book;

public interface BookService {

	BookResponseDTO save(Book book);

	List<BookResponseDTO> findAll();

	BookResponseDTO findById(Long id);

	BookResponseDTO update(BookRequestDTO bookDTO, Long id);

	String deleteById(Long id);

}
