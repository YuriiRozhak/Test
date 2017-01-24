package com.softserve.lv219.hiberlibrary.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class BookDAOImpl extends GenericDAOImpl<Book, Integer> implements BookDAO {

	public BookDAOImpl() {
		super(Book.class);
	}

	/**
	 * @param bookId
	 *            book id of object needed to check
	 * @return quantity of available instances
	 */
	public long countAvailableInstances(Integer bookId) {
		Session session = null;
		String queryString = "select count(*) from BookInstance bookinstance "
				+ "where bookinstance.book.id =:bookid and not exists "
				+ "(from ReadSession readsession where readsession.returnDate is null"
				+ " and readsession.bookInstance.id = bookinstance.id)";

		long res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookid", bookId);
			res = (Long) bla.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;

	}

	/**
	 * @param book
	 *            book id of object needed to check
	 * @return quantity of all instances of this book
	 */
	public long countAll(Integer bookId) {
		Session session = null;
		String queryString = "select count(*) from BookInstance bookinstance " + "where bookinstance.book.id =:bookid";
		long res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookid", bookId);
			res = (Long) bla.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;

	}

	/**
	 * @param book
	 *            book id of object needed to check
	 * @return number of times book was taken
	 */
	public long timesWasTaken(Integer bookId) {
		Session session = null;

		String queryString = "select count(*) from ReadSession readsession " 
		+ "inner join readsession.bookInstance "
				+ "inner join readsession.bookInstance.book " 
		+ "where readsession.bookInstance.book.id =:bookid";
		long res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookid", bookId);
			res = (Long) bla.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

	public Double getAvgReadingTime(Integer bookId) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP(readsession.returnDate))-"
				+ "AVG(UNIX_TIMESTAMP(readsession.getDate)))/86400" + "from ReadSession readsession "
				+ "inner join readsession.bookInstance " + "inner join readsession.bookInstance.book "
				+ "where readsession.bookInstance.book.id =:bookid " + "and readsession.returnDate is not null";
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookid", bookId);
			res = (Double) bla.getSingleResult();
	
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

}
