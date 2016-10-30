/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.joda.time.DateTime;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 *
 * @author robha
 */
public class ServiceIntervalDaoImplTest {
      //@Inject
    private ServiceIntervalDao serviceIntervalDao;
    
    private EntityManagerFactory emf;
    
    @Mock
    private ServiceInterval serviceInterval;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
        
    @Before
    public void setup() {
        
        emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        serviceIntervalDao = new ServiceDaoImpl(em);
        when(serviceIntervalDao.getCarId()).thenReturn(Long.getLong("1"));
        when(serviceIntervalDao.getBegin()).thenReturn(new DateTime(2016, 5, 10, 10, 14));
        when(serviceIntervalDao.getEnd()).thenReturn(new DateTime(2016, 5, 10, 11, 15));
        when(serviceIntervalDao.getVisited()).thenReturn(new DateTime(2016, 5, 10, 11, 16));
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