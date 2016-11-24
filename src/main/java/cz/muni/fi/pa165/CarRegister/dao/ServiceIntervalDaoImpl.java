/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author robha
 */
@Repository
@Transactional
public class ServiceIntervalDaoImpl extends HibernateDaoSupport implements ServiceIntervalDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public ServiceIntervalDaoImpl() {
    }
    
    public ServiceIntervalDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Inject
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public void create(ServiceInterval serviceInterval) {
        em.persist(serviceInterval);        
    }

    @Override
    public ServiceInterval findById(Long id) {
        return em.find(ServiceInterval.class, id);
    }

    @Override
    public List<ServiceInterval> findAll() {
        Query q = em.createQuery("select si from ServiceInterval si");
        return q.getResultList();
    }

    @Override
    public void update(ServiceInterval serviceInterval) {
        em.merge(serviceInterval);        
    }

    @Override
    public void delete(ServiceInterval serviceInterval) {
        em.remove(serviceInterval);        
    }
    
}
