package com.softserve.lv219.hiberlibrary.dao;

import java.text.DateFormat;
import java.text.ParseException;import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class BookDAOImpl extends GenericDAOImpl<Book, Integer>implements BookDAO {

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
			Query query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Long) query.getSingleResult();

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
			Query query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Long) query.getSingleResult();

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

		String queryString = "select count(*) from ReadSession readsession " + "inner join readsession.bookInstance "
				+ "inner join readsession.bookInstance.book " + "where readsession.bookInstance.book.id =:bookid";
		long res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Long) query.getSingleResult();

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
			Query query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Double) query.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

	public List<Book> bookByAuthor(int authorId) {
		Session session = null;

		String queryString = "select book from Book book  " + "inner join book.author  "
				+ "where book.author.id =:authorid";
		List<Book> res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("authorid", authorId);
			res = (List<Book>) query.getResultList();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

	public List<Book> bookByCoAuthor(int coAuthorId) {
		Session session = null;

		String queryString = "select distinct book from Book book  " + "inner join book.subauthors  "
				+ "where book.author.id =:coauthorid";
		List<Book> res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("coauthorid", coAuthorId);
			res = (List<Book>) query.getResultList();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

	public List<Book> booksIndependanceInstances() {
		
		String date="1994-08-26";
		
		Session session = null;

		String queryString = "from Book book  " + "where book.publishDate > :date ";

		List<Book> res = null;

		try {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date Date = formatter.parse(date);

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("date", Date, TemporalType.DATE);
			res = (List<Book>) query.getResultList();

		} catch (ParseException e) {

			System.out.println("Wrong Input");
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

	// 6
	public List<Object []> getPopular(String startDateString, String endDateString) {
		
		List<Object[]> res = null;
		Session session = null;
		String queryString = "select rs.bookInstance.book, "
				+ "count(rs.bookInstance.id) as times from ReadSession rs inner join rs.bookInstance"
				+ " inner join rs.bookInstance.book " + "where rs.getDate between :stDate and :edDate"
				+ " group by rs.bookInstance.id " + "order by times";
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse(startDateString);
			Date endDate = formatter.parse(endDateString);
			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("stDate", startDate, TemporalType.DATE);
			bla.setParameter("edDate", endDate, TemporalType.DATE);

			res = bla.getResultList();
			

		} catch (ParseException | NullPointerException e) {

			System.out.println("Wrong Input");
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

	public List<Object []> getNotPopular(String startDateString, String endDateString) {
	
		List<Object[]> res = null;
		Session session = null;
		String queryString = "select rs.bookInstance.book, "
				+ "count(rs.bookInstance.id) as times from ReadSession rs inner join rs.bookInstance"
				+ " inner join rs.bookInstance.book " + "where rs.getDate between :stDate and :edDate"
				+ " group by rs.bookInstance.id " + "order by times desc";
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse(startDateString);
			Date endDate = formatter.parse(endDateString);
			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("stDate", startDate, TemporalType.DATE);
			bla.setParameter("edDate", endDate, TemporalType.DATE);

			res = bla.getResultList();

		} catch (ParseException | NullPointerException e) {
			System.out.println("Wrong Input");
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;

	}

	public long countInstances(String bookName) {
		Session session = null;

		String queryString = "select count(*) BookInstance bi inner join bi.book " + "where bi.book.name =:bookname";
		Long available;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("bookname", bookName);
			available = (Long) query.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return available;
	}

	public List<Book> getBookInfo(int BookId) {

		Session session = null;
		List<Book> res;
		String queryString = "select rs.bookInstance.book from ReadSession rs inner join rs.bookInstance "
				+ "inner join rs.bookInstance.book " + "where rs.bookInstance.book.id= :idbook";

		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("idbook", BookId);
			res = (List<Book>) bla.getResultList();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

}
