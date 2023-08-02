package com.Learn.TestCases.Model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

@Component
public class BookModel {
	
	private int rating;
	private String name;
	private String gene;
	private String publisher; 
	private String summary;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGene() {
		return gene;
	}
	public void setGene(String gene) {
		this.gene = gene;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "BookModel [rating=" + rating + ", name=" + name + ", gene=" + gene + ", publisher=" + publisher
				+ ", summary=" + summary + "]";
	}
	public BookModel() {
		super();
	}
	public BookModel(int rating, String name, String gene, String publisher, String summary) {
		super();
		this.rating = rating;
		this.name = name;
		this.gene = gene;
		this.publisher = publisher;
		this.summary = summary;
	}
	
}
