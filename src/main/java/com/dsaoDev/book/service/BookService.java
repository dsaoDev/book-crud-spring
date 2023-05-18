package com.dsaoDev.book.service;

import java.util.List;

import com.dsaoDev.book.dto.BookRequestDTO;
import com.dsaoDev.book.dto.BookResponseDTO;

public interface BookService {

	BookResponseDTO save(BookRequestDTO bookDTO);

	List<BookResponseDTO> findAll();

	BookResponseDTO findById(Long id);

	BookResponseDTO update(BookRequestDTO bookDTO, Long id);

	String deleteById(Long id);

}
