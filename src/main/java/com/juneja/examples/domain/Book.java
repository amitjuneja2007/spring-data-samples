package com.juneja.examples.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;

	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}

	public Book(Long id, String title, String isbn) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
	}
}
	
