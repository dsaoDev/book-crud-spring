package com.dsaoDev.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsaoDev.book.entity.Book;



public interface BookRepository extends JpaRepository<Book, Long> {

}
