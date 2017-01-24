package com.softserve.lv219.hiberlibrary.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.Author;
import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class AuthorDAOImpl extends GenericDAOImpl<Author, Integer> implements AuthorDAO  {

	public AuthorDAOImpl() {
		super(Author.class);
		
	}

	
	}



