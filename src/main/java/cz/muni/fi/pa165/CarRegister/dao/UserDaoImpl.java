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
import org.springframework.stereotype.Repository;

/**
 *
 * @author blahut
 */
//@Repository
public class UserDaoImpl implements UserDao {

    //@Inject
    //@PersistenceContext
    private EntityManager em;
    
    public UserDaoImpl() {
        
    }
    
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void create(User user) {        
        em.persist(user);
    }
    
    @Override
    public User findById(Long id) {
        Query q = em.createQuery("select u from User u where u.id = :id", User.class);
        q.setParameter("id", id);
        return (User)q.getSingleResult();
    }
    
    @Override
    public List<User> findAll() {
        Query q = em.createQuery("select u from User u", User.class);
        return q.getResultList();
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
