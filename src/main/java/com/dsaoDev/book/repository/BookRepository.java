package com.dsaoDev.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsaoDev.book.entity.Book;

//not necessary
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
