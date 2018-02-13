package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets accounts from the database.
     * @param searchTerm The term to search
     * @param submitType The type of search submitted
     * @return The list of accounts
     */
    public List<Account> getAccounts(String searchTerm, String submitType) {
        if (submitType.equals("all")) {
            return getAll();
        }
        return new ArrayList<>();
    }

    /**
     * Updates a account.
     * @param account The account to be updated
     */
    public void saveOrUpdate(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a account to the database
     * @param account The account to be inserted
     */
    public int insert(Account account) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(account);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Deletes a account
     * @param account The account to be deleted
     */
    public void delete(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all accounts from the database.
     * @return a list of all accounts
     */
    public List<Account> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        query.from(Account.class);
        List<Account> accounts = session.createQuery(query).getResultList();
        session.close();
        return accounts;
    }

    /**
     * Gets a account by id.
     * @param id the account id
     * @return the account
     */
    public Account getById(int id) {
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }
}
