package com.dsaoDev.book.entity;

import org.hibernate.validator.constraints.ISBN;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;

	@NotNull(message = "autor name shouldn't be null")
	@Column(nullable = false, length = 50)
	private String autor;

	@NotNull(message = "book title shouldn't be null")
	@Column(nullable = false, length = 50)
	private String title;

	@ISBN(message = "invalid ISBN, a valid ISBN contains 13 Digits")
	@NotNull(message = "ISBN shouldn't be null")
	@Column(nullable = false, length = 17, unique = true)
	private String isbn;

	@Builder
	public Book(String autor, String title, String isbn) {
		this.autor = autor;
		this.title = title;
		this.isbn = isbn;
	}

}
