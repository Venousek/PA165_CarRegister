package cz.muni.fi.pa165.CarRegister.web.forms;

import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author blahut
 */
public class UserDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO createDTO = (UserDTO) target;
        
        if (createDTO.getLogin() == null || createDTO.getLogin().isEmpty())
            errors.rejectValue("login", "users.err");
        
        if (createDTO.getPassword() == null || createDTO.getPassword().length() < 4 || createDTO.getPassword().length() > 255)
            errors.rejectValue("password", "users.err");
        
        if (createDTO.getFirstname() == null || createDTO.getFirstname().isEmpty())
            errors.rejectValue("firstname", "users.err");
        
        if (createDTO.getLastname() == null || createDTO.getLastname().isEmpty())
            errors.rejectValue("lastname", "users.err");
                
        if (createDTO.getEmail() == null || createDTO.getEmail().isEmpty())
            errors.rejectValue("email", "users.err");
                
        if (createDTO.getRole() == null)
            errors.rejectValue("role", "users.err");
        
    }
}
