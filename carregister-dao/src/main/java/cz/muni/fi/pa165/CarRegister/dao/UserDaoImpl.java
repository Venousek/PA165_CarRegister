/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import cz.muni.fi.pa165.CarRegister.entities.User;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blahut
 */
@Repository
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public UserDaoImpl() {
        
    }
    
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Inject
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public void create(User user) {        
        em.persist(user);
    }
    
    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }
    
    @Override
    public List<User> findAll() {
        Query q = em.createQuery("select u from User u");
        return q.getResultList();
    }
    
    @Override
    public User findByLogin(String login) {
        Query q = em.createQuery("select u from User u where u.login = :login");
        q.setParameter("login", login);
        List results = q.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() == 1) return (User)results.get(0);
        throw new IllegalStateException("login is not unique!");        
    }
    
    @Override
    public void update(User user) {        
        em.merge(user);        
    }
    
    @Override
    public void delete(User user) {
        em.remove(user);        
    }
            
}
