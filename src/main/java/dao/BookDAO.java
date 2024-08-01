package dao;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class BookDAO extends GenericDAO<Book> {
    public BookDAO() {
        super(Book.class);
    }

    // Additional methods specific to Book entity can be added here
    public List<Book> getBooksByCategory(int categoryId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book where category_id = :categoryId", Book.class)
                          .setParameter("categoryId", categoryId)
                          .list();
        }
    }
    public List<Book> findBooksByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book where title like :title", Book.class)
                          .setParameter("title", "%" + title + "%")
                          .list();
        }
    }
    public List<Book> findBooksByAuthor(String author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book where author = :author", Book.class)
                          .setParameter("author", author)
                          .list();
        }
    }
    public List<Book> findBooksByYear(int year) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book where year = :year", Book.class)
                          .setParameter("year", year)
                          .list();
        }
    }
    
    
    
    
}    
