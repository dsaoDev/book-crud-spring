package com.dsaoDev.book.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dsaoDev.book.dto.BookResponseDTO;
import com.dsaoDev.book.dto.BookRequestDTO;
import com.dsaoDev.book.entity.Book;

@Component
public class BookMapper {

	// Conversão para um DTO recebendo uma entidade
	public BookResponseDTO convertToDTO(Book book) {
		return new BookResponseDTO(book);
	}

	// Conversão e aplicação do map para converter os Books em BookDTO depois
	// retorna de stream para list;
	public List<BookResponseDTO> listConverter(List<Book> bookList) {
		return bookList.stream().map(book -> new BookResponseDTO(book)).collect(Collectors.toList());
	}

	public void updateBookData(Book book, BookRequestDTO bookDTO) {
		book.setAutor(bookDTO.getAutor());
		book.setIsbn(bookDTO.getIsbn());
		book.setTitle(bookDTO.getTitle());
	}

}
