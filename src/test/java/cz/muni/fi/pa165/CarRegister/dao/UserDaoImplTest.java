package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.PersistenceApplicationContext;
import javax.persistence.EntityManagerFactory;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import cz.muni.fi.pa165.CarRegister.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cernak
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class UserDaoImplTest
{
    @Autowired
    private UserDao userDao;
    
    @PersistenceContext
    public EntityManager em;

    @Mock
    private User user;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void setup() {
        /*
        emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        userDao = new UserDaoImpl(em);*/
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
                
        long id = user.getId();               
        User user = userDao.findById(id);               
        Assert.assertTrue(user.getId() == id);                
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
        User user = userDao.findById(id);       
        user.setLogin("FerdaMravenec");
        
        userDao.update(user);        
        User newestUser = userDao.findById(id);               
        assertEquals(newestUser.getLogin(), "FerdaMravenec");         
    }
}
