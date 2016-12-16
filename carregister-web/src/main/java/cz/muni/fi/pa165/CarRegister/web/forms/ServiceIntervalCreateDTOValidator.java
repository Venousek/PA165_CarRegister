/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.web.forms;

import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author robha
 */
public class ServiceIntervalCreateDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ServiceIntervalCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceIntervalCreateDTO createDTO = (ServiceIntervalCreateDTO) target;
        if (createDTO.getBeginDate() == null) return;
        if (createDTO.getEndDate() == null) return;
        if (createDTO.getBeginDate().after(createDTO.getEndDate()))
            errors.rejectValue("end", "intervals.err");
    }
}
