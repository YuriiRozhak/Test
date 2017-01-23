package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.User;

public class UserService {
	
	public Long getAvgAge() {
		Double result = DAOFactory.getInstance().getUserDAO().getAvgReaderAge();
		Long roundedResult = Math.round(result);
		return roundedResult;
	}
	
	public void addUser(User user){
		DAOFactory.getInstance().getUserDAO().addElement(user);
	}
	
	public void updateUser(User user){
		DAOFactory.getInstance().getUserDAO().updateElement(user);
	}
	
	public User getUserById(Integer id){
		return DAOFactory.getInstance().getUserDAO().getElementByID(id);
	}
	
	public void deleteUser(User user){
		DAOFactory.getInstance().getUserDAO().deleteElement(user);
	}
	
	public List<User> getAllUsers() {
		return DAOFactory.getInstance().getUserDAO().getAllElements();
	}

}


