/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import java.util.List;

/**
 *
 * @author blahut
 */
public interface CarDao {
            
    /**
     * Creates new car in DB.
     * 
     * @param car to create
     */
    void create(Car car);
    
    /**
     * Retrieves car with specified ID from DB.
     * 
     * @param id
     * @return car with specified ID
     */
    Car findById(Long id);
    
    /**
     * Retrieves all cars from DB.
     * 
     * @return all cars existing in DB
     */
    List<Car> findAll();
    
    /**
     *  Updates car record in DB.
     * 
     * @param car to update
     */
    void update(Car car);
    
    /**
     * Removes car record from DB.
     * 
     * @param car to remove
     */
    void delete(Car car);    
    
    /**
     * Returns all Cars from the database that are available for usage at the moment
     * meaning they are not being used right now and have not exceeded mileage limit
     * 
     * @return all cars existing in DB
     */
    List<Car> findAllAvailable();
}
