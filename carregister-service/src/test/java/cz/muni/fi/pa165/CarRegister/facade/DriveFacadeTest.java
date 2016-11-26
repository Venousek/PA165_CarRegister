/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.DriveDTO;
import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Henrich
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/applicationContext.xml"})
@Transactional
public class DriveFacadeTest
{
    @Inject
    private DriveFacade driveFacade;
    
    private UserDTO userDTO;    
    private CarDTO carDTO;
    private DriveDTO driveDTO;
  
     @Before
     public void setup()
     {
        userDTO = new UserDTO();       
        userDTO.setFirstname("First");
        userDTO.setLastname("Last");
        userDTO.setLogin("admin");
        userDTO.setPassword("123456");
        userDTO.setEmail("admin@gmail.com");
        userDTO.setRole(Role.USER);
        
        carDTO = new CarDTO();
        carDTO.setFuel(Fuel.GASOLINE);
        carDTO.setManufacturer("Audi");
        carDTO.setModel("R8");
        carDTO.setMileage(10);
        carDTO.setRegister_number("1B2C3D4");
        carDTO.setVin("WBABA91060AL04921");
        carDTO.setYear(1999);
                        
        driveDTO = new DriveDTO();        
        driveDTO.setUser(userDTO);
        driveDTO.setCar(carDTO);
        driveDTO.setBegin(new DateTime(2016, 5, 10, 10, 15).getMillis());
        driveDTO.setEnd(new DateTime(2016, 5, 10, 11, 15).getMillis());
        driveDTO.setDistance(40);  
    }
     
    @Test
    public void findDriveTest()
    {       
        driveDTO = driveFacade.createDrive(driveDTO);

        DriveDTO driveDTO2 = driveFacade.findById(driveDTO.getId());
        
        assertFalse(driveDTO == null);
        assertEquals(driveDTO.getId(), driveDTO2.getId());
    }
    
    
    @Test
    public void updateDrive() {
    	driveDTO = driveFacade.createDrive(driveDTO);                       
        driveDTO.setDistance(80);
        
        driveFacade.update(driveDTO);
        
        DriveDTO driveDTO2 = driveFacade.findById(driveDTO.getId());
                
        assertEquals(driveDTO.getId(), driveDTO2.getId());
        assertEquals(driveDTO2.getDistance(), 80);   
    }
}