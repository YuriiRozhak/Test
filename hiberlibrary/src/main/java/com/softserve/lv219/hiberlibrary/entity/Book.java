package com.softserve.lv219.hiberlibrary.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Book {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private Author author;

	@Column
	private Author subauthor;

	@Column
	private Date publishDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Author getSubauthor() {
		return subauthor;
	}
	public void setSubauthor(Author subauthor) {
		this.subauthor = subauthor;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
