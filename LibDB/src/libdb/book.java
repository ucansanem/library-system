/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libdb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SANEM
 */
public class book {
    String isbn;
    List<String> books;
    public book(List<String> bookid, String isbn){
        books =  new ArrayList();
        this.books = bookid;
        this.isbn = isbn;
    }
}
