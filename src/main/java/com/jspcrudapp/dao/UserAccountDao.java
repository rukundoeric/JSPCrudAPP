package com.jspcrudapp.dao;

import com.jspcrudapp.model.UserAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserAccountDao {
  public int save(UserAccount userAccount) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.save(userAccount);
      transaction.commit();
      return 1;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
      return 0;
    }
  }

  public int update(UserAccount userAccount) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.update(userAccount);
      transaction.commit();
      return 1;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
      return 0;
    }
  }

  public UserAccount getById(int id) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      return session.get(UserAccount.class, id);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<UserAccount> getAll() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      Query<UserAccount> query = session.createQuery("FROM UserAccount", UserAccount.class);
      return query.list();
    } catch (Exception e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  public int delete(UserAccount user) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      UserAccount UserAccount = session.get(UserAccount.class, user.getId());
      if (UserAccount != null) {
        session.delete(UserAccount);
      }
      transaction.commit();
      return 1;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
      return 0;
    }
  }
}
