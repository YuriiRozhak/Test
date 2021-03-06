package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.BookInstance;

public interface BookInstanceDAO extends GenericDAO<BookInstance, Integer> {

	public long timesWasTaken(Integer bookInstanceId);
	public Double getAvgReadingTime(Integer bookInstanceId);
	public boolean isAvailable(Integer bookInstanceId);
}
