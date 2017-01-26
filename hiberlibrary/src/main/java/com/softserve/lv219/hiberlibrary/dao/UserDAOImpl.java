package com.softserve.lv219.hiberlibrary.dao;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.entity.User;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}
	

public double avgRequestByPeriod(String startDate, String endDate){
	double res = 0;
	Session session = null;
	String queryString = "select count(*)*1.0/count(distinct rs.user.name) "
			+ "from ReadSession rs inner join rs.user "
			+ "where rs.getDate between :stDate and :edDate" ;
	
	try {

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date stDate = formatter.parse(startDate);
            Date enDate = formatter.parse(endDate);
		session = HibernateSessionFactory.currentSession();
		Query query = session.createQuery(queryString);
		query.setParameter("stDate", stDate, TemporalType.DATE);
		query.setParameter("edDate", enDate, TemporalType.DATE);
		res =  (double) query.getSingleResult();
	} catch (ParseException | NullPointerException e) {
		System.out.println("Wrong Input");
	} finally {
		if ((session != null) && (session.isOpen())) {
			HibernateSessionFactory.closeSession();
		}
	}
	return res;
}
	
	public double getAvgTimeSinceRegistration() {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-"
				+ "UNIX_TIMESTAMP(user.registrationDate)))/86400 "
				+ "from User user" ;
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			res = (Double) query.getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;		
	}
	
	public Long getTimeSinceRegistration(Integer userId) {
		Session session = null;
		String queryString = "select (UNIX_TIMESTAMP()-"
				+ "UNIX_TIMESTAMP(user.registrationDate))/86400 "
				+ "from User user "
				+ "where user.id=:userId" ;
		Long res;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("userId", userId);
			res =  (Long) query.getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;		
	}

	public Double getAvgReaderAge(){
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-"
				+ "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user" ;
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			res = (Double) query.getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
		
	}


	@Override
	public double getAvgAgeByBook(Integer bookId) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-"
				+ "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user "
				+ "where user.id in "
				+ "(select distinct rs.user.id from "
				+ "ReadSession rs inner join rs.user inner join rs.bookInstance inner join rs.bookInstance.book "
				+ "where rs.bookInstance.book.id = :bookId)" ;
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("bookId", bookId);
			res = (Double) query.getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}


	public double getAvgAgeByBookInstance(Integer bookInstanceId) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-"
				+ "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user "
				+ "where user.id in "
				+ "(select distinct rs.user.id from "
				+ "ReadSession rs inner join rs.user inner join rs.bookInstance "
				+ "where rs.bookInstance.id = :BIId)" ;
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("BIId", bookInstanceId);
			res = (Double) query.getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}


	
	public List<Book> booksWasTaken(Integer userId) {
		Session session = null;
		String queryString = "select rs.bookInstance.book from ReadSession rs "
				+ "inner join rs.bookInstance "
				+ "inner join rs.bookInstance.book "
				+ "inner join rs.user "
				+ "where rs.user.id =:idUser" ;
		List<Book> res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("idUser", userId);
			res =  query.getResultList();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	} 
	
	public List<Book> booksWasNotReturned(Integer userId) {
		Session session = null;
		String queryString = "select rs.bookInstance.book from ReadSession rs "
				+ "inner join rs.bookInstance "
				+ "inner join rs.bookInstance.book "
				+ "inner join rs.user "
				+ "where rs.user.id =:idUser and rs.returnDate is null" ;
		List<Book> res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("idUser", userId);
			res =  query.getResultList();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	} 
}
