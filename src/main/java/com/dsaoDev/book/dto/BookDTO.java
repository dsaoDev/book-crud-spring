package com.dsaoDev.book.dto;

import com.dsaoDev.book.entity.Book;

import lombok.Getter;

@Getter
public class BookDTO {
	
	
	private Long id;
	
	private String autor;

	private String title;
	
	private String isbn;
	
	public BookDTO(Book entity) {
		id = entity.getId();
		autor = entity.getAutor();
		title = entity.getTitle();
		isbn = entity.getIsbn();
				
	}
	

}
