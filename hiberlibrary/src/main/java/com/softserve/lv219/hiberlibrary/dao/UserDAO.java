package com.softserve.lv219.hiberlibrary.dao;

import java.util.List;

import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.entity.User;

public interface UserDAO extends GenericDAO<User, Integer> {

	public Double getAvgReaderAge() ;
	public Long getTimeSinceRegistration(Integer userId);
	public double getAvgTimeSinceRegistration();
	public double avgRequestByPeriod(String startDate, String endDate);
	public double getAvgAgeByBook(Integer bookId);
	public double getAvgAgeByBookInstance(Integer bookInstanceId);

	public List<User> getDebtors();

	public List<Book> booksWasTaken(Integer userId);
	public List<Book> booksWasNotReturned(Integer userId);

}
