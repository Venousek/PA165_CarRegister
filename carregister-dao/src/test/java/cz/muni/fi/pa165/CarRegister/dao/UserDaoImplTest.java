package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
@Transactional
public class UserDaoImplTest {
    
    @Inject
    private UserDao userDao;

    private User user;
    
    @PersistenceContext
    public EntityManager em;
    
    @Before
    public void setup() {
        List<User> users = userDao.findAll();
        for (User u : users)
            userDao.delete(u);
                
        user = new User();
        user.setFirstname("First");
        user.setLastname("Last");
        user.setLogin("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        user.setRole(Role.USER);
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
        Assert.assertNull(user.getId());
        userDao.create(user);
        Assert.assertNotNull(user.getId());
    }
    
    @Test
    public void testFindById() {
                               
        Assert.assertNull(user.getId());
        userDao.create(user);
        Assert.assertNotNull(user.getId());
                             
        User user2 = userDao.findById(user.getId());               
        Assert.assertEquals(user2.getId(), user.getId());                
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertNull(user.getId());
        userDao.create(user);
        Assert.assertNotNull(user.getId());
        Long userId = user.getId();
        user = userDao.findById(userId);
        Assert.assertNotNull(user);  
        userDao.delete(user);
        
        user = userDao.findById(userId);
        Assert.assertNull(user);       
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
