package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import java.util.List;

/**
 *
 * @author blahut
 */
public interface CarFacade {
    
    /**
     * Creates Car
     * @param car Car object as DTO
     * @return created object
     */
    CarDTO createCar(CarDTO car);

    /**
     * Gets All Cars
     * @return list of all Cars as DTO objects
     */
    List<CarDTO> findAll();
    
    /**
     * Gets All Available Cars
     * @return list of all available Cars as DTO objects
     */
    List<CarDTO> findAllAvailable();

    /**
     * Get Existing car by id
     * @param id Car id
     * @return CarDto
     */
    CarDTO findById(Long id);

    /**
     * Delete Car by id
     * @param car Car object to remove
     */
    void remove(CarDTO car);

    /**
     * Update Car object
     * @param car Car object as DTO
     * @return updated Car DTO
     */
    CarDTO update(CarDTO car);

}