package com.softserve.lv219.hiberlibrary.dao;

import java.util.List;

public interface GenericDAO<E,T> {

	public void addElement(E element);
    public void updateElement(E element);
    public E getElementByID(T elementId);
    public List<E> getAllElements();
    public void deleteElement(E element);

}
