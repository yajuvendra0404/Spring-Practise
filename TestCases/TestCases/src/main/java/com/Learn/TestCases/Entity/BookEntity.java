package com.Learn.TestCases.Entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="book")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

public class BookEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gene")
	private String gene;
	
	@Column(name="publisher")
	private String publisher; 
	
	@Column(name="summary")
	private String summary;
}
