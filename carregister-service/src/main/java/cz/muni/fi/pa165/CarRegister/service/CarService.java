package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import java.util.List;

/**
 *
 * @author blahut
 */
public interface CarService {
    
    /**
     * Adds Car entry to the database and returns added entry.
     * 
     * @param car  Car data to add.
     * @return Car Entry that has been added to the database.
     */
    Car create(Car car);
    
    /**
     * Updates/changes data of an entry in the database.
     * 
     * @param car      Car to modify.
     * @return  Car    Modified car.
     */
    Car update(Car car);
    
    /**
     * Removes Car entry from the database.
     * 
     * @param car  Car to be deleted.
     */
    void delete(Car car);
    
    /**
     * Returns all Cars from the database.
     * @return List<Car>   Collection of Car objects.
     */
    List<Car> findAll(); 
        
    /**
     * Returns all Cars from the database that are available for usage at the moment
     * meaning they are not being used right now and have not exceeded mileage limit
     * @return List<Car>   Collection of available Car objects.
     */
    List<Car> findAllAvailable();
    
    /**
     * Returns certain Car identified by its id.
     * If given id is not present in the database returns null.
     * 
     * @param id Unique identifier generated by database.
     * @return Car Car object with given id or null if such entry does not exist.
     */
    Car findById(Long id);
        
        
}