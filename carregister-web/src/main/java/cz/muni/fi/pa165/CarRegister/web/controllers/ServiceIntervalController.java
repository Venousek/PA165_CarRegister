/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.facade.CarFacade;
import cz.muni.fi.pa165.CarRegister.facade.ServiceIntervalFacade;
import cz.muni.fi.pa165.CarRegister.web.forms.ServiceIntervalCreateDTOValidator;
import java.util.List;
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
 * @author robha
 */
@Controller
@RequestMapping("/serviceintervals")
public class ServiceIntervalController {
    
    final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Inject
    private ServiceIntervalFacade serviceIntervalFacade;

    @Inject
    private CarFacade carFacade;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
       
        log.debug("serviceInterval.list()");
        model.addAttribute("intervals", serviceIntervalFacade.findAll());        
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
       
        return carFacade.findAll();
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
          
        ServiceIntervalDTO si = serviceIntervalFacade.createServiceInterval(formBean);
       
        redirectAttributes.addFlashAttribute("alert_success", "Service interval " + si.getId() + " was created");
        return "redirect:" + uriBuilder.path("/serviceintervals/view/{id}").buildAndExpand(si.getId()).encode().toUriString();
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

        model.addAttribute("interval", serviceIntervalFacade.findById(id));
        
        return "serviceintervals/view";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id,RedirectAttributes redirectAttributes,Model model, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        serviceIntervalFacade.remove(serviceIntervalFacade.findById(id));
        serviceIntervalFacade.remove(serviceIntervalFacade.findById(id));
        model.addAttribute("intervals", serviceIntervalFacade.findAll());
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
        
        model.addAttribute("interval", serviceIntervalFacade.findById(id));        
        
        return "serviceintervals/edit";
    }
    
}