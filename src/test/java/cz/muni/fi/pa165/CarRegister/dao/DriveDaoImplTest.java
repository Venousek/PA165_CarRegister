/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.PersistenceApplicationContext;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
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
 * @author blahut
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class DriveDaoImplTest {
    
    @Autowired
    private DriveDao driveDao;
    
    @PersistenceContext
    public EntityManager em;
    
    @Mock
    private Drive drive;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
        
    @Before
    public void setup() {
        /*
        emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        driveDao = new DriveDaoImpl(em);
        when(drive.getUserId()).thenReturn(Long.getLong("1"));
        when(drive.getCarId()).thenReturn(Long.getLong("1"));
        when(drive.getBegin()).thenReturn(new DateTime(2016, 5, 10, 10, 15));
        when(drive.getEnd()).thenReturn(new DateTime(2016, 5, 10, 11, 15));
        when(drive.getDistance()).thenReturn(40);*/
             
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
        
        //driveDao = new DriveDaoImpl(emf.createEntityManager());
        
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
