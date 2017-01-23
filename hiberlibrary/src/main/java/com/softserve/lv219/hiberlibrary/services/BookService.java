package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Book;

public class BookService {

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
