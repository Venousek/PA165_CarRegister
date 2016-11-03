/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author robha
 */
@Repository
@Transactional
public class ServiceIntervalDaoImpl implements ServiceIntervalDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public ServiceIntervalDaoImpl() {
    }
    
    public ServiceIntervalDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void create(ServiceInterval serviceInterval) {
        if(serviceInterval!=null) {
            em.persist(serviceInterval);
        }
    }

    @Override
    public ServiceInterval findById(Long id) {
        Query q = em.createQuery("select si from ServiceInterval u where si.id = :id", ServiceInterval.class);
        q.setParameter("id", id);
        return (ServiceInterval) q.getSingleResult();
    }

    @Override
    public List<ServiceInterval> findAll() {
        Query q = em.createQuery("select si from ServiceInterval u", ServiceInterval.class);
        return q.getResultList();
    }

    @Override
    public void update(ServiceInterval serviceInterval) {
        if(serviceInterval!=null) {
            em.merge(serviceInterval);
        }
    }

    @Override
    public void delete(ServiceInterval serviceInterval) {
        if(serviceInterval!=null) {
            em.remove(serviceInterval);
        }
    }
    
}
