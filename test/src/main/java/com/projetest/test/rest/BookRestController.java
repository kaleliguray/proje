package com.projetest.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetest.test.entity.Book;
import com.projetest.test.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {
	
	private BookService bookService;
	
	// inject book dao(use constructor injection)
		@Autowired
		public BookRestController(BookService theBookService) {
			this.bookService = theBookService;
		}
		
		// expose "/books" and return list of books 
		@GetMapping("/books")
		public List<Book> findAll() {
			return bookService.findAll();
		}
		
		// add mapping for GET /books/{bookId}
		@GetMapping("/books/{bookId}")
		public Book getBook(@PathVariable int bookId) {
			
			Book theBook = bookService.findById(bookId);
			
			if (theBook == null) {
				
				throw new RuntimeException("Book id not found  " + bookId);
				
			}
			
			return theBook;
		}
		
		@PostMapping("/books")
		public Book addBook(@RequestBody Book theBook) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item... instead of update
			
			theBook.setId(0);
			
			bookService.save(theBook);
			
			return theBook;
		}
		
		// add mapping for PUT /books update existing book
		@PutMapping("/books")
		public Book updateBook(@RequestBody Book theBook) {
			
			bookService.save(theBook);
			
			return theBook;
		}
		
		// add mapping for DELETE /books/{bookId} delete book
		@DeleteMapping("/books/{bookId}")
		public String deleteBook(@PathVariable int bookId) {
			
			Book tempBook = bookService.findById(bookId);
			
			if (tempBook == null) {
				
				throw new RuntimeException("Book id not found  " + bookId);
				
			}
			
			bookService.deleteById(bookId);
			
			return "Delete book id " + bookId;
			
		}

}




























