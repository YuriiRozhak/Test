package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.User;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

}
