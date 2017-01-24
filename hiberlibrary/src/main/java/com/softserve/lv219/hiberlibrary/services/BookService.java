package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Book;

public class BookService {
	/**
	 * 
	 * @param book
	 * @return <code>true</code> if there are available instances for this book, otherwise - <code>false</code>
	 */
	public boolean checkIfAvailable(Integer bookId){
		boolean result= false;
		Book book = getBookById(bookId);
		Long available = DAOFactory.getInstance().getBookDAO().countAvailableInstances(book);
		if (available>0) {
			result = true;
		}
		return result;
	}
	
	public long getAvgReadingTime(Integer bookId) {
		Book book = getBookById(bookId);
		Double avgReadingTime = DAOFactory.getInstance().getBookDAO().getAvgReadingTime(book);
		return Math.round(avgReadingTime);
	}
	
	public long getTimesBookTaken(Integer bookId) {
		Book book = getBookById(bookId);
		Long timesTaken = DAOFactory.getInstance().getBookDAO().timesWasTaken(book);
		return timesTaken;
	}

	public void addBook(Book book){
		DAOFactory.getInstance().getBookDAO().addElement(book);
	}
	
	public void updateBook(Book book){
		DAOFactory.getInstance().getBookDAO().updateElement(book);
	}
	
	public Book getBookById(Integer id){
		return DAOFactory.getInstance().getBookDAO().getElementByID(id);
	}
	
	public void deleteBook(Book book){
		DAOFactory.getInstance().getBookDAO().deleteElement(book);
	}
	
	public List<Book> getAllBooks() {
		return DAOFactory.getInstance().getBookDAO().getAllElements();
	}
}
