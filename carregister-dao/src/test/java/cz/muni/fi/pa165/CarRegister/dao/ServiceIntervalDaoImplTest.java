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
import javax.transaction.Transactional;
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
@Transactional
public class ServiceIntervalDaoImplTest {
    
   
    @Inject
    private ServiceIntervalDao serviceIntervalDao;    
    
    @Inject
    private CarDao carDao;
        
    @PersistenceContext
    public EntityManager em;
    
    private Car car;
    private ServiceInterval serviceInterval;

            
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
        
        carDao.create(car);
        
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
        assertEquals(newServiceInterval.getBegin(), new DateTime(2016, 5, 10, 10, 15)); 
        assertEquals(newServiceInterval.getEnd(), new DateTime(2017, 5, 10, 10, 15)); 
        assertEquals(newServiceInterval.getVisited(), new DateTime(2017, 4, 10, 10, 15));      
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertNull(serviceInterval.getId());
        serviceIntervalDao.create(serviceInterval);
        Assert.assertNotNull(serviceInterval.getId());
        Long siId = serviceInterval.getId();
        serviceInterval = serviceIntervalDao.findById(siId);
        serviceIntervalDao.delete(serviceInterval);
        serviceInterval = serviceIntervalDao.findById(siId);
        Assert.assertNull(serviceInterval); 
    }
    
    @Test
    public void testUpdate() {
                        
        serviceIntervalDao.create(serviceInterval);                
        Long id = serviceInterval.getId();
        
        ServiceInterval newServiceInterval = serviceIntervalDao.findById(id);
        
        DateTime newDate = new DateTime(2016,5,10,10,15);
        DateTime newDate2 = new DateTime(2016,6,10,10,15);
        DateTime newDate3 = new DateTime(2016,7,10,10,15);
        newServiceInterval.setBegin(newDate);
        newServiceInterval.setEnd(newDate2);
        newServiceInterval.setVisited(newDate3);
        
        serviceIntervalDao.update(newServiceInterval);
        
        ServiceInterval newestServiceInterval = serviceIntervalDao.findById(id);
        assertEquals(newestServiceInterval.getEnd(), newDate2);   
        assertEquals(newestServiceInterval.getVisited(), newDate3); 
        assertEquals(newestServiceInterval.getBegin(), newDate);   
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullServiceInterval(){
        serviceIntervalDao.create(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNullServiceInterval(){
        serviceIntervalDao.update(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullServiceInterval(){
        serviceIntervalDao.delete(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetServiceIntervalByNullId(){
        serviceIntervalDao.findById(null);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void testCreateServiceIntervalWNullCar(){
        serviceInterval.setCar(null);
        serviceIntervalDao.create(serviceInterval);
    }
        
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void testServiceIntervalWNullDates(){
        serviceInterval.setBegin(null);
        serviceInterval.setEnd(null);
        serviceInterval.setVisited(null);
        serviceIntervalDao.create(serviceInterval);
    }
}
