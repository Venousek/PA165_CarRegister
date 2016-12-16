/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.DriveCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.DriveDTO;
import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
    
    @Inject
    private UserFacade userFacade;
    
    @Inject
    private CarFacade carFacade;
    
    private UserDTO userDTO;    
    private UserDTO user2DTO;   
    private CarDTO carDTO;
    private CarDTO car2DTO;
    private DriveCreateDTO driveDTO;
    private DriveDTO drive2DTO;
  
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
        userDTO = userFacade.createUser(userDTO);
        
        carDTO = new CarDTO();
        carDTO.setFuel(Fuel.GASOLINE);
        carDTO.setManufacturer("Audi");
        carDTO.setModel("R8");
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
                        
        driveDTO = new DriveCreateDTO();        
        driveDTO.setUserId(userDTO.getId());
        driveDTO.setCarId(carDTO.getId());
        driveDTO.setBeginDate(new DateTime(2016, 5, 10, 10, 15).toDate());
        driveDTO.setEndDate(new DateTime(2016, 5, 10, 11, 15).toDate());
        driveDTO.setDistance(40);  
        
        drive2DTO = new DriveDTO();        
        drive2DTO.setUser(userDTO);
        drive2DTO.setCar(car2DTO);
        drive2DTO.setBeginDate(new DateTime(2016, 6, 10, 11, 15).toDate());
        drive2DTO.setEndDate(new DateTime(2016, 6, 10, 12, 15).toDate());
        drive2DTO.setDistance(40);  
    }
     
    @Test
    public void findDriveTest()
    {       
        drive2DTO = driveFacade.createDrive(driveDTO);

        DriveDTO driveDTO2 = driveFacade.findById(drive2DTO.getId());
        
        assertTrue(drive2DTO.equals(driveDTO2));
    }
    
    
    @Test
    public void updateDrive() {
    	drive2DTO = driveFacade.createDrive(driveDTO);                       
        drive2DTO.setCar(car2DTO);
        
        driveFacade.update(drive2DTO);
        
        DriveDTO drive2 = driveFacade.findById(drive2DTO.getId());
                
        assertEquals(drive2.getId(), drive2DTO.getId());
        assertEquals(drive2.getCar(), car2DTO);   
    }
}
