/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoapplication;

/**
 *
 * @author Felix Favour
 */
import java.util.List;
public interface BookDao {
    public List<Book> getAllBooks();
    public Book getbook(int BookID);
    public void updatebook(Book book);
    public void deletebook(int id);
}
