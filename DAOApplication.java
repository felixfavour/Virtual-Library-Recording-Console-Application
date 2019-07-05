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
public class DAOApplication {

    public static void main(String[] args) {
        BookDaoImplement library = new BookDaoImplement("Little Red Riding Hood", 1);
        library.updatebook(new Book("Aladdin", 2));
        library.updatebook(new Book("Harry Potter", 3));
        library.updatebook(new Book("Lord of the rings", 4));
        library.updatebook(new Book("Aladdin", 5));
        System.out.println(library.getbook(1));
        library.deletebook(2);
        System.out.println(library.getAllBooks());
    }
}