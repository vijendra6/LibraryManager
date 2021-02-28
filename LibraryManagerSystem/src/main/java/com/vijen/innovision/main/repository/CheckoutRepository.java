package com.vijen.innovision.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.vijen.innovision.main.entity.Book;
import com.vijen.innovision.main.entity.Checkoutbook;

public interface CheckoutRepository extends CrudRepository<Checkoutbook,String>{

	
}
