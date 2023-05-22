package com.dsaoDev.book.dto;

import org.hibernate.validator.constraints.ISBN;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class BookRequestDTO {

	@NotBlank(message = "autor name shouldn't be empty")
	@NotNull(message = "autor name shouldn't be null")
	@Size(min = 2 , max = 30, message = "autor name has to be beetween 2-30 Characters")
	private String autor;

	@NotBlank(message = "book title shouldn't be empty")
	@NotNull(message = "book title shouldn't be null")
	private String title;

	@ISBN(message = "invalid ISBN, a valid ISBN contains 13 Digits without the hifens")
	@NotBlank(message = "ISBN shouldn't be empty")
	@NotNull(message ="ISBN shouldn't be null")
	private String isbn;

}
