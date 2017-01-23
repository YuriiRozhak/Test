package com.softserve.lv219.hiberlibrary.services;

import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.ReadSession;

public class ReadSessionService {

	public void addReadSession(ReadSession readSession){
		DAOFactory.getInstance().getReadSessionDAO().addElement(readSession);
	}
	
	public void updateReadSession(ReadSession readSession){
		DAOFactory.getInstance().getReadSessionDAO().updateElement(readSession);
	}
	
	public ReadSession getReadSessionById(Integer id){
		return DAOFactory.getInstance().getReadSessionDAO().getElementByID(id);
	}
	
	public void deleteReadSession(ReadSession readSession){
		DAOFactory.getInstance().getReadSessionDAO().deleteElement(readSession);
	}
	
	public List<ReadSession> getAllReadSessions() {
		return DAOFactory.getInstance().getReadSessionDAO().getAllElements();
	}

}

