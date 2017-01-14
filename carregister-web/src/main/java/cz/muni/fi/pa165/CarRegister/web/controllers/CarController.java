/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.facade.CarFacade;
import cz.muni.fi.pa165.CarRegister.web.forms.CarDTOValidator;
import javax.inject.Inject;
import javax.validation.Valid;
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
 * @author Henrich
 */
@Controller
@RequestMapping("/cars")
public class CarController
{
    final static Logger log = LoggerFactory.getLogger(CarController.class);
    
    @Inject
    private CarFacade carFacade;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof CarDTO) {
            binder.addValidators(new CarDTOValidator());
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("Showing cars list");
        model.addAttribute("cars", carFacade.findAll());        
        return "cars/list";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listAdmin(Model model) {
        log.debug("Showing cars list (admin mode)");
        model.addAttribute("cars", carFacade.findAll());          
        return "cars/admin";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(Model model) {  
        log.debug("New car");
        model.addAttribute("car", new CarDTO());
        return "cars/create";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String created(@Valid @ModelAttribute("car") CarDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("Created car {}", formBean);
          
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "cars/create";
        }
        
        CarDTO car = carFacade.createCar(formBean);
       
        redirectAttributes.addFlashAttribute("alert_success", "Car " + car.getId() + " was created");
        return "redirect:" + uriBuilder.path("/cars/view/{id}").buildAndExpand(car.getId()).encode().toUriString();
    }
    
    
   @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        log.debug("view({})", id);

        model.addAttribute("car", carFacade.findById(id));
        
        return "cars/view";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        log.debug("edit({})", id);
        model.addAttribute("car", carFacade.findById(id));        
        return "cars/edit";
    }
    
    @RequestMapping(value = "/edited", method = RequestMethod.POST)
    public String edited(@Valid @ModelAttribute("car") CarDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("Edit car {}", formBean);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "redirect:" + uriBuilder.path("/cars/edit/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
        }
        
        CarDTO car = carFacade.update(formBean);
             
        redirectAttributes.addFlashAttribute("alert_success", "Car " + car.getId() + " was edited");
        return "redirect:" + uriBuilder.path("/cars/view/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
    }
    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id,RedirectAttributes redirectAttributes,Model model, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        carFacade.remove(carFacade.findById(id));
        model.addAttribute("cars", carFacade.findAll());
        redirectAttributes.addFlashAttribute("alert_warning", "Car " + id + " was deleted");
        return "redirect:" + uriBuilder.path("/cars/admin").buildAndExpand().encode().toUriString();
    }
    
    
    @ModelAttribute("fuels")
    public Fuel[] fuels() {
        log.debug("fuels()");
       
        return Fuel.values();
    }
}
