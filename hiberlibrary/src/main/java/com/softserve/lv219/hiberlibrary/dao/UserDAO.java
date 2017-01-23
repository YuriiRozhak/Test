package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.User;

public interface UserDAO extends GenericDAO<User, Integer> {

	public Double getAvgReaderAge() ;
}
