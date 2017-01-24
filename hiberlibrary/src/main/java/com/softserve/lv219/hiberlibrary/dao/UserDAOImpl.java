package com.softserve.lv219.hiberlibrary.dao;


import javax.persistence.Query;

import org.hibernate.Session;

import com.softserve.lv219.hiberlibrary.entity.User;
import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}
	
//	select sum(times)/count(*)
//	from(
//	select  * , count(idread_session) as times
//	from user 
//	inner join read_session 
//	on read_session.id_user = user.iduser
//	where get_date between date('2012-11-03') and date('2016-11-05')
//	group by name) as T
	
public double avgRequestByPeriod(String startDate, String endDate){
	Session session = null;
	String queryString = "select sum(times)/count(*)"
			+ " from (select *,count(rs.id) as times from "
			+ "ReadSession rs"
			+ " inner join rs.user"
			+ " where rs.getDate between :stDate AND :edDate "
			+ "group by rs.user.name) as t" ;
	Double res;
	try {
		session = HibernateSessionFactory.currentSession();
		Query bla = session.createQuery(queryString);
		bla.setParameter("stDate", startDate);
		bla.setParameter("edDate", endDate);
		res = (Double) bla.getSingleResult();
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
			Query bla = session.createQuery(queryString);
			res = (Double) bla.getSingleResult();
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
			Query bla = session.createQuery(queryString);
			bla.setParameter("userId", userId);
			res =  (Long) bla.getSingleResult();
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
			Query bla = session.createQuery(queryString);
			res = (Double) bla.getSingleResult();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return res;
		
	} 
}
