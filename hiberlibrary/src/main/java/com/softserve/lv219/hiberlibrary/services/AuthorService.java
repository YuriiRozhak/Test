package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Author;

public class AuthorService {
	
	public void addAuthor(Author author){
		DAOFactory.getInstance().getAuthorDAO().addElement(author);
	}
	
	public void updateAuthor(Author author){
		DAOFactory.getInstance().getAuthorDAO().updateElement(author);
	}
	
	public Author getAuthorById(Integer id){
		return DAOFactory.getInstance().getAuthorDAO().getElementByID(id);
	}
	
	public void deleteAuthor(Author author){
		DAOFactory.getInstance().getAuthorDAO().deleteElement(author);
	}
	
	public List<Author> getAllAuthors() {
		return DAOFactory.getInstance().getAuthorDAO().getAllElements();
	}

}
