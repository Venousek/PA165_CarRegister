/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import org.joda.time.DateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
public class ServiceIntervalServiceImplTest {
    
    @Inject
    private ServiceIntervalService intervalService;
        
    @Inject
    private CarService carService;
        
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
        
        carService.create(car);
                       
        serviceInterval = new ServiceInterval();        
        serviceInterval.setCar(car);
        serviceInterval.setBegin(new DateTime(2016, 5, 10, 10, 15));
        serviceInterval.setEnd(new DateTime(2017, 5, 10, 10, 15));
        serviceInterval.setVisited(new DateTime(2017, 4, 10, 10, 15));
        
        
        
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullCar() {                        
        serviceInterval.setCar(null);
        intervalService.create(serviceInterval);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullDates() {                        
        serviceInterval.setBegin(null);
        serviceInterval.setEnd(null);
        serviceInterval.setVisited(null);
        intervalService.create(serviceInterval);
    }

    @Test()
    public void testFindById() {       
        intervalService.create(serviceInterval);
               
        ServiceInterval interval2 = intervalService.findById(serviceInterval.getId());
                
        assertNotNull(interval2);
        assertEquals(serviceInterval.getId(), interval2.getId());                
    }    
    
    @Test
    public void testGetNotExistingServiceInterval() {                        
        assertNull(intervalService.findById(-1l));
    }
    
    @Test
    public void testCreate() {
        assertEquals(intervalService.findAll().isEmpty(), true);          
        intervalService.create(serviceInterval);
        assertEquals(intervalService.findAll().isEmpty(), false);
    }
    
    @Test
    public void testDelete() {             
        intervalService.create(serviceInterval);
        assertEquals(intervalService.findAll().isEmpty(), false);
        intervalService.delete(serviceInterval);
        assertEquals(intervalService.findAll().isEmpty(), true);
    }
    
    @Test
    public void testUpdate() {                    
    	intervalService.create(serviceInterval);    
        Car car2 = new Car();
        car2.setFuel(Fuel.GASOLINE);
        car2.setManufacturer("Nissan");
        car2.setModel("GTR");
        car2.setMileage(50);
        car2.setRegister_number("1C2D3R4");
        car2.setVin("WBABAA1D3AS21DAS32D1");
        car2.setYear(2016);
        serviceInterval.setCar(car2);
        
        intervalService.update(serviceInterval);
        
        ServiceInterval serviceInterval2 = intervalService.findById(serviceInterval.getId());
                
        assertEquals(serviceInterval2.getId(), serviceInterval.getId());
        assertEquals(serviceInterval.getCar(), car2);    
    }
}

