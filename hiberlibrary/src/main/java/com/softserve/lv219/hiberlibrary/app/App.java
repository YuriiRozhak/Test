package com.softserve.lv219.hiberlibrary.app;


import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Book book1 = new Book();
        book1.setName("Kolobok");
        
        DAOFactory.getInstance().getBookDAO().addElement(book1);
    }
}
