/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
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
 * @author henrich
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional
public class DriveServiceImplTest
{
    @Inject
    private DriveService driveService;
        
    private User user;   
    private Car car; 
    private Drive drive;    
    
    @Before
    public void setup() {
        user = new User();
        
        user.setFirstname("First");
        user.setLastname("Last");
        user.setLogin("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        user.setRole(Role.USER);
        
        car = new Car();
        car.setFuel(Fuel.GASOLINE);
        car.setManufacturer("Audi");
        car.setModel("R8");
        car.setMileage(10);
        car.setRegister_number("1B2C3D4");
        car.setVin("WBABA91060AL04921");
        car.setYear(1999);
                        
        drive = new Drive();        
        drive.setUser(user);
        drive.setCar(car);
        drive.setBegin(new DateTime(2016, 5, 10, 10, 15));
        drive.setEnd(new DateTime(2016, 5, 10, 11, 15));
        drive.setDistance(40);  
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullCar() {                        
        drive.setCar(null);       
        driveService.create(drive);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNulluser() {                        
        drive.setUser(null);       
        driveService.create(drive);
    } 
    
    @Test
    public void testCreate() {
        assertEquals(driveService.findAll().isEmpty(), true);          
        driveService.create(drive);
        assertEquals(driveService.findAll().isEmpty(), false);
    }   
        
    @Test
    public void testUpdate() {                    
    	driveService.create(drive);                       
        drive.setDistance(80);        
        driveService.update(drive);
        
        Drive drive2 = driveService.findById(drive.getId());
                
        assertEquals(drive.getId(), drive2.getId());
        assertEquals(drive2.getDistance(), 80);    
    }
    
    @Test
    public void testDelete() {             
        driveService.create(drive);
    }
        
    @Test()
    public void testFindById() {       
        driveService.create(drive);
               
        Drive drive2 = driveService.findById(drive.getId());
                
        assertNotNull(drive2);
        assertEquals(drive.getId(), drive2.getId());                
    }  
    
    @Test
    public void testFindByNotExistingId() {                        
        assertNull(driveService.findById(-1l));
    }
}