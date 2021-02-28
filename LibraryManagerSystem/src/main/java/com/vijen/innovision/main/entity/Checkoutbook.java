package com.vijen.innovision.main.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "checkoutbook")
public class Checkoutbook {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "username", length = 100, nullable = false)
	private String username;

	@Id
	@Column(name = "isbn", length = 50, nullable = false, unique = true)
	private String isbn;

	@Column(name = "count", length = 100, nullable = false)
	private int count;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "codate", length = 50, nullable = false)
	private LocalDateTime codate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "ecidate", length = 50, nullable = false)
	private LocalDateTime  ecidate;

	public Checkoutbook() {
	
	}
	public Checkoutbook(String username, String isbn, int count, LocalDateTime codate, LocalDateTime ecidate) {
		super();
		this.username = username;
		this.isbn = isbn;
		this.count = count;
		this.codate = codate;
		this.ecidate = ecidate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDateTime getCodate() {
		return codate;
	}

	public void setCodate(LocalDateTime codate) {
		this.codate = codate;
	}

	public LocalDateTime getEcidate() {
		return ecidate;
	}

	public void setEcidate(LocalDateTime ecidate) {
		this.ecidate = ecidate;
	}
	

}
