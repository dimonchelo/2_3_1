package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public void delete(User user) {
        entityManager.remove(user);
        entityManager.flush();
    }
    @Override
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User show(int id) { return entityManager.find(User.class, id); }
}
