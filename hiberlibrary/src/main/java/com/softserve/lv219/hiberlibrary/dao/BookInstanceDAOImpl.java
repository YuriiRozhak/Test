package com.softserve.lv219.hiberlibrary.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.entity.BookInstance;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class BookInstanceDAOImpl extends GenericDAOImpl<BookInstance, Integer> implements BookInstanceDAO {

	public BookInstanceDAOImpl() {
		super(BookInstance.class);
	}

	public long getAvgReadingTime(BookInstance bookInstance) {
		Session session = null;
		String queryString = "select AVG(UNIX_TIMESTAMP(readsession.returnDate))-"
				+ "AVG(UNIX_TIMESTAMP(readsession.getDate))"
				+ "from ReadSession readsession " 
				+ "inner join readsession.bookInstance " 
				+ "where readsession.bookInstance.id =:bookInstanceid "
				+ "and readsession.returnDate is not null";
		Double res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookInstanceid", bookInstance.getId());
			res = (Double) bla.getSingleResult();
			res/=86400;
			// res =
			// (Integer)session.createQuery(queryString).getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return Math.round(res);
	}
	
	public long timesWasTaken(BookInstance bookInstance) {
		Session session = null;

		String queryString = "select count(*) from ReadSession readsession " 
				+ "inner join readsession.bookInstance " 
				+ "where readsession.bookInstance.id =:bookinstanceid";
		long res;
		try {

			session = HibernateSessionFactory.currentSession();
			Query bla = session.createQuery(queryString);
			bla.setParameter("bookinstanceid", bookInstance.getId());
			res = (Long) bla.getSingleResult();

		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
	}

}
