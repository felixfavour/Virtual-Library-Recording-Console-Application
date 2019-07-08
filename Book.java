/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Book {
    static String url = "jdbc:mysql://localhost:3306/daoapp?zeroDateTimeBehavior=convertToNull";
    static String user = "root";
    static String pass = "";
    private String name;
    private int BookID;
    
    List<Book> books = new ArrayList<>();
        
    Book(String name, int BookID) {
        this.name = name;
        this.BookID = BookID;
        books.add(this);
        String sql = "select * from `library`";
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            Statement myState = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet myrs = myState.executeQuery(sql);
            myrs.afterLast();
            myrs.moveToInsertRow();
            myrs.updateString("BookID", String.valueOf(this.BookID));
            myrs.updateString("Name", this.name);
            myrs.insertRow();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    } 
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setbookId(int BookID) {
        this.BookID = BookID;
    }
    public int getbookId() {
        return BookID;
    }
    public String toString() {
        return String.format("name:    %s, bookID:  %d", getname(), getbookId());
    }
}
