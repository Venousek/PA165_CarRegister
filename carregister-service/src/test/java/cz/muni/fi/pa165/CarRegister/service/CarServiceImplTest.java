package cz.muni.fi.pa165.CarRegister.service;

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
import javax.validation.ConstraintViolationException;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author blahut
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional
public class CarServiceImplTest {
    
    @Inject
    private CarService carService;
        
    private Car car;
    
    @Before
    public void setup() {
        car = new Car();
        car.setFuel(Fuel.GASOLINE);
        car.setManufacturer("Mazda");
        car.setModel("RX8");
        car.setMileage(10);
        car.setRegister_number("1B2C3D4");
        car.setVin("WBABA91060AL04921");
        car.setYear(1999);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullModel() {                        
        car.setModel(null);
        carService.create(car);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullManufacturer() {                        
        car.setManufacturer(null);
        carService.create(car);
    }
      
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullRegister_number() {                        
        car.setRegister_number(null);
        carService.create(car);
    }
    
    @Test (expected = ConstraintViolationException.class)
    public void testCreateNullVin() {                        
        car.setVin(null);
        carService.create(car);
    }
    
    @Test()
    public void testFindById() {       
        carService.create(car);
               
        Car car2 = carService.findById(car.getId());
                
        assertNotNull(car2);
        assertEquals(car.getId(), car2.getId());                
    }    
    
    @Test
    public void testGetNotExistingCar() {                        
        assertNull(carService.findById(-1l));
    }
    
    @Test
    public void testCreate() {
        assertEquals(carService.findAll().isEmpty(), true);          
        carService.create(car);
        assertEquals(carService.findAll().isEmpty(), false);
    }
    
    @Test
    public void testDelete() {             
        carService.create(car);
        assertEquals(carService.findAll().isEmpty(), false);
        carService.delete(car);
        assertEquals(carService.findAll().isEmpty(), true);
    }
    
    @Test
    public void testUpdate() {                    
    	carService.create(car);                       
        car.setModel("Tesla");
        
        carService.update(car);
        
        Car car2 = carService.findById(car.getId());
                
        assertEquals(car2.getId(), car.getId());
        assertEquals(car2.getModel(), "Tesla");    
    }
    /*
    @Test
    public void testFindAllAvailable() {                    
    	carService.create(car);         
        
        Car car2 = new Car();
        car2.setFuel(Fuel.GASOLINE);
        car2.setManufacturer("Skoda");
        car2.setModel("Favorit");
        car2.setMileage(500000);
        car2.setRegister_number("1Z38459");
        car2.setVin("WBABA91070AL04921");
        car2.setYear(1993);
        
        carService.create(car2);
        
        
        Car car3 = new Car();
        car3.setFuel(Fuel.GASOLINE);
        car3.setManufacturer("Skoda");
        car3.setModel("Octavia");
        car3.setMileage(50000);
        car3.setRegister_number("1Z48459");
        car3.setVin("WBABA91070AL04821");
        car3.setYear(2005);
        
        carService.create(car3);
        
        User user = new User();        
        user.setFirstname("First");
        user.setLastname("Last");
        user.setLogin("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        user.setRole(Role.USER);
        
        carService.create(user);
        
        Drive drive = new Drive();
        drive.setUser(user);
        drive.setCar(car3);
        drive.setBegin(DateTime.now());
        
        carService.create(drive);       
        
        List<Car> allCars = carService.findAll();
        List<Car> availableCars = carService.findAllAvailable();
                
        assertEquals(allCars.size(), 3);
        assertEquals(availableCars.size(), 1);    
        assertEquals(availableCars.get(0).getId(), car.getId());    
    }*/
}
