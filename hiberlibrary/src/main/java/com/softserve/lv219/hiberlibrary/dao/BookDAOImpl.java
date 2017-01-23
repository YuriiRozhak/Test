package com.softserve.lv219.hiberlibrary.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class BookDAOImpl extends GenericDAOImpl<Book, Integer> implements BookDAO {

	public BookDAOImpl() {
		super(Book.class);
	}

	/**
	 * @param book book object needed to check
	 * @return quantity of available instances
	 */
	public long countAvailableInstances(Book book) {
		Session session = null;
		String queryString = "select count(*) from BookInstance bookinstance "
				+ "where bookinstance.book.id =:bookid and not exists "
				+ "(from ReadSession readsession where readsession.returnDate is null"
				+ " and readsession.bookInstance.id = bookinstance.id)";
	
		long res;
		try {
			
			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookid", book.getId());
			res =(Long) bla.getSingleResult();
		
//			res = (Integer)session.createQuery(queryString).getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
	return res;
		
	}

	/**
	 * @param book book object needed to check
	 * @return quantity of all instances of this book
	 */
	public long countAll(Book book) {
		Session session = null;
		String queryString = "select count(*) from BookInstance bookinstance "
				+ "where bookinstance.book.id =:bookid";
		long res;
		try {
			
			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookid", book.getId());
			res = (Long) bla.getSingleResult();
		
//			res = (Integer)session.createQuery(queryString).getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
	return res;
		
	}
	

	

}
