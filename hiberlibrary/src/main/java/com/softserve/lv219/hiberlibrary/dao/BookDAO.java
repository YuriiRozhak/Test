package com.softserve.lv219.hiberlibrary.dao;

import java.util.List;
import java.util.Map;

import com.softserve.lv219.hiberlibrary.entity.Book;

public interface BookDAO extends GenericDAO<Book, Integer> {

	public long countAvailableInstances(Integer bookId);
	
	public long countAll(Integer bookId);
	
	public long timesWasTaken(Integer bookId);
	
	public Double getAvgReadingTime(Integer bookId);
	
	public List<Book> bookByAuthor(int i);
	
	public List<Book> bookByCoAuthor(int i);
	
	public List<Book> booksIndependanceInstances();
	
	public List<Object[]> getPopular(String startDate, String endDate);
	
	public List<Object[]> getNotPopular(String startDateString, String endDateString);
	
	public List<Book> getBookInfo(int BookId);
	
	public long countInstances(String bookName);
}
