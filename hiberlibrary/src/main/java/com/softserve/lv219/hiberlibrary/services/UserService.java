package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.entity.BookInstance;
import com.softserve.lv219.hiberlibrary.entity.User;

public class UserService {
	
	public double getAvgAgeByBook(Integer id){
		Double result = DAOFactory.getInstance().getUserDAO().getAvgAgeByBook(id);
		return result;
	}
	
	public double getAvgAgeByBook(Book book){
		Double result = DAOFactory.getInstance().getUserDAO().getAvgAgeByBook(book.getId());
		return result;
	}
	
	public double getAvgAgeByBookInstance(Integer id){
		Double result = DAOFactory.getInstance().getUserDAO().getAvgAgeByBookInstance(id);
		return result;
	}
	
	public double getAvgAgeByBookInstance(BookInstance bI){
		Double result = DAOFactory.getInstance().getUserDAO().getAvgAgeByBook(bI.getId());
		return result;
	}
	
	public double avgRequestByPeriod(String startDate, String endDate){
		Double result = DAOFactory.getInstance().getUserDAO().avgRequestByPeriod(startDate, endDate);
		return result;
	}
	
	public Long getAvgTimeSinceRegistration() {
		Double result = DAOFactory.getInstance().getUserDAO().getAvgTimeSinceRegistration();
		Long roundedResult = Math.round(result);
		return roundedResult;
	}
	
	public Long getTimeSinceRegistration(Integer userId) {
		Long result = DAOFactory.getInstance().getUserDAO().getTimeSinceRegistration(userId);
		return result;
	}
	
	public Long getAvgAge() {
		Double result = DAOFactory.getInstance().getUserDAO().getAvgReaderAge();
		Long roundedResult = Math.round(result);
		return roundedResult;
	}
	public List<Book> booksWasTaken(Integer userId){
		List<Book> takenBooks = DAOFactory.getInstance().getUserDAO().booksWasTaken(3);
		return takenBooks;
	}
	public List<Book> booksWasNotReturned(Integer userId){
		List<Book> notReturnedBook = DAOFactory.getInstance().getUserDAO().booksWasNotReturned(2);
		return notReturnedBook;
	}
	
	public void addUser(User user){
		DAOFactory.getInstance().getUserDAO().addElement(user);
	}
	
	public void updateUser(User user){
		DAOFactory.getInstance().getUserDAO().updateElement(user);
	}
	
	public User getUserById(Integer id){
		return DAOFactory.getInstance().getUserDAO().getElementByID(id);
	}
	
	public void deleteUser(User user){
		DAOFactory.getInstance().getUserDAO().deleteElement(user);
	}
	
	public List<User> getAllUsers() {
		return DAOFactory.getInstance().getUserDAO().getAllElements();
	}

}


