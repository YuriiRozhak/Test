package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.Book;

public class BookDAOImpl extends GenericDAOImpl<Book, Integer> implements BookDAO {

	public BookDAOImpl() {
		super(Book.class);
	}

	

}
