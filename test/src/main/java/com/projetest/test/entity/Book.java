package com.projetest.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "author_first_name")
	private String authorFirstName;
	
	@Column(name = "author_last_name")
	private String authorLastName;
	
	@Column(name = "book_name")
	private String bookName;
	
	public Book() {
	
	}

	public Book(String authorFirstName, String authorLastName, String bookName) {
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.bookName = bookName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName
				+ ", bookName=" + bookName + "]";
	}
	

}

























