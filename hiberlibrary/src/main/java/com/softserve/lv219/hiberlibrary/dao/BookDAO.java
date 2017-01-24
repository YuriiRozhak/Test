package com.softserve.lv219.hiberlibrary.dao;

import java.util.List;

import com.softserve.lv219.hiberlibrary.entity.Book;

public interface BookDAO extends GenericDAO<Book, Integer> {

	public long countAvailableInstances(Integer bookId);
	
	public long countAll(Integer bookId);
	
	public long timesWasTaken(Integer bookId);
	
	public Double getAvgReadingTime(Integer bookId);
	
	public List<Book> bookByAuthor(int i);
	
	public List<Book> bookByCoAuthor(int i);
	
	public List<Book> booksIndependanceInstances(String date);
}
