package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.BookInstance;

public interface BookInstanceDAO extends GenericDAO<BookInstance, Integer> {

	public long timesWasTaken(BookInstance bookInstance);
	public long getAvgReadingTime(BookInstance bookInstance);
}
