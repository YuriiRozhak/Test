package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.Book;

public interface BookDAO extends GenericDAO<Book, Integer> {

	public long countAvailableInstances(Book book);
	
	public long countAll(Book book);
	
	public long timesWasTaken(Book book);
	
}
