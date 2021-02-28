package com.vijen.innovision.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijen.innovision.main.entity.Book;
import com.vijen.innovision.main.entity.Checkoutbook;
import com.vijen.innovision.main.entity.searchField;
import com.vijen.innovision.main.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBook(){
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
		
	}
	public void addBook(Book book) {
		Optional<Book> savingbook = bookRepository.findById(book.getIsbn());
		if(savingbook.isPresent()) {
			Book updateBook =savingbook.get();
			book.setCount(updateBook.getCount()+book.getCount());
		}
		bookRepository.save(book);
	}
	
	
	public List<Book> getAllFilteredBook(String searchField) {
		// TODO Auto-generated method stub
		List<Book> obj= bookRepository.findByAuthor(searchField);
		return obj;
	}
	
}
