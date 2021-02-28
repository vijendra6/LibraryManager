package com.vijen.innovision.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vijen.innovision.main.entity.Book;

public interface BookRepository extends CrudRepository<Book,String>{

	List<Book> findByAuthor(String author);
}
