package com.vijen.innovision.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijen.innovision.main.entity.Book;
import com.vijen.innovision.main.entity.Checkoutbook;
import com.vijen.innovision.main.repository.BookRepository;
import com.vijen.innovision.main.repository.CheckoutRepository;

@Service
public class CheckoutService {
	
	@Autowired
	private CheckoutRepository checkoutRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Checkoutbook> getAllBook(){
		List<Checkoutbook> books = new ArrayList<>();
		checkoutRepository.findAll().forEach(books::add);
		return books;
		
	}
	public void addBook(Checkoutbook book) {
		checkoutRepository.save(book);
		int removedbooks=book.getCount();
		Optional<Book> bookfromDB = bookRepository.findById(book.getIsbn());
		if(bookfromDB.isPresent()) {
			
			Book recordedBook =bookfromDB.get();
			if(recordedBook.getCount() > book.getCount()) {
				checkoutRepository.save(book);
				}
			
		}
		
	}
	

	
}
