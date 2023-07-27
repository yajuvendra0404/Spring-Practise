package com.Learn.TestCases.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learn.TestCases.Model.BookModel;
import com.Learn.TestCases.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService bookService;
	
	public BookController (BookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping("/")
	public BookModel getAllBooks () {
		
		this.bookService.getAllBooks();
		return null;
	}
	
}
