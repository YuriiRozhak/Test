package com.softserve.lv219.hiberlibrary.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReadSession {
	@Id
	@Column(name = "IDREADSESSION")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Date getDate;

	@Column
	private Date returnDate;

	
	@ManyToOne
	@JoinColumn(name= "IDUSER")
	private User user;

	
	@ManyToOne
	@JoinColumn(name= "IDBOOKINSTANCE")
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
