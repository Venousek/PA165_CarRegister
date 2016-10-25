/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

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
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 *
 * @author blahut
 */
public class DriveDaoImplTest {
    
    //@Inject
    private DriveDao driveDao;
    
    private EntityManagerFactory emf;
    
    @Mock
    private Drive drive;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
        
    @Before
    public void setup() {
        
        emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        driveDao = new DriveDaoImpl(em);
        
        when(drive.getUserId()).thenReturn(1);
        when(drive.getCarId()).thenReturn(1);
        when(drive.getBegin()).thenReturn(new DateTime(2016, 5, 10, 10, 15));
        when(drive.getEnd()).thenReturn(new DateTime(2016, 5, 10, 11, 15));
        when(drive.getDistance()).thenReturn(40);
             
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
                
        int id = drive.getId();
        
        //driveDao = new DriveDaoImpl(emf.createEntityManager());
        
        Drive newDrive = driveDao.findById(id);
                
        assertEquals(newDrive.getId(), id);        
        assertEquals(newDrive.getUserId(), 1); 
        assertEquals(newDrive.getCarId(), 1); 
        assertEquals(newDrive.getBegin(), new DateTime(2016, 5, 10, 10, 15)); 
        assertEquals(newDrive.getEnd(), new DateTime(2016, 5, 10, 11, 15)); 
        assertEquals(newDrive.getDistance(), 40);         
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertNull(drive.getId());
        driveDao.create(drive);
        int id = drive.getId();
        Assert.assertNotNull(drive.getId());
        driveDao.delete(drive);
        Assert.assertNull(drive.getId());        
    }
    
    @Test
    public void testUpdate() {
                        
        driveDao.create(drive);                
        int id = drive.getId();
        
        Drive newDrive = driveDao.findById(id);
        
        newDrive.setDistance(50);
        
        driveDao.update(newDrive);
        
        Drive newestDrive = driveDao.findById(id);
                
        assertEquals(newestDrive.getDistance(), 50);         
    }
}
