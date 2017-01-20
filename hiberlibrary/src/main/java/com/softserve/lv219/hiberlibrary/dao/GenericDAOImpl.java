package com.softserve.lv219.hiberlibrary.dao;

import java.util.List;

public class GenericDAOImpl<E,T> implements GenericDAO<E,T> {
	
    private Class<E> genericClass;

    public  GenericDAOImpl(Class<E> genericClass) {
        this.genericClass = genericClass;
    }


	public void addElement(E element) {
		// TODO Auto-generated method stub
		
	}

	public void updateElement(E element) {
		// TODO Auto-generated method stub
		
	}

	public E getElementByID(T elementId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteElement(E element) {
		// TODO Auto-generated method stub
		
	}

}
