package com.softserve.lv219.hiberlibrary.dao;

public class DAOFactory {
	
	private AuthorDAO authorDao = null;
	private UserDAO userDAO = null;
	private BookDAO bookDAO= null;
	private BookInstanceDAO bookInstanceDAO= null;
	private ReadSessionDAO readSessionDAO= null;
	
	

	private static DAOFactory instance = null;

    private DAOFactory() {
    	authorDao = new AuthorDAOImpl();
    	userDAO = new UserDAOImpl();
    	bookDAO = new BookDAOImpl();
    	bookInstanceDAO = new BookInstanceDAOImpl();
    	readSessionDAO = new ReadSessionDAOImpl();
    	
    }
    


	public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;

	}

    
    public AuthorDAO getAuthorDAO() {
		return authorDao;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public BookInstanceDAO getBookInstanceDAO() {
		return bookInstanceDAO;
	}

	public ReadSessionDAO getReadSessionDAO() {
		return readSessionDAO;
	}

}
