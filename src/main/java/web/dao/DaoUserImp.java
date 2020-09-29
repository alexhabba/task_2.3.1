package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoUserImp implements DaoUser {

//    @PersistenceContext
//    @Autowired
//    EntityManagerFactory entityManagerFactory;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.persist(user);
//        Session session = sessionFactory.getCurrentSession();
//        session.save(user);
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void updateUser(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.merge(user);

        sessionFactory.getCurrentSession().update(user);

    }

    @Override
    public void removeById(int id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        User user = entityManager.find(User.class, id);
//        entityManager.remove(user);
        User user = sessionFactory.getCurrentSession().find(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
//        sessionFactory.getCurrentSession().rem
    }

    @Override
    public User getUserById(int id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        return entityManager.find(User.class, id);
        Query query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        return entityManager.createNamedQuery("User.getAll", User.class).getResultList();
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
