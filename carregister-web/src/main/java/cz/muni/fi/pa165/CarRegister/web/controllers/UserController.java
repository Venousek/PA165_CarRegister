package cz.muni.fi.pa165.CarRegister.web.controllers;

import cz.muni.fi.pa165.CarRegister.facade.UserFacade;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
