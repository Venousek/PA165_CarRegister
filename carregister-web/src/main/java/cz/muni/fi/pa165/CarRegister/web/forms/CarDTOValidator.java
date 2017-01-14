/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.forms;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Henrich
 */
public class CarDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CarDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDTO createDTO = (CarDTO) target;
        
        if (createDTO.getManufacturer() == null || createDTO.getManufacturer().isEmpty())
            errors.rejectValue("manufacturer", "cars.err.empty");
        
        if (createDTO.getModel()== null || createDTO.getModel().isEmpty())
            errors.rejectValue("model", "cars.err.empty");
        
        if (createDTO.getRegister_number()== null || createDTO.getRegister_number().isEmpty())
            errors.rejectValue("register_number", "cars.err.empty");
        
        if (createDTO.getVin()== null || createDTO.getVin().isEmpty())
            errors.rejectValue("vin", "cars.err.empty");       
        
        if (createDTO.getYear() < 1900) // but 1st car is from 1672 :)
            errors.rejectValue("year", "cars.err.year");       

        if (createDTO.getMileage() < 0)
            errors.rejectValue("mileage", "cars.err"); 
        
    }
}