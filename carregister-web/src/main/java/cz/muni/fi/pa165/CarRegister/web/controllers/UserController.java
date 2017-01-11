package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.enums.Role;
import cz.muni.fi.pa165.CarRegister.facade.UserFacade;
import cz.muni.fi.pa165.CarRegister.web.forms.UserDTOValidator;
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
 * @author blahut
 */
@Controller
@RequestMapping("/users")
public class UserController {
    
    final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserFacade userFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userFacade.findAll());
        return "users/list";
    }
    
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        log.debug("user.new()");
        model.addAttribute("user", new UserDTO());
        return "users/create";
    }
        
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("user") UserDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("user.create(user={})", formBean);
        //in case of validation error forward back to the the form
        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "users/create";
        }
        
        UserDTO u = userFacade.createUser(formBean);
       
        redirectAttributes.addFlashAttribute("alert_success", "User " + u.getLogin() + " was created");
        return "redirect:" + uriBuilder.path("/users/view/{id}").buildAndExpand(u.getId()).encode().toUriString();
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model) {
        log.debug("User.edit({})", id);
        
        model.addAttribute("user", userFacade.findById(id));        
        
        return "users/edit";
    }
    
    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    public String editItem(@Valid @ModelAttribute("user") UserDTO formBean, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        log.debug("User.edit(user={})", formBean);

        if (bindingResult.hasErrors()) {
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.trace("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error",true);
                log.trace("FieldError: {}", fe);
            }
            return "redirect:" + uriBuilder.path("/users/edit/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
        }
        
        UserDTO u = userFacade.update(formBean);
             
        redirectAttributes.addFlashAttribute("alert_success", "User " + u.getLogin() + " was edited");
        return "redirect:" + uriBuilder.path("/users/view/{id}").buildAndExpand(formBean.getId()).encode().toUriString();
    }
    
    
   @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        log.debug("User.view({})", id);

        model.addAttribute("user", userFacade.findById(id));
        
        return "users/view";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes,
            Model model, UriComponentsBuilder uriBuilder) {
        log.debug("User.delete({})", id);
        userFacade.remove(userFacade.findById(id));
        model.addAttribute("users", userFacade.findAll());
        redirectAttributes.addFlashAttribute("alert_warning", "User " + id + " was deleted");
        return "redirect:" + uriBuilder.path("/users/list/").buildAndExpand().encode().toUriString();
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof UserDTO) {
            binder.addValidators(new UserDTOValidator());
        }
    }
    
    @ModelAttribute("roles")
    public Role[] roles() {
        log.debug("roles()");
       
        return Role.values();
    }
}
