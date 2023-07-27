package com.Learn.TestCases.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookModel {
	
	private int rating;
	private String name;
	private String gene;
	private String publisher; 
	private String summary;
	
}
