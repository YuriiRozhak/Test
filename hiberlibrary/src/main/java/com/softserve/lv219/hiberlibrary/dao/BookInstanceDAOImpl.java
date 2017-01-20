package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.BookInstance;

public class BookInstanceDAOImpl extends GenericDAOImpl<BookInstance, Integer> implements BookInstanceDAO {

	public BookInstanceDAOImpl() {
		super(BookInstance.class);
	}

	
}
