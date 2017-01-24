package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.Book;

public interface BookDAO extends GenericDAO<Book, Integer> {

	public long countAvailableInstances(Integer bookId);
	
	public long countAll(Integer bookId);
	
	public long timesWasTaken(Integer bookId);
	
	public Double getAvgReadingTime(Integer bookId);
	
}
