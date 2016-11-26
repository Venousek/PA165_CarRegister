package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.User;
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
 * @author Sevo001
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional
public class UserServiceImplTest {
    
    @Inject
    private UserService userService;
        
    private User user;
    private Car car; 
    private Drive drive;
    
    @Before
    public void setup() {
       user.setFirstname("Ferda");
       user.setLastname("Mravenec");
       user.setLogin("mravenec");
       user.setPassword("123456");
       user.setEmail("mravenec@gmail.com");
       user.setRole(Role.USER);
       
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullFirstname() {                        
        user.setFirstname(null);
        userService.create(user);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullLastname() {                        
        user.setLastname(null);
        userService.create(user);
    }
      
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullLogin() {                        
        user.setLogin(null);
        userService.create(user);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullPassword() {                        
        user.setPassword(null);
        userService.create(user);
    }
    
    @Test()
    public void testFindById() {       
        userService.create(user);
               
        User user1 = userService.findById(user.getId());
                
        assertNotNull(user1);
        assertEquals(user.getId(), user1.getId());                
    }    
    
   
    @Test
    public void testCreate() {
        assertEquals(userService.findAll().isEmpty(), true);          
        userService.create(user);
        assertEquals(userService.findAll().isEmpty(), false);
    }
    
    @Test
    public void testGetNotExistingUser() {                        
        assertNull(userService.findById(-1l));
    }
    
    @Test
    public void testDelete() {             
        userService.create(user);
        assertEquals(userService.findAll().isEmpty(), false);
        userService.delete(user);
        assertEquals(userService.findAll().isEmpty(), true);
    }
    
    @Test
    public void testUpdate() {                    
    	userService.create(user);                       
        user.setPassword("abcdefgh");
        
        userService.update(user);
        
        User user1 = userService.findById(user.getId());
                
        assertEquals(user1.getId(), user.getId());
        assertEquals(user1.getPassword(), "abcdefgh");    
    }
    

}
