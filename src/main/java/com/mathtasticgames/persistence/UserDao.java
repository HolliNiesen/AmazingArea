package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets users from the database.
     * @param searchTerm The term to search
     * @param submitType The type of search submitted
     * @return The list of users
     */
    public List<User> getUsers(String searchTerm, String submitType) {
        if (submitType.equals("all")) {
            return getAll();
        }

        return getByFirstName(searchTerm);
    }

    /**
     * Updates a user.
     * @param user The user to be updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a user to the database
     * @param user The user to be inserted
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Deletes a user
     * @param user The user to be deleted
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all users from the database.
     * @return a list of all users
     */
    protected List<User> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets users by first name.
     * @param firstName the user first name
     * @return a list of users
     */
    protected List<User> getByFirstName(String firstName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("firstName");
        query.where(builder.like(propertyPath, "%" + firstName + "%"));
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets a user by id.
     * @param id the user id
     * @return the user
     */
    protected User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }
}
