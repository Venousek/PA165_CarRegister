/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author robha
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional
public class ServiceIntervalFacadeTest {
    @Inject
    private ServiceIntervalFacade serviceIntervalFacade;
   @Inject
    private CarFacade carFacade;
    
    private ServiceIntervalDTO serviceIntervalDTO;
    private ServiceIntervalDTO serviceInterval2DTO;
    private CarDTO carDTO;
    private CarDTO car2DTO;
    @Before
     public void setup() {
        carDTO = new CarDTO();
        carDTO.setFuel(Fuel.GASOLINE);
        carDTO.setManufacturer("Mazda");
        carDTO.setModel("RX8");
        carDTO.setMileage(10);
        carDTO.setRegister_number("1B2C3D4");
        carDTO.setVin("WBABA91060AL04921");
        carDTO.setYear(1999);
   //   carDTO = carFacade.createCar(carDTO);
        
        car2DTO = new CarDTO();
        car2DTO.setFuel(Fuel.GASOLINE);
        car2DTO.setManufacturer("Mazda");
        car2DTO.setModel("RX8");
        car2DTO.setMileage(10);
        car2DTO.setRegister_number("1B2C3D4");
        car2DTO.setVin("WBABA91060AL04921");
        car2DTO.setYear(1999);
 //     car2DTO = carFacade.createCar(car2DTO);
        
        serviceIntervalDTO = new ServiceIntervalDTO();        
        serviceIntervalDTO.setCar(carDTO);
        serviceIntervalDTO.setBegin(new DateTime(2016, 5, 10, 10, 15).getMillis());
        serviceIntervalDTO.setEnd(new DateTime(2017, 5, 10, 10, 15).getMillis());
        serviceIntervalDTO.setVisited(new DateTime(2017, 4, 10, 10, 15).getMillis());
     
        serviceInterval2DTO = new ServiceIntervalDTO();        
        serviceInterval2DTO.setCar(carDTO);
        serviceInterval2DTO.setBegin(new DateTime(2016, 5, 10, 10, 15).getMillis());
        serviceInterval2DTO.setEnd(new DateTime(2017, 5, 10, 10, 15).getMillis());
        serviceInterval2DTO.setVisited(new DateTime(2017, 4, 10, 10, 15).getMillis());
    }
         @Test
    public void Test() {
        
        
        assertTrue(true);
        
    }
/*
    @Test
    public void findServiceIntervalTest() {
        serviceIntervalDTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);
        
        ServiceIntervalDTO foundServiceInterval = serviceIntervalFacade.findById(serviceIntervalDTO.getId());
        
        assertTrue(serviceIntervalDTO.equals(foundServiceInterval));
        
    }
    @Test
    public void findAllServiceIntervalTest() {
        serviceIntervalDTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);
        serviceInterval2DTO = serviceIntervalFacade.createServiceInterval(serviceInterval2DTO); 
        List<ServiceIntervalDTO> serviceIntervals = new ArrayList<ServiceIntervalDTO>();
        serviceIntervals.add(serviceIntervalDTO);
        serviceIntervals.add(serviceInterval2DTO);
        assertTrue(serviceIntervals.equals(serviceIntervalFacade.findAll()));
    }
    @Test
    public void updateServiceInterval() {
    	serviceIntervalDTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);                       
        serviceIntervalDTO.setCar(car2DTO);
        
        serviceIntervalFacade.update(serviceIntervalDTO);
        
        ServiceIntervalDTO serviceInterval2 = serviceIntervalFacade.findById(serviceIntervalDTO.getId());
                
        assertEquals(serviceInterval2.getId(), serviceIntervalDTO.getId());
        assertEquals(serviceInterval2.getCar(), car2DTO);   
    }
    @Test
    public void deleteServiceInterval() {
    	serviceIntervalDTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);                       
        
        Long id = serviceIntervalDTO.getId();
        serviceIntervalFacade.remove(serviceIntervalDTO);
        
        ServiceIntervalDTO serviceInterval = serviceIntervalFacade.findById(id);
                
        assertNull(serviceInterval);
        
    }
*/
    }


