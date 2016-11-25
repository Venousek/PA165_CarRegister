package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.User;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Cernak
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
public class UserDaoImplTest {
    
    @Inject
    private UserDao userDao;

    private User user;
    
    @Before
    public void setup() {
        user = new User();
        user.setFirstname("First");
        user.setLastname("Last");
        user.setLogin("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullFirstname() {                        
        user.setFirstname(null);
        userDao.create(user);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullLastname() {                        
        user.setLastname(null);
        userDao.create(user);
    }
      
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullLogin() {                        
        user.setLogin(null);
        userDao.create(user);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullEmail() {                        
        user.setEmail(null);
        userDao.create(user);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullPassword() {                        
        user.setPassword(null);
        userDao.create(user);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateShortPassword() {                        
        user.setPassword("123");
        userDao.create(user);    
    }
    
    @Test
    public void testCreate() {                        
        Assert.assertTrue(user.getId() == 0);
        userDao.create(user);
        Assert.assertFalse(user.getId() == 0);
    }
    
    @Test
    public void testFindById() {
                               
        Assert.assertTrue(user.getId() == 0);
        userDao.create(user);
        Assert.assertFalse(user.getId() == 0);
                             
        User user2 = userDao.findById(user.getId());               
        Assert.assertEquals(user2.getId(), user.getId());                
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertTrue(user.getId() == 0);
        userDao.create(user);
        Assert.assertFalse(user.getId() == 0);
        userDao.delete(user);
        Assert.assertTrue(user.getId() == 0);        
    }
    
    @Test
    public void testUpdate() {
                        
    	userDao.create(user);                
        long id = user.getId();       
        User user2 = userDao.findById(id);       
        user2.setLogin("FerdaMravenec");
        
        userDao.update(user2);        
        User newestUser = userDao.findById(id);               
        assertEquals(newestUser.getLogin(), "FerdaMravenec");         
    }
}
