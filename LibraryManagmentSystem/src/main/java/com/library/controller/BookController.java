package com.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.BookDto;
import com.library.entities.Book;
import com.library.entities.Book;
import com.library.service.BookService;
import com.library.service.BookService;
import com.library.serviceimpl.BookServiceImpl;
import com.library.serviceimpl.BookServiceImpl;

@RestController
public class BookController {
	@Autowired(required = true)
	BookService bs = new BookServiceImpl();
	
	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody @Valid BookDto b) {
		Book book = bs.createBook(b);
		if (book != null)
			return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	 else 
        // Handle the case where book creation failed, for example, return HttpStatus.INTERNAL_SERVER_ERROR
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@GetMapping("/Book/{bId}")
	public ResponseEntity<Book> getBook(@PathVariable int bId) {
		try {
			Book b = bs.getBook(bId);
			if (b != null)
				return new ResponseEntity<Book>(b, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	

	@GetMapping("/Books")
	public ResponseEntity<List<Book>> getBooks() {
		try {
			List<Book> slist = bs.getAllBooks();
			if (slist != null)
				return new ResponseEntity<List<Book>>(slist, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/Book/{bId}")
	public String updateName(@PathVariable("bId") int bId, @RequestBody Book st) {
		return bs.updateBook(bId, st);
	}

	@DeleteMapping("/Book/{bId}")
	public String deleteBook(@PathVariable int bId) {
		return bs.deleteBook(bId);

	}

}

