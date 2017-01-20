package com.softserve.lv219.hiberlibrary.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReadSession {
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private Date getDate;

	@Column
	private Date returnDate;

	@Column
	private User user;

	@Column
	private BookInstance bookInstance;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getGetDate() {
		return getDate;
	}
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BookInstance getBookInstance() {
		return bookInstance;
	}
	public void setBookInstance(BookInstance bookInstance) {
		this.bookInstance = bookInstance;
	}

}
