package com.softserve.lv219.hiberlibrary.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.softserve.lv219.hiberlibrary.utils.HibernateSessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDAOImpl<E, T extends Serializable> implements GenericDAO<E, T> {

	private Class<E> genericClass;

	public GenericDAOImpl(Class<E> genericClass) {
		this.genericClass = genericClass;
	}

	public void addElement(E element) {
		Session session = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Transaction transaction = session.beginTransaction();
			session.save(element);
			transaction.commit();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}

	}

	public void updateElement(E element) {
		Session session = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Transaction transaction = session.beginTransaction();
			session.update(element);
			transaction.commit();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}

	}

	public E getElementByID(T elementId) {
		Session session = null;
		E element = null;
		try {
			session = HibernateSessionFactory.currentSession();
			// element = (E) session.load(elementClass, elementId);
			element = (E) session.get(genericClass, elementId);
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return element;

	}

	public List<E> getAllElements() {
		Session session = null;
		List<E> elements = new ArrayList<E>();
		try {
			session = HibernateSessionFactory.currentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<E> criteria = builder.createQuery(genericClass);
			criteria.from(genericClass);
			elements = session.createQuery(criteria).getResultList();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}
		return elements;

	}

	public void deleteElement(E element) {
		Session session = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Transaction transaction = session.beginTransaction();
			session.delete(element);
			transaction.commit();
		} finally {
			if ((session != null) && (session.isOpen())) {
				HibernateSessionFactory.closeSession();
			}
		}

	}

}
