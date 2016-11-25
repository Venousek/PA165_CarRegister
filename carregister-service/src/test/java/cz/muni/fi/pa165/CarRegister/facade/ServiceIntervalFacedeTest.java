/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
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
public class ServiceIntervalFacedeTest {
    @Inject
    private ServiceIntervalFacade serviceIntervalFacade;
   
    
    private ServiceIntervalDTO serviceIntervalDTO;
    private CarDTO carDTO;

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
        
    
                       
        serviceIntervalDTO = new ServiceIntervalDTO();        
        serviceIntervalDTO.setCar(carDTO);
        serviceIntervalDTO.setBegin(new DateTime(2016, 5, 10, 10, 15).getMillis());
        serviceIntervalDTO.setEnd(new DateTime(2017, 5, 10, 10, 15).getMillis());
        serviceIntervalDTO.setVisited(new DateTime(2017, 4, 10, 10, 15).getMillis());
        serviceIntervalDTO = serviceIntervalFacade.createServiceInterval(serviceIntervalDTO);
    }

    @Test
    public void findServiceIntervalTest() {
        ServiceIntervalDTO foundServiceInterval = serviceIntervalFacade.findById(serviceIntervalDTO.getId());
        assertTrue(serviceIntervalDTO.equals(foundServiceInterval));
    }


    }




