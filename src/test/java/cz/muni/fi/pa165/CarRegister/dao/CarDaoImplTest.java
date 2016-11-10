package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.PersistenceApplicationContext;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author henrich
 */

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PersistenceApplicationContext.class)
@TestExecutionListeners(listeners = { TransactionalTestExecutionListener.class })
@Transactional
public class CarDaoImplTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private CarDao carDao;
    
    @PersistenceContext
    public EntityManager em;

    private Car car;
    
    @BeforeMethod
    public void setup() {
        car = new Car();
        car.setFuel(Fuel.GASOLINE);
        car.setManufacturer("Mazda");
        car.setModel("RX8");
        car.setMileage(10);
        car.setRegister_number("1B2C3D4");
        car.setVin("WBABA91060AL04921");
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullModel() {                        
        car.setModel(null);
        carDao.create(car);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullManufacturer() {                        
        car.setManufacturer(null);
        carDao.create(car);
    }
      
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullRegister_number() {                        
        car.setRegister_number(null);
        carDao.create(car);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullVin() {                        
        car.setVin(null);
        carDao.create(car);
    }
    
    @Test()
    public void testFindById() {       
        carDao.create(car);
               
        Car car2 = carDao.findById(car.getId());
                
        assertNotNull(car2);
        assertEquals(car.getId(), car2.getId());                
    }    
    
    @Test
    public void testGetNotExistingCar() {                        
        assertNull(carDao.findById(-1l));
    }
    
    @Test
    public void testCreate() {
        assertEquals(carDao.findAll().isEmpty(), true);          
        carDao.create(car);
        assertEquals(carDao.findAll().isEmpty(), false);
    }
    
    @Test
    public void testDelete() {             
        carDao.create(car);
        assertEquals(carDao.findAll().isEmpty(), false);
        carDao.delete(car);
        assertEquals(carDao.findAll().isEmpty(), true);
    }
    
    @Test
    public void testUpdate() {                    
    	carDao.create(car);                       
        car.setModel("Tesla");
        
        carDao.update(car);
        
        Car car2 = carDao.findById(car.getId());
                
        assertEquals(car2.getId(), car.getId());
        assertEquals(car2.getModel(), "Tesla");    
    }
}
