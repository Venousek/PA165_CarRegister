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
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author blahut
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
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
        return em.find(User.class, id);
    }
    
    @Override
    public List<User> findAll() {
        Query q = em.createQuery("select u from User u");
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
