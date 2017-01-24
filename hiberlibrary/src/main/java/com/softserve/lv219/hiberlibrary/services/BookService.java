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
	public boolean checkIfAvailableById(Integer bookId){
		boolean result= false;
		Long available = DAOFactory.getInstance().getBookDAO().countAvailableInstances(bookId);
		if (available>0) {
			result = true;
		}
		return result;
	}
	
	public long getAvgReadingTimeById(Integer bookId) {
		Double avgReadingTime = DAOFactory.getInstance().getBookDAO().getAvgReadingTime(bookId);
		return Math.round(avgReadingTime);
	}
	
	public long getTimesBookTakenById(Integer bookId) {
		Long timesTaken = DAOFactory.getInstance().getBookDAO().timesWasTaken(bookId);
		return timesTaken;
	}
	
	public boolean checkIfAvailable(Book book){
		boolean result= false;
		Long available = DAOFactory.getInstance().getBookDAO().countAvailableInstances(book.getId());
		if (available>0) {
			result = true;
		}
		return result;
	}
	
	public long getAvgReadingTime(Book book) {
		Double avgReadingTime = DAOFactory.getInstance().getBookDAO().getAvgReadingTime(book.getId());
		return Math.round(avgReadingTime);
	}
	
	public long getTimesBookTaken(Book book) {
		Long timesTaken = DAOFactory.getInstance().getBookDAO().timesWasTaken(book.getId());
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
