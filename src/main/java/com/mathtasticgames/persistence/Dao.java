package com.mathtasticgames.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Dao.
 *
 * @param <T> the type parameter
 */
@SuppressWarnings("unchecked")
public class Dao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Dao.
     *
     * @param type the type
     */
    public Dao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Gets by property.
     *
     * @param property     the property
     * @param variableName the variable name
     * @return the by property
     */
    public List<T> getByProperty(String property, String variableName) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(variableName);
        query.where(builder.like(propertyPath, "%" + property + "%"));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Gets by property less than with limit.
     *
     * @param property     the property
     * @param variableName the variable name
     * @return the by property less than with limit
     */
    public List<T> getByPropertyLessEqualThan(String property, String variableName) {
        Session session = getSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(variableName);
        query.where(builder.lessThanOrEqualTo(propertyPath, property));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public T getById(int id) {
        Session session = getSession();
        T entity = session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Insert an entity into the database.
     *
     * @param entity the entity
     * @return the entity id
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Save or update an entity in the database.
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Delete an entity from the database.
     *
     * @param entity the entity
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
