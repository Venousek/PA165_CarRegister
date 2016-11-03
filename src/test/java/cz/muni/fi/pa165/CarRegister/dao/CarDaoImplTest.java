package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.PersistenceApplicationContext;
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

import cz.muni.fi.pa165.CarRegister.entities.Car;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author henrich
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CarDaoImplTest
{
    @Autowired
    private CarDao carDao;
    
    @PersistenceContext
    public EntityManager em;

    @Mock
    private Car car;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Before
    public void setup() {
        
        /*emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        carDao = new CarDaoImpl(em);*/
    }
    
    @Test
    public void testCreate() {                        
        Assert.assertTrue(car.getId() == 0);
        carDao.create(car);
        Assert.assertFalse(car.getId() == 0);
    }
    
    @Test
    public void testFindById() {
                               
        Assert.assertTrue(car.getId() == 0);
        carDao.create(car);
        Assert.assertFalse(car.getId() == 0);
                
        long id = car.getId();
                
        Car car = carDao.findById(id);
                
        Assert.assertTrue(car.getId() == id);                
    }
    
    @Test
    public void testDelete() {                        
        Assert.assertTrue(car.getId() == 0);
        carDao.create(car);
        Assert.assertFalse(car.getId() == 0);
        carDao.delete(car);
        Assert.assertTrue(car.getId() == 0);        
    }
    
    @Test
    public void testUpdate() {
                        
    	carDao.create(car);                
        long id = car.getId();
        
        Car car = carDao.findById(id);
        
        car.setModel("Tesla");
        
        carDao.update(car);
        
        Car newestCar = carDao.findById(id);
                
        assertEquals(newestCar.getModel(), "Tesla");         
    }
}
