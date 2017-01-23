package com.softserve.lv219.hiberlibrary.app;


import com.softserve.lv219.hiberlibrary.dao.DAOFactory;
import com.softserve.lv219.hiberlibrary.entity.Author;
import com.softserve.lv219.hiberlibrary.entity.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
//        Author 
        Book book1 = new Book();
        book1.setName("Kolobok");

        DAOFactory.getInstance().getBookDAO().addElement(book1);
    }
}
