package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.dto.DriveDTO;
import cz.muni.fi.pa165.CarRegister.dto.DriveCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.enums.Fuel;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import cz.muni.fi.pa165.CarRegister.facade.DriveFacade;
import cz.muni.fi.pa165.CarRegister.facade.CarFacade;
import cz.muni.fi.pa165.CarRegister.facade.UserFacade;
import cz.muni.fi.pa165.CarRegister.web.forms.DriveCreateDTOValidator;

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
 * @author Cernak
 */
@Controller
@RequestMapping("/drives")
public class DriveController {
    
    final static Logger log = LoggerFactory.getLogger(DriveController.class);

    @Inject
    private DriveFacade driveFacade;
    
    @Inject
    private CarFacade carFacade;
    
    @Inject
    private UserFacade userFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
       
        log.debug("Drive.list()");
        model.addAttribute("drives", driveFacade.findAll());
        return "drives/list";
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newDrive(Model model) {
        log.debug("drive.new()");
        model.addAttribute("driveCreate", new DriveCreateDTO());
        return "drives/create";
    }
   @ModelAttribute("cars")
    public List<CarDTO> cars() {
        log.debug("cars()");
        return carFacade.findAll();
    }
    @ModelAttribute("users")
    public List<UserDTO> users() {
        log.debug("users()");
        return userFacade.findAll();
    }
    
   @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("driveCreate")DriveCreateDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("drive.create(driveCreate={})", formBean);
        //in case of validation error forward back to the the form
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "drives/create";
        }
          
        DriveDTO dr = driveFacade.createDrive(formBean);
       
        redirectAttributes.addFlashAttribute("alert_success", "Drive" + dr.getId() + " has been created");
        return "redirect:" + uriBuilder.path("/serviceintervals/view/{id}").buildAndExpand(dr.getId()).encode().toUriString();
    }
    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    public String editItem(@Valid @ModelAttribute("drive") DriveDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("drive.edit(drive={})", formBean);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "redirect:" + uriBuilder.path("/drives/edit/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
        }
             
        DriveDTO dr = driveFacade.update(formBean);
        redirectAttributes.addFlashAttribute("alert_success", "Drive " + dr.getId() + " has been edited");
        return "redirect:" + uriBuilder.path("/drives/view/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
    }
    
    
   @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        log.debug("view({})", id);
        model.addAttribute("drive", driveFacade.findById(id));
        
        return "drives/view";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id,RedirectAttributes redirectAttributes,Model model, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        driveFacade.remove(driveFacade.findById(id));
        model.addAttribute("drives", driveFacade.findAll());
        redirectAttributes.addFlashAttribute("alert_warning", "Drive " + id + " has been deleted");
        return "redirect:" + uriBuilder.path("/drives/list/").buildAndExpand().encode().toUriString();
    }
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof DriveCreateDTO) {
            binder.addValidators(new DriveCreateDTOValidator());
        }
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        log.debug("edit({})", id);
        
        model.addAttribute("drive", driveFacade.findById(id));        
        
        return "drives/edit";
    }
   
}
