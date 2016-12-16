/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "cars/list";
    }
}
