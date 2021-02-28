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
import com.vijen.innovision.main.entity.searchField;


@Controller
public class BookController {
	
	private final BookService bookService;
	private final CheckoutService checkoutService;

	@Autowired
	public BookController(BookService bookService,CheckoutService checkoutService) {
		this.bookService = bookService;
		this.checkoutService =checkoutService;
	}
	
	/*
	 * @RequestMapping("/dashboard") public String home() {
	 * 
	 * return "home"; //view }
	 * 
	 * @RequestMapping("/books") public List<Book> getAllbook() { return
	 * bookService.getAllBook(); }
	 */
	List<String> headers = Arrays.asList("isbn", "name", "count", "author");
	List<Book> rows = null;
	List <Checkoutbook> choutbook =null;
	
	@GetMapping("/")
	  public String dashboard(Model model) {
		rows = bookService.getAllBook();
	    model.addAttribute("books", rows);
	    model.addAttribute("table_height", rows.size());
	    model.addAttribute("bookname", "");
	    
	    int totalbooks=0;
	    totalbooks= rows.stream().filter(o -> o.getCount() > 10).mapToInt(Book::getCount).sum();
	    choutbook = checkoutService.getAllBook();
	    int checkoutbooks = choutbook.stream().filter(o -> o.getCount() > 10).mapToInt(Checkoutbook::getCount).sum();
	    model.addAttribute("totalbooks", totalbooks);
	    model.addAttribute("availbooks", totalbooks-checkoutbooks);
	    model.addAttribute("checkoutbooks", checkoutbooks);
	    
	    return "index";
	  }
	@GetMapping("/pages/forms/basic_elements.html")
	  public String addPage(Model model) {
	    model.addAttribute("books", new Book());
	    return "/pages/forms/basic_elements";
	  }
	
	@GetMapping("/books")
	  public String getBooks(Model model) {
	    model.addAttribute("books", new Book());
	    return "/pages/forms/basic_elements";
	  }
	

	@PostMapping("/books")
	  public String saveAllBooks(@ModelAttribute Book book, Model model) {
		bookService.addBook(book);
		rows = bookService.getAllBook();
	    int totalbooks= rows.stream().filter(o -> o.getCount() > 10).mapToInt(Book::getCount).sum();
	    choutbook = checkoutService.getAllBook();
	    model.addAttribute("books", rows);
	    int checkoutbooks = choutbook.stream().filter(o -> o.getCount() > 10).mapToInt(Checkoutbook::getCount).sum();
	    model.addAttribute("totalbooks", totalbooks);
	    model.addAttribute("availbooks", totalbooks-checkoutbooks);
	    model.addAttribute("checkoutbooks", checkoutbooks);
	    return "index";
	  }
	
	@GetMapping("/search/authorORbookname")
	  public String filterBooks(@ModelAttribute searchField bookname, Model model) {
		model.addAttribute("bookname", bookname);
		rows = bookService.getAllFilteredBook(bookname.toString());
	    model.addAttribute("books", rows);
	    model.addAttribute("table_height", rows.size());
	    
	    
	    int totalbooks=0;
	    totalbooks= rows.stream().filter(o -> o.getCount() > 10).mapToInt(Book::getCount).sum();
	    choutbook = checkoutService.getAllBook();
	    int checkoutbooks = choutbook.stream().filter(o -> o.getCount() > 10).mapToInt(Checkoutbook::getCount).sum();
	    model.addAttribute("totalbooks", totalbooks);
	    model.addAttribute("availbooks", totalbooks-checkoutbooks);
	    model.addAttribute("checkoutbooks", checkoutbooks);
	    
	    
	    return "Search";
	  }
	/*
	 * @RequestMapping(method=RequestMethod.POST,value="books") public void
	 * addBook(@RequestBody Book book) { bookService.addBook(book); }
	 */
	
}
