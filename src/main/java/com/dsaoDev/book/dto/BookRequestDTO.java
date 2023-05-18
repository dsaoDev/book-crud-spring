package com.dsaoDev.book.dto;

import org.hibernate.validator.constraints.ISBN;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BookRequestDTO {

	@NotBlank(message = "autor name shouldn't be blank")
	private String autor;

	@NotBlank(message = "book title shouldn't be blank")
	private String title;

	@ISBN(message = "invalid ISBN, a valid ISBN contains 13 Digits")
	@NotBlank(message = "ISBN shouldn't be blank")
	private String isbn;

}
