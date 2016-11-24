/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
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
 * @author blahut
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional
public class DriveDaoImplTest {
    
    @Inject
    private DriveDao driveDao;
    
    @Inject
    private UserDao userDao;
    
    @Inject
    private CarDao carDao;
    
    @PersistenceContext
    public EntityManager em;
    
    private Drive drive;
    private User user;
    private Car car;
            
    @Before
    public void setup() {
        user = new User();
        
        user.setFirstname("First");
        user.setLastname("Last");
        user.setLogin("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        user.setRole(Role.USER);
        
        userDao.create(user);
        
        car = new Car();
        car.setFuel(Fuel.GASOLINE);
        car.setManufacturer("Mazda");
        car.setModel("RX8");
        car.setMileage(10);
        car.setRegister_number("1B2C3D4");
        car.setVin("WBABA91060AL04921");
        car.setYear(1999);
        
        carDao.create(car);
        
        List<Drive> drives = driveDao.findAll();
        for (Drive d : drives)
            driveDao.delete(d);
                
        drive = new Drive();        
        drive.setUser(user);
        drive.setCar(car);
        drive.setBegin(new DateTime(2016, 5, 10, 10, 15));
        drive.setEnd(new DateTime(2016, 5, 10, 11, 15));
        drive.setDistance(40);             
    }
    
    @Test
    public void testCreate() {                        
        Assert.assertNull(drive.getId());
        driveDao.create(drive);
        Assert.assertNotNull(drive.getId());
    }
    
    @Test
    public void testFindById() {
                        
        Assert.assertNull(drive.getId());
        driveDao.create(drive);
        Assert.assertNotNull(drive.getId());
                
        Long id = drive.getId();
        
        em.detach(drive);
                
        Drive newDrive = driveDao.findById(id);
                
        assertEquals(newDrive.getId(), id);        
        assertEquals(newDrive.getUser(), user); 
        assertEquals(newDrive.getCar(), car); 
        assertEquals(newDrive.getBegin(), new DateTime(2016, 5, 10, 10, 15)); 
        assertEquals(newDrive.getEnd(), new DateTime(2016, 5, 10, 11, 15)); 
        assertEquals(newDrive.getDistance(), 40);         
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertNull(drive.getId());
        driveDao.create(drive);
        Assert.assertNotNull(drive.getId());
        
        Long driveId = drive.getId();
        
        drive = driveDao.findById(driveId);
        driveDao.delete(drive);
        
        drive = driveDao.findById(driveId);
        Assert.assertNull(drive);        
    }
    
    @Test
    public void testUpdate() {
                        
        driveDao.create(drive);                
        Long id = drive.getId();
        
        Drive newDrive = driveDao.findById(id);
        
        newDrive.setDistance(50);
        
        driveDao.update(newDrive);
        
        Drive newestDrive = driveDao.findById(id);
                
        assertEquals(newestDrive.getDistance(), 50);         
    }
}
