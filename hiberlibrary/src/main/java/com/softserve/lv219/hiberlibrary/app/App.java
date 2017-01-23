package com.softserve.lv219.hiberlibrary.app;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Author;
import com.softserve.lv219.hiberlibrary.entity.Book;
import com.softserve.lv219.hiberlibrary.entity.BookInstance;
import com.softserve.lv219.hiberlibrary.entity.ReadSession;
import com.softserve.lv219.hiberlibrary.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Author author1 = new Author();
    	Author author2 = new Author();
    	Author author3 = new Author();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        BookInstance bookInstance1 = new BookInstance();
        BookInstance bookInstance2 = new BookInstance();
        BookInstance bookInstance3 = new BookInstance();
        BookInstance bookInstance4 = new BookInstance();
        BookInstance bookInstance5 = new BookInstance();
        BookInstance bookInstance6 = new BookInstance();
                
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        
        ReadSession readSession1 = new ReadSession();
        ReadSession readSession2 = new ReadSession();
        ReadSession readSession3 = new ReadSession();
        ReadSession readSession4 = new ReadSession();
        
        book1.setName("White claw");
        book2.setName("Kobzar");
        book3.setName("Red community");
        author1.setName("Jack London");
        author2.setName("Shevckenko");
        author3.setName("Conan Doyle");
        book1.setAuthor(author1);
        book2.setAuthor(author2);
        book3.setAuthor(author3);
        List<Author> sub1 = new ArrayList<Author>();
        List<Author> sub2 = new ArrayList<Author>();
        List<Author> sub3 = new ArrayList<Author>();
        sub1.add(author3);
        sub1.add(author2);
        sub2.add(author1);
        sub3.add(author2);
        
        book1.setSubauthors(sub1);
        book2.setSubauthors(sub2);
        book3.setSubauthors(null);
        bookInstance1.setBook(book1);
        bookInstance2.setBook(book1);
        bookInstance3.setBook(book2);
        bookInstance4.setBook(book2);
        bookInstance5.setBook(book3);
        bookInstance6.setBook(book3);
        user1.setName("Vasya Pupkin");
        user2.setName("Volodya Zhoglo");
        user3.setName("Anton Lubiy");
        user1.setBirthDate(Date.valueOf("1994-05-12"));
		user2.setBirthDate(Date.valueOf("1969-09-22"));
		user3.setBirthDate(Date.valueOf("1964-03-12"));
		user1.setRegistrationDate(Date.valueOf("2015-03-17"));
		user2.setRegistrationDate(Date.valueOf("2016-05-27"));
		user3.setRegistrationDate(Date.valueOf("2017-01-12"));
		
		readSession1.setBookInstance(bookInstance1);
		readSession1.setGetDate(Date.valueOf("2016-02-12"));
		readSession1.setReturnDate(Date.valueOf("2016-05-12"));
		readSession1.setUser(user1);
		
		readSession2.setBookInstance(bookInstance2);
		readSession2.setGetDate(Date.valueOf("2016-02-12"));
		readSession2.setUser(user2);
		
		readSession3.setBookInstance(bookInstance3);
		readSession3.setGetDate(Date.valueOf("2016-02-12"));
		readSession3.setUser(user1);
		
		readSession4.setBookInstance(bookInstance4);
		readSession4.setGetDate(Date.valueOf("2016-02-12"));
		readSession4.setUser(user3);
		
        

        DAOFactory.getInstance().getAuthorDAO().addElement(author1);
        DAOFactory.getInstance().getAuthorDAO().addElement(author2);
        DAOFactory.getInstance().getAuthorDAO().addElement(author3);
        
        DAOFactory.getInstance().getBookDAO().addElement(book1);
        DAOFactory.getInstance().getBookDAO().addElement(book2);
        DAOFactory.getInstance().getBookDAO().addElement(book3);
        
        DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance1);
        DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance2);
        DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance3);
        DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance4);
        DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance5);
        DAOFactory.getInstance().getBookInstanceDAO().addElement(bookInstance6);
        
        DAOFactory.getInstance().getUserDAO().addElement(user1);
        DAOFactory.getInstance().getUserDAO().addElement(user2);
        DAOFactory.getInstance().getUserDAO().addElement(user3);
        
        DAOFactory.getInstance().getReadSessionDAO().addElement(readSession1);
        DAOFactory.getInstance().getReadSessionDAO().addElement(readSession2);
        DAOFactory.getInstance().getReadSessionDAO().addElement(readSession3);
        DAOFactory.getInstance().getReadSessionDAO().addElement(readSession4);
       
//        System.out.println( DAOFactory.getInstance().getBookDAO().countAll(book3));
//        System.out.println( DAOFactory.getInstance().getBookDAO().countAll(book1));
//        System.out.println( DAOFactory.getInstance().getBookDAO().countAll(book2));
        System.out.println( DAOFactory.getInstance().getBookDAO().countAvailableInstances(book1));
        System.out.println( DAOFactory.getInstance().getBookDAO().countAvailableInstances(book2));
        System.out.println( DAOFactory.getInstance().getBookDAO().countAvailableInstances(book3));
    }
}
