package com.softserve.lv219.hiberlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookInstance {
	@Id
	@Column(name = "IDBOOKINSTANCE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	@ManyToOne
	@JoinColumn(name= "IDBOOK")
	private Book book;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
