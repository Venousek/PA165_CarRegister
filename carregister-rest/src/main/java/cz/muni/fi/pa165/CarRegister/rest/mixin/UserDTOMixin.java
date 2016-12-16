package cz.muni.fi.pa165.CarRegister.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author blahut
 */
@JsonIgnoreProperties({ "password"})
public class UserDTOMixin {
    
}
