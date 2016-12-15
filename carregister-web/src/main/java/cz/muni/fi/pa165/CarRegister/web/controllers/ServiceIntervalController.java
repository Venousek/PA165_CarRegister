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
import cz.muni.fi.pa165.CarRegister.web.forms.ServiceIntervalCreateDTOValidator;
import java.time.Instant;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ServiceIntervalFacade serviceIntervalFacade;
 //   @Inject
  //  private CarFacade carFacade;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
       
        log.debug("serviceInterval.list()");
        //model.addAttribute("intervals", serviceIntervalFacade.findAll());
         List<ServiceIntervalDTO> intervals =  new ArrayList();
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
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "serviceintervals/create";
        }
          
          Long id = 1L;
          //Long id = serviceIntervalFacade..createServiceInterval(formBean);
       
        redirectAttributes.addFlashAttribute("alert_success", "Service interval " + id + " was created");
        return "redirect:" + uriBuilder.path("/serviceintervals/view/{id}").buildAndExpand(id).encode().toUriString();
    }
    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    public String editItem(@Valid @ModelAttribute("interval") ServiceIntervalCreateDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("serviceInterval.edit(interval={})", formBean);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "redirect:" + uriBuilder.path("/serviceintervals/edit/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
        }
             
        redirectAttributes.addFlashAttribute("alert_success", "Service interval " + formBean.getId() + " was edited");
        return "redirect:" + uriBuilder.path("/serviceintervals/view/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
    }
    
    
   @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        log.debug("view({})", id);
        //model.addAttribute("interval", serviceIntervalFacade.findId(id));
        ServiceIntervalDTO interval = fakeDataInterval();
        model.addAttribute("interval", interval);
        
        return "serviceintervals/view";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id,RedirectAttributes redirectAttributes,Model model, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
       // serviceIntervalFacade.remove(serviceIntervalFacade.findById(id));
       // serviceIntervalFacade.remove(serviceIntervalFacade.findById(id));
        //model.addAttribute("intervals", serviceIntervalFacade.findAll());
         List<ServiceIntervalDTO> intervals =  new ArrayList();
        intervals.addAll(fakeData());
        model.addAttribute("intervals", intervals);
        redirectAttributes.addFlashAttribute("alert_warning", "Service interval " + id + " was deleted");
        return "redirect:" + uriBuilder.path("/serviceintervals/list/").buildAndExpand().encode().toUriString();
    }
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof ServiceIntervalCreateDTO) {
            binder.addValidators(new ServiceIntervalCreateDTOValidator());
        }
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        log.debug("edit({})", id);
        //model.addAttribute("interval", serviceIntervalFacade.findById(id));
        ServiceIntervalCreateDTO interval = fakeDataIntervalForEdit();
        model.addAttribute("interval", interval);
        return "serviceintervals/edit";
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
        
       
        ServiceIntervalDTO x2 = new ServiceIntervalDTO();
        x2.setBeginLong(DateTime.now().getMillis()-4);
        x2.setEndLong(DateTime.now().getMillis()-4);
        x2.setVisitedLong(DateTime.now().getMillis()-4);
        x2.setCar(y2);
        x2.setId(2L);
        
        intervals.add(fakeDataInterval());
        intervals.add(x2);
        return intervals;
    }
    private ServiceIntervalDTO fakeDataInterval() {
           
        ServiceIntervalDTO x = new ServiceIntervalDTO();
        x.setBeginLong(DateTime.now().getMillis());
        x.setEndLong(DateTime.now().getMillis());
        x.setVisitedLong(DateTime.now().getMillis());
        x.setCar(fakeDataCar());
        x.setId(1L);
      
        return x;
    }
    private ServiceIntervalCreateDTO fakeDataIntervalForEdit() {
           
        ServiceIntervalCreateDTO x = new ServiceIntervalCreateDTO();
        x.setBegin(new Date());
        x.setEnd(new Date());
        x.setVisited(new Date());
        x.setCarId(fakeDataCar().getId());
        x.setId(1L);
      
        return x;
    }
   private CarDTO fakeDataCar() {
           
        CarDTO y = new CarDTO();
        y.setId(1L);
        y.setFuel(Fuel.GASOLINE);
        y.setManufacturer("Nissan");
        y.setModel("GTR");
        y.setRegister_number("1235");
        y.setMileage(50);
        y.setYear(1505);
        y.setVin("asdasd");
      
        return y;
    }
    private List<CarDTO> fakeDataCars() {
            List<CarDTO> cars = new ArrayList();

        CarDTO y2 = new CarDTO();
        y2.setId(2L);
        y2.setFuel(Fuel.DIESEL);
        y2.setManufacturer("SKODA");
        y2.setModel("RX");
        y2.setRegister_number("55235");
        y2.setMileage(550);
        y2.setYear(1905);
        y2.setVin("rrrrr");     
        cars.add(fakeDataCar());
        cars.add(y2);
        return cars;
    }
}