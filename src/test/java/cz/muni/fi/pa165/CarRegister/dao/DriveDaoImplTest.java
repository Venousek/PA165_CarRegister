/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.PersistenceApplicationContext;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author blahut
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class DriveDaoImplTest extends AbstractJUnit4SpringContextTests {
    
    @Inject
    private DriveDao driveDao;
    
    @PersistenceContext
    public EntityManager em;
    
    @Mock
    private Drive drive;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
        
    @Before
    public void setup() {
        List<Drive> drives = driveDao.findAll();
        for (Drive d : drives)
            driveDao.delete(d);
                
        drive = new Drive();        
        drive.setUserId((long)1);
        drive.setCarId((long)1);
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
        assertEquals(newDrive.getUserId(), Long.getLong("1")); 
        assertEquals(newDrive.getCarId(), Long.getLong("1")); 
        assertEquals(newDrive.getBegin(), new DateTime(2016, 5, 10, 10, 15)); 
        assertEquals(newDrive.getEnd(), new DateTime(2016, 5, 10, 11, 15)); 
        assertEquals(newDrive.getDistance(), 40);         
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertNull(drive.getId());
        driveDao.create(drive);
        Assert.assertNotNull(drive.getId());
        driveDao.delete(drive);
        Assert.assertNull(drive.getId());        
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
