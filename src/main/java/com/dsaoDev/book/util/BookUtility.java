package com.dsaoDev.book.util;

import org.springframework.stereotype.Component;

import com.dsaoDev.book.entity.Book;
import com.dsaoDev.book.exceptions.DataToLargeException;

@Component
public class BookUtility {
	
	public void checkIsbnSize(Book book) {
		if(book.getIsbn().length() > 13) {
			throw new DataToLargeException("ISBN contains only 13 digits");
		}
	}

}
