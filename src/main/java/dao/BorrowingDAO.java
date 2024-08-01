
package dao;

import model.Borrowing;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class BorrowingDAO {

    public void saveBorrowing(Borrowing borrowing) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(borrowing);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateBorrowing(Borrowing borrowing) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(borrowing);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Borrowing getBorrowingById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Borrowing.class, id);
        }
    }

    public void deleteBorrowing(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Borrowing borrowing = session.get(Borrowing.class, id);
            if (borrowing != null) {
                session.delete(borrowing);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Borrowing> getAllBorrowings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Borrowing").list();
        }
    }
}
