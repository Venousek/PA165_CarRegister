/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.PersistenceApplicationContext;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author robha
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ServiceIntervalDaoImplTest {
    
    @Autowired
    private ServiceIntervalDao serviceIntervalDao;
    
    @PersistenceContext
    public EntityManager em;
    
    @Mock
    private ServiceInterval serviceInterval;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
        
    @Before
    public void setup() {
        /*
        emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        serviceIntervalDao = new ServiceIntervalDaoImpl(em);
        when(serviceInterval.getCarId()).thenReturn(Long.getLong("1"));
        when(serviceInterval.getBegin()).thenReturn(new DateTime(2016, 5, 10, 10, 14));
        when(serviceInterval.getEnd()).thenReturn(new DateTime(2016, 5, 10, 11, 15));
        when(serviceInterval.getVisited()).thenReturn(new DateTime(2016, 5, 10, 11, 16));*/
    }
    
    @Test
    public void testCreate() {                        
        Assert.assertNull(serviceInterval.getId());
        serviceIntervalDao.create(serviceInterval);
        Assert.assertNotNull(serviceInterval.getId());
    }
    
    @Test
    public void testFindById() {
                        
        Assert.assertNull(serviceInterval.getId());
        serviceIntervalDao.create(serviceInterval);
        Assert.assertNotNull(serviceInterval.getId());
                
        Long id = serviceInterval.getId();       
        ServiceInterval newServiceInterval = serviceIntervalDao.findById(id);
                
        assertEquals(newServiceInterval.getId(), id);        
        assertEquals(newServiceInterval.getCarId(), Long.getLong("1")); 
        assertEquals(newServiceInterval.getBegin(), new DateTime(2016, 5, 10, 10, 14)); 
        assertEquals(newServiceInterval.getEnd(), new DateTime(2016, 5, 10, 11, 15)); 
        assertEquals(newServiceInterval.getVisited(), new DateTime(2016, 5, 10, 11, 16));      
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertNull(serviceInterval.getId());
        serviceIntervalDao.create(serviceInterval);
        Assert.assertNotNull(serviceInterval.getId());
        serviceIntervalDao.delete(serviceInterval);
        Assert.assertNull(serviceInterval.getId());        
    }
    
    @Test
    public void testUpdate() {
                        
        serviceIntervalDao.create(serviceInterval);                
        Long id = serviceInterval.getId();
        
        ServiceInterval newServiceInterval = serviceIntervalDao.findById(id);
        
        newServiceInterval.setCarId(Long.getLong("2"));
        
        serviceIntervalDao.update(newServiceInterval);
        
        ServiceInterval newestServiceInterval = serviceIntervalDao.findById(id);
                
        assertEquals(newestServiceInterval.getCarId(), Long.getLong("2"));         
    }
}
