package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.ReadSession;

public class ReadSessionDAOImpl extends GenericDAOImpl<ReadSession, Integer> implements ReadSessionDAO {

	public ReadSessionDAOImpl() {
		super(ReadSession.class);
	}

}
