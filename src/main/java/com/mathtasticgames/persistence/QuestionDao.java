package com.mathtasticgames.persistence;

import com.mathtasticgames.entity.Question;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Table;
import java.util.List;

@SuppressWarnings("unchecked")
public class QuestionDao {

    public QuestionDao() {
    }

    @SuppressWarnings("deprecation")
    public List<Question> getRandomQuestions(String maxAnswer, int limit) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Table.class);
        criteria.add(Restrictions.le("solution", maxAnswer));
        criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
        criteria.setMaxResults(limit);
        return (List<Question>) criteria.list();
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
