/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.facade.CarFacade;
import cz.muni.fi.pa165.CarRegister.facade.ServiceIntervalFacade;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author robha
 */
@Controller
@RequestMapping("/serviceintervals")
public class ServiceIntervalController {
    
    final static Logger log = LoggerFactory.getLogger(UserController.class);

  //  @Inject
 //   private ServiceIntervalFacade serviceIntervalFacade;
 //   @Inject
  //  private CarFacade carFacade;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<ServiceIntervalDTO> intervals =  new ArrayList();
        log.debug("serviceInterval.list()");
        //model.addAttribute("intervals", serviceIntervalFacade.findAll());
        intervals.addAll(fakeData());
        model.addAttribute("intervals", intervals);
        return "serviceintervals/list";
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newServiceInterval(Model model) {
        log.debug("serviceInterval.new()");
        model.addAttribute("intervalCreate", new ServiceIntervalCreateDTO());
        return "serviceintervals/create";
    }
   @ModelAttribute("cars")
    public List<CarDTO> cars() {
        log.debug("cars()");
        return fakeDataCars();
       //return carFacade.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("intervalCreate") ServiceIntervalCreateDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("serviceInterval.create(intervalCreate={})", formBean);
        //in case of validation error forward back to the the form
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
                log.trace("FieldError: {}", fe);
            }
            return "serviceintervals/new";
        }
          //create product
          Long id = 1L;
          //Long id = serviceIntervalFacade.createInterval(formBean);
        //report success
        redirectAttributes.addFlashAttribute("alert_success", "Service interval " + id + " was created");
        return "redirect:" + uriBuilder.path("/serviceintervals/view/{id}").buildAndExpand(id).encode().toUriString();
    }
    
    private List<ServiceIntervalDTO> fakeData() {
            List<ServiceIntervalDTO> intervals = new ArrayList();
        CarDTO y = new CarDTO();
        y.setId(2L);
        y.setFuel(Fuel.DIESEL);
        y.setManufacturer("Nissan");
        y.setModel("GTR");
        y.setRegister_number("1235");
        y.setMileage(50);
        y.setYear(1505);
        y.setVin("asdasd");
        CarDTO y2 = new CarDTO();
        y2.setId(1L);
        y2.setFuel(Fuel.GASOLINE);
        y2.setManufacturer("SKODA");
        y2.setModel("RX");
        y2.setRegister_number("55235");
        y2.setMileage(550);
        y2.setYear(1905);
        y2.setVin("rrrrr");
        
        ServiceIntervalDTO x = new ServiceIntervalDTO();
        x.setBeginLong(DateTime.now().getMillis());
        x.setEndLong(DateTime.now().getMillis());
        x.setVisitedLong(DateTime.now().getMillis());
        x.setCar(y);
        x.setId(1L);
        ServiceIntervalDTO x2 = new ServiceIntervalDTO();
        x2.setBeginLong(DateTime.now().getMillis()-4);
        x2.setEndLong(DateTime.now().getMillis()-4);
        x2.setVisitedLong(DateTime.now().getMillis()-4);
        x2.setCar(y2);
        x2.setId(2L);
        
        intervals.add(x);
        intervals.add(x2);
        return intervals;
    }
    private List<CarDTO> fakeDataCars() {
            List<CarDTO> cars = new ArrayList();
        CarDTO y = new CarDTO();
        y.setId(2L);
        y.setFuel(Fuel.DIESEL);
        y.setManufacturer("Nissan");
        y.setModel("GTR");
        y.setRegister_number("1235");
        y.setMileage(50);
        y.setYear(1505);
        y.setVin("asdasd");
        CarDTO y2 = new CarDTO();
        y2.setId(1L);
        y2.setFuel(Fuel.GASOLINE);
        y2.setManufacturer("SKODA");
        y2.setModel("RX");
        y2.setRegister_number("55235");
        y2.setMileage(550);
        y2.setYear(1905);
        y2.setVin("rrrrr");     
        cars.add(y);
        cars.add(y2);
        return cars;
    }
}