package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.BookInstance;

public class BookInstanceService {

	public long getAvgReadingTimeById(Integer bookInstanceId) {
		Double avgReadingTime = DAOFactory.getInstance().getBookInstanceDAO().getAvgReadingTime(bookInstanceId);
		return Math.round(avgReadingTime);
	}
	
	public long getTimesTakenById(Integer bookInstanceId) {
		Long timesTaken = DAOFactory.getInstance().getBookInstanceDAO().timesWasTaken(bookInstanceId);
		return timesTaken;
	}
	
	public long getAvgReadingTimeByInstance(BookInstance bookInstance) {
		Double avgReadingTime = DAOFactory.getInstance().getBookInstanceDAO().getAvgReadingTime(bookInstance.getId());
		return Math.round(avgReadingTime);
	}
	
	public long getTimesTakenByInstance(BookInstance bookInstance) {
		Long timesTaken = DAOFactory.getInstance().getBookInstanceDAO().timesWasTaken(bookInstance.getId());
		return timesTaken;
	}
	
	public void addBookInstance(BookInstance bookInstance){
		DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance);
	}
	
	public void updateBookInstance(BookInstance bookInstance){
		DAOFactory.getInstance().getBookInstanceDAO().updateElement(bookInstance);
	}
	
	public BookInstance getBookInstanceById(Integer id){
		return DAOFactory.getInstance().getBookInstanceDAO().getElementByID(id);
	}
	
	public void deleteBookInstance(BookInstance bookInstance){
		DAOFactory.getInstance().getBookInstanceDAO().deleteElement(bookInstance);
	}
	
	public List<BookInstance> getAllBookInstances() {
		return DAOFactory.getInstance().getBookInstanceDAO().getAllElements();
	}
}
