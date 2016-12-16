/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Henrich
 */
@Controller
@RequestMapping("/cars")
public class CarController
{
    final static Logger log = LoggerFactory.getLogger(CarController.class);
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.info("Showing cars list");
        
        List<CarDTO> cars =  new ArrayList();
        cars.add(createFakeCar("4E"));        
        cars.add(createFakeCar("AAW"));
        model.addAttribute("cars", cars);
        
        return "cars/list";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listAdmin(Model model) {
        return list(model);
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {
        log.info("Create car");
        return "cars/create";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder)
    {        
        log.info("Car created");
        return "cars/list";
    }
    
   private CarDTO createFakeCar(String salt) {
           
        CarDTO car = new CarDTO();
        car.setId(1L);
        car.setFuel(Fuel.GASOLINE);
        car.setManufacturer("Nissan");
        car.setModel("GTR");
        car.setRegister_number("1AK35" + salt + "7S");
        car.setMileage(50);
        car.setYear(1505);
        car.setVin("de0" + salt + "assd");
        return car;
    }
}
