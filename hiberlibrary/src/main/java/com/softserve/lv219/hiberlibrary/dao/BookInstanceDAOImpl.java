package com.softserve.lv219.hiberlibrary.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.BookInstance;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class BookInstanceDAOImpl extends GenericDAOImpl<BookInstance, Integer> implements BookInstanceDAO {

	public BookInstanceDAOImpl() {
		super(BookInstance.class);
	}

	public Double getAvgReadingTime(Integer bookInstanceID) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP(readsession.returnDate)-"
				+ "UNIX_TIMESTAMP(readsession.getDate)))/86400"
				+ "from ReadSession readsession " 
				+ "inner join readsession.bookInstance " 
				+ "where readsession.bookInstance.id =:bookInstanceid "
				+ "and readsession.returnDate is not null";
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookInstanceid", bookInstanceID);
			res = (Double) bla.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}
	
	public long timesWasTaken(Integer bookInstanceId) {
		Session session = null;

		String queryString = "select count(*) from ReadSession readsession " 
				+ "inner join readsession.bookInstance " 
				+ "where readsession.bookInstance.id =:bookinstanceid";
		long res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookinstanceid", bookInstanceId);
			res = (Long) bla.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

}
