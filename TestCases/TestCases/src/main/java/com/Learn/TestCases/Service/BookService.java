package com.Learn.TestCases.Service;


import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learn.TestCases.Entity.BookEntity;
import com.Learn.TestCases.Model.BookModel;
import com.Learn.TestCases.Repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository; 


	@Autowired
	public BookService (
			BookRepository bookRepository
	) {
		this.bookRepository  = bookRepository;
	}
	
	public List<BookEntity> getAllBooks () {
		List <BookEntity> x = this.bookRepository.findAll();
		return this.bookRepository.findAll();
	}
	public Optional<BookEntity> getBookById (Long id) {
		return this.bookRepository.findById(id);
	}
	public void save(BookModel book) {
		BookEntity bookEntity = new BookEntity();
		
		bookEntity.setGene(book.getGene());
		bookEntity.setName(book.getName());
		bookEntity.setRating(book.getRating());
		bookEntity.setPublisher(book.getPublisher());
		bookEntity.setSummary(book.getSummary());
		
		this.bookRepository.save(bookEntity);
	} 
}
