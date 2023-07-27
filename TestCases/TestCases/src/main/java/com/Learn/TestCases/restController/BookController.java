package com.Learn.TestCases.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learn.TestCases.Entity.BookEntity;

import com.Learn.TestCases.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController (BookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping("/")
	public List<BookEntity> getAllBooks () {
		return this.bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public BookEntity getBookById (@PathVariable Long id) {
		return this.bookService.getBookById(id);
	}
	
}
