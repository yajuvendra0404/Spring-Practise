package com.Learn.TestCases.Service;


import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learn.TestCases.Entity.BookEntity;
import com.Learn.TestCases.Model.BookModel;
import com.Learn.TestCases.Repositories.BookRepository;

@Service
public class BookService {

	private static final ListIterator ListItertor = null;
	private BookRepository bookRepository; 
	private BookModel bookModel;
	@Autowired
	public BookService (
			BookRepository bookRepository,
			BookModel bookModel
	) {
		this.bookRepository  = bookRepository;
		this.bookModel = bookModel;
	}
	
	public List<BookEntity> getAllBooks () {
		return this.bookRepository.findAll();
	}
	public BookEntity getBookById (Long id) {
		return this.bookRepository.findById(id);
	}
}
