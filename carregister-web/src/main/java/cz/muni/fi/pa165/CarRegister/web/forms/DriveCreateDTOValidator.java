package cz.muni.fi.pa165.CarRegister.web.forms;

import cz.muni.fi.pa165.CarRegister.dto.DriveCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Cernak
 */
public class DriveCreateDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return DriveCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DriveCreateDTO createDTO = (DriveCreateDTO) target;
        if (createDTO.getBeginDate()== null) return;
        if (createDTO.getEndDate()== null) return;
        if (createDTO.getBeginDate().after(createDTO.getEndDate()))
            errors.rejectValue("end", "drives.err");
    }
}