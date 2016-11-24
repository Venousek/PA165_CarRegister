/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author robha
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
public class ServiceIntervalDaoImplTest {
    
    @Inject
    private ServiceIntervalDao serviceIntervalDao;
    
    @PersistenceContext
    public EntityManager em;
    
    private ServiceInterval serviceInterval;
    private Car car;
            
    @Before
    public void setup() {
        
        car = new Car();
        car.setFuel(Fuel.GASOLINE);
        car.setManufacturer("Mazda");
        car.setModel("RX8");
        car.setMileage(10);
        car.setRegister_number("1B2C3D4");
        car.setVin("WBABA91060AL04921");
        car.setYear(1999);
        
        List<ServiceInterval> intervals = serviceIntervalDao.findAll();
        for (ServiceInterval i : intervals)
            serviceIntervalDao.delete(i);
                
        serviceInterval = new ServiceInterval();        
        serviceInterval.setCar(car);
        serviceInterval.setBegin(new DateTime(2016, 5, 10, 10, 15));
        serviceInterval.setEnd(new DateTime(2017, 5, 10, 10, 15));
        serviceInterval.setVisited(new DateTime(2017, 4, 10, 10, 15));
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
        assertEquals(newServiceInterval.getCar(), car); 
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
        
        newServiceInterval.setBegin(new DateTime(2016, 5, 10, 10, 15));
        
        serviceIntervalDao.update(newServiceInterval);
        
        ServiceInterval newestServiceInterval = serviceIntervalDao.findById(id);
                
        assertEquals(newestServiceInterval.getBegin(), new DateTime(2016, 5, 10, 10, 15));         
    }
}
