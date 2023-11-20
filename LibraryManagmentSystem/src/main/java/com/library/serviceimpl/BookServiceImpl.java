package com.library.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BookDto;
import com.library.entities.Book;
import com.library.entities.Student;
import com.library.repositories.BookRepository;
import com.library.repositories.StudentRepository;
import com.library.service.BookService;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository br;
	
	@Override
	public Book createBook(BookDto bId) {
		Book c=Book.builder()
				 .bName(bId.getBName())
				 .bAuthorName(bId.getBAuthorName())
				 .bPrice(bId.getBPrice())
				 .build();
		return br.save(c);
	}

	@Override
	public Book getBook(int bId) {
		return br.findById(bId).get();
	}

	@Override
	public List<Book> getAllBooks() {
			return br.findAll();
	}

	@Override
	public String deleteBook(int bId) {
		br.deleteById(bId);
		return "Record deleted successfully..";
	}

	@Override
	public String updateBook(int bId, Book book) {
		Book book1=br.findById(bId).get();
		book.setBName(book.getBName());
		book.setBPrice(book.getBPrice());
		book.setBAuthorName(book.getBAuthorName());
		
		br.save(book);
		return "Resord updated successfully...";
	}

}
