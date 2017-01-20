package com.softserve.lv219.hiberlibrary.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@Column(name = "IDBOOK")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name= "IDAUTHOR")
	private Author author;

	@Column
	@ManyToMany(targetEntity = Author.class,
    fetch = FetchType.LAZY)
	@JoinTable(name="authorsbooks",
    joinColumns={@JoinColumn(name="IDBOOK")},
    inverseJoinColumns={@JoinColumn(name="IDAUTHOR")})
	private List<Author> subauthors;

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
	
	public List<Author> getSubauthors() {
		return subauthors;
	}
	public void setSubauthors(List<Author> subauthors) {
		this.subauthors = subauthors;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
