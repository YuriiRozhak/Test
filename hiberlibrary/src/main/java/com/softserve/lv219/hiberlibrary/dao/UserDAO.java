package com.softserve.lv219.hiberlibrary.dao;

import com.softserve.lv219.hiberlibrary.entity.User;

public interface UserDAO extends GenericDAO<User, Integer> {

	public Double getAvgReaderAge() ;
	public Long getTimeSinceRegistration(Integer	userId);
	public double getAvgTimeSinceRegistration();
	public double avgRequestByPeriod(String startDate, String endDate);
}
