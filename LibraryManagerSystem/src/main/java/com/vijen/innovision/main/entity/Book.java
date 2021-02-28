package com.vijen.innovision.main.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Id
	@Column(name = "isbn", length = 50, nullable = false)
	private String isbn;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "count", length = 50, nullable = false)
	private int count;
	
	@Column(name = "author", length = 100)
	private String author;
	
	public Book() {
		
	}
	
	public Book(String isbn, String name, int count,String author) {
		
		this.isbn = isbn;
		this.name = name;
		this.count = count;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/*public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.REMOVE })
	 * 
	 * @JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name =
	 * "book_id") }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "author_id") }) private Set<Author> authors = new
	 * HashSet<Author>();
	 */


}
