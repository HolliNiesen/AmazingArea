package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets roles from the database.
     * @param searchTerm The term to search
     * @param submitType The type of search submitted
     * @return The list of roles
     */
    public List<Role> getRoles(String searchTerm, String submitType) {
        if (submitType.equals("all")) {
            return getAll();
        }
        return new ArrayList<>();
    }

    /**
     * Updates a role.
     * @param role The role to be updated
     */
    public void saveOrUpdate(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(role);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts a role to the database
     * @param role The role to be inserted
     */
    public int insert(Role role) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(role);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Deletes a role
     * @param role The role to be deleted
     */
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all roles from the database.
     * @return a list of all roles
     */
    public List<Role> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        query.from(Role.class);
        List<Role> roles = session.createQuery(query).getResultList();
        session.close();
        return roles;
    }

    /**
     * Gets a role by id.
     * @param id the role id
     * @return the role
     */
    public Role getById(int id) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }
}
