package com.vijen.innovision.main.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vijen.innovision.main.service.BookService;
import com.vijen.innovision.main.service.CheckoutService;
import com.vijen.innovision.main.entity.Book;
import com.vijen.innovision.main.entity.Checkoutbook;


@Controller
public class CheckoutController {
	
	private final CheckoutService checkoutService;
	private final BookService bookService;

	
	@Autowired
	public CheckoutController(CheckoutService checkoutService,BookService bookService) {
		this.checkoutService = checkoutService;
		this.bookService = bookService;
	}
	List<Book> rows = null;
	List<Checkoutbook> choutbook =null;

	@GetMapping("/pages/forms/checkout.html")
	  public String checkOutBook(Model model) {
	    model.addAttribute("checkoutbook", new Checkoutbook());
	    return "/pages/forms/checkout";
	  }
	

		/*
		 * @PostMapping("/pages/forms/checkout.html") public String
		 * saveCheckOut(@ModelAttribute Checkoutbook checkout, Model model) {
		 * checkoutService.addBook(checkout); model.addAttribute("checkoutbook",
		 * checkoutService.getAllBook()); return "index"; }
		 */
	
	@PostMapping("/pages/forms/checkout.html")
	  public String saveCheckout(@ModelAttribute Checkoutbook book, Model model) {
		checkoutService.addBook(book);
		rows = bookService.getAllBook();
	    model.addAttribute("books", rows);
	    int totalbooks= rows.stream().filter(o -> o.getCount() > 10).mapToInt(Book::getCount).sum();
	    model.addAttribute("totalbooks", totalbooks);
	    
	    choutbook= checkoutService.getAllBook();
	    int checkoutbooks = choutbook.stream().filter(o -> o.getCount() > 10).mapToInt(Checkoutbook::getCount).sum();
	    model.addAttribute("checkoutbooks", checkoutbooks);
	    model.addAttribute("availbooks", totalbooks-checkoutbooks);
	    
	    return "index";
	  }
	/*
	 * @RequestMapping(method=RequestMethod.POST,value="books") public void
	 * addBook(@RequestBody Book book) { bookService.addBook(book); }
	 */
	
}
