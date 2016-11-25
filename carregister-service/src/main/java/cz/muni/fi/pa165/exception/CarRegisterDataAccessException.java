/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.exception;

import org.springframework.dao.DataAccessException;

/**
 *
 * @author robha
 */
public class CarRegisterDataAccessException extends DataAccessException {
  
    public CarRegisterDataAccessException(String msg) {
        super(msg);
    }

    public CarRegisterDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
