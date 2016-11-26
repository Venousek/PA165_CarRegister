/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import static org.junit.Assert.assertEquals;
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

public class CarFacadeTest {
    @Inject
    private CarFacade carFacade;
    
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
        
        car2DTO = new CarDTO();
        car2DTO.setFuel(Fuel.GASOLINE);
        car2DTO.setManufacturer("Nissan");
        car2DTO.setModel("GTR");
        car2DTO.setMileage(50);
        car2DTO.setRegister_number("BLAZE420");
        car2DTO.setVin("ROFLSTOMP");
        car2DTO.setYear(2017);
    
    }

    @Test
    public void findCarTest() {
        carDTO = carFacade.createCar(carDTO);
        car2DTO = carFacade.createCar(car2DTO); 
        CarDTO foundCar = carFacade.findById(carDTO.getId());
        CarDTO foundCar2 = carFacade.findById(car2DTO.getId());
        assertTrue(carDTO.equals(foundCar));
        assertTrue(car2DTO.equals(foundCar2));
    }
    @Test
    public void findAllCarTest() {
        carDTO = carFacade.createCar(carDTO);
        car2DTO = carFacade.createCar(car2DTO); 
        List<CarDTO> cars= new ArrayList<CarDTO>();
        cars.add(carDTO);
        cars.add(car2DTO);
        assertTrue(cars.equals(carFacade.findAll()));
    }
    @Test
    public void findAllAvalibleCars() {
        carDTO = carFacade.createCar(carDTO);
        car2DTO = carFacade.createCar(car2DTO); 
        List<CarDTO> cars= new ArrayList<CarDTO>();
        cars.add(carDTO);
        cars.add(car2DTO);
        assertTrue(cars.equals(carFacade.findAll()));
    }
    @Test
    public void updateCar() {
    	carDTO = carFacade.createCar(carDTO);                       
        carDTO.setModel("Tesla");
        
        carFacade.update(carDTO);
        
        CarDTO car2 = carFacade.findById(carDTO.getId());
                
        assertEquals(car2.getId(), carDTO.getId());
        assertEquals(car2.getModel(), "Tesla");   
    }
    /*
    @Test
    public void deleteCar() {
    	carDTO = carFacade.createCar(carDTO);                       
        
        Long id = carDTO.getId();
        carFacade.remove(carDTO);
        
        CarDTO car = carFacade.findById(id);
                
        assertNull(car);
        
    }*/
    }