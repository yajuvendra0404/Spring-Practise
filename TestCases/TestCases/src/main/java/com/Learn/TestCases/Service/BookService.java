package com.Learn.TestCases.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learn.TestCases.DAO.BookDAO;
import com.Learn.TestCases.Model.BookModel;

@Service
public class BookService {

	private BookDAO bookDAO; 
	
	@Autowired
	public BookService (BookDAO bookDAO) {
		this.bookDAO  = bookDAO;
	}
	
	public BookModel getAllBooks () {
		this.bookDAO.getAllBooks (); 
		return  null;
	}
	
}
