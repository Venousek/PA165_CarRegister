/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.ArrayList;
import java.util.Date;
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
    
    private ServiceIntervalCreateDTO serviceIntervalDTO;
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
        carDTO = carFacade.createCar(carDTO);
        
        car2DTO = new CarDTO();
        car2DTO.setFuel(Fuel.GASOLINE);
        car2DTO.setManufacturer("Mazda");
        car2DTO.setModel("RX8");
        car2DTO.setMileage(10);
        car2DTO.setRegister_number("1B2C3D5");
        car2DTO.setVin("WBABA91060AL05921");
        car2DTO.setYear(1999);
        car2DTO = carFacade.createCar(car2DTO);
        
        serviceIntervalDTO = new ServiceIntervalCreateDTO();        
        serviceIntervalDTO.setCarId(carDTO.getId());
        serviceIntervalDTO.setBegin(new Date(2016, 5, 10, 10, 15));
        serviceIntervalDTO.setEnd(new Date(2017, 5, 10, 10, 15));
        serviceIntervalDTO.setVisited(new Date(2017, 4, 10, 10, 15));
     
        serviceInterval2DTO = new ServiceIntervalDTO();        
        serviceInterval2DTO.setCar(car2DTO);
        serviceInterval2DTO.setBeginLong(new DateTime(2016, 5, 10, 10, 15).getMillis());
        serviceInterval2DTO.setEndLong(new DateTime(2017, 5, 10, 10, 15).getMillis());
        serviceInterval2DTO.setVisitedLong(new DateTime(2017, 4, 10, 10, 15).getMillis());
    }

    @Test
    public void findServiceIntervalTest() {
        serviceInterval2DTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);
        
        ServiceIntervalDTO foundServiceInterval = serviceIntervalFacade.findById(serviceInterval2DTO.getId());
        
        assertTrue(serviceInterval2DTO.equals(foundServiceInterval));
        
    }
    @Test
    public void findAllServiceIntervalTest() {
        serviceInterval2DTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);
        serviceInterval2DTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO); 
        assertTrue(serviceIntervalFacade.findAll().size() == 2);
    }
    @Test
    public void updateServiceInterval() {
    	serviceInterval2DTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);                       
        serviceInterval2DTO.setCar(car2DTO);
        
        serviceIntervalFacade.update(serviceInterval2DTO);
        
        ServiceIntervalDTO serviceInterval2 = serviceIntervalFacade.findById(serviceInterval2DTO.getId());
                
        assertEquals(serviceInterval2.getId(), serviceInterval2DTO.getId());
        assertEquals(serviceInterval2.getCar(), car2DTO);   
    }

    @Test
    public void deleteServiceInterval() {
    	serviceInterval2DTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);                       
        
        Long id = serviceInterval2DTO.getId();
        serviceIntervalFacade.remove(serviceInterval2DTO);
        
        ServiceIntervalDTO serviceInterval = serviceIntervalFacade.findById(id);
                
        assertNull(serviceInterval);
        
    }

    }


