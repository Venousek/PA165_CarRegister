package cz.muni.fi.pa165.CarRegister.rest.consts;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author blahut
 */
@XmlRootElement
public class ApiError {
    
    private List<String> errors;

    public ApiError() {
    }

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
