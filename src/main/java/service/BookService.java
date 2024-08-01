
package service;

import dao.BookDAO;
import model.Book;
import java.util.List;

public class BookService {
    private final BookDAO bookDAO = new BookDAO();

    public void saveBook(Book book) {
        bookDAO.save(book);
    }

    public void updateBook(Book book) {
        bookDAO.update(book);
    }

   
    public List<Book> getBooksByTitle(String title) {
        return bookDAO.findBooksByTitle(title);
    }
    
}
