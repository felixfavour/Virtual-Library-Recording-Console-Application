/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Felix Favour
 */
public class BookDaoImplement extends Book implements BookDao{
    Scanner sc = new Scanner(System.in);

    public BookDaoImplement(String name, int BookID) {
        super(name, BookID);
    }
    @Override
    public List<Book> getAllBooks() {
        return books;
    }
    @Override
    public Book getbook(int BookID) {
        return books.get(BookID-1);
    }
    @Override
    public void updatebook(Book book) {
//        String sql = "select * from `library`";
        books.add(book);
        String sql = "update `library` set `BookID` = " + book.getbookId() +", `Name` = '" + book.getname() + "' where BookID = "+ book.getbookId();
        try {
//            books.remove(book.getbookId());
//            books.add(book.getbookId()-1, book);
            
            Connection myConn = DriverManager.getConnection(url, user, pass);
//            Statement myState = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement myState = myConn.createStatement();
            myState.executeUpdate(sql);
//            ResultSet myrs = myState.executeQuery(sql);
//            myrs.absolute(1);
//            myrs.moveToInsertRow();
//            myrs.updateString("BookID", String.valueOf(book.getbookId()));
//            myrs.updateString("Name", book.getname());
            myConn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void deletebook(int id) {
        books.remove(id-1);
        try {
            int bookId = id;
            String sql = "DELETE FROM `library` WHERE BookID = " + bookId;
            Connection myConn = DriverManager.getConnection(url, user, pass);
//            Statement myState = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            PreparedStatement myPrepState = myConn.prepareStatement(sql);
//            Statement myState = myConn.createStatement();
//            myState.execute(sql);
//            myPrepState.setInt(1, 10);
//            ResultSet myrs = myPrepState.executeQuery(sql);
            myPrepState.executeUpdate(sql);
//            myConn.commit();
            myConn.close();
//            myrs.getString(1);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
}
    
}
