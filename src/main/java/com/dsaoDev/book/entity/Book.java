package com.dsaoDev.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	
	private Long id;
	@Column(nullable = false, length = 50)
	
	private String autor;
	@Column(nullable = false, length = 50)
	
	private String title;
	
	@Column(nullable = false, length = 13, unique = true)
	private String isbn;
	
	

}
