/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.User;
import java.util.List;

/**
 *
 * @author henrich
 */
public interface DriveService
{
    /**
     * Adds Drive entry to the database
     * 
     * @param drive Drive data to add
     * @return Drive data that has been added to the database
     */
    Drive create(Drive drive);
    
    /**
     * Modifies Drive data in the database
     * 
     * @param drive Drive data to modify
     * @return modified Drive data
     */
    Drive update(Drive drive);
    
    /**
     * Removes Drive data from the database
     * 
     * @param drive Drive data to remove
     */
    void delete(Drive drive);
    
    /**
     * Returns all Drive data from database
     * 
     * @return collection of drives
     */
    List<Drive> findAll();      
     
    /**
     * Returns Drive data identified by its id
     * 
     * @param id Unique identifier generated by database
     * @return Drive object with given id or null if no such entry
     */
    Drive findById(Long id); 
    
    /**
     * Starts a drive with car and user
     * 
     * @param car a car to drive
     * @param user an user in drive
     */
    Drive startUsingCar(Car car, User user);    
    
    /**
     * Stops a drive with car
     * 
     * @param car a car on drive
     * @param distance distance driven with car
     */
    Drive stopUsingCar(Car car, int distance);
}
