package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import java.util.List;

/**
 *
 * @author blahut
 */
public interface ServiceIntervalFacade {
    
    /**
     * Creates ServiceInterval
     * @param serviceInterval ServiceInterval object as DTO
     * @return created object
     */
    ServiceIntervalDTO createServiceInterval(ServiceIntervalCreateDTO serviceInterval);

    /**
     * Gets All ServiceIntervals
     * @return list of all ServiceIntervals as DTO objects
     */
    List<ServiceIntervalDTO> findAll();
    
    /**
     * Get Existing serviceInterval by id
     * @param id ServiceInterval id
     * @return ServiceIntervalDto
     */
    ServiceIntervalDTO findById(Long id);

    /**
     * Delete ServiceInterval by id
     * @param serviceInterval ServiceInterval object to remove
     */
    void remove(ServiceIntervalDTO serviceInterval);

    /**
     * Update ServiceInterval object
     * @param serviceInterval ServiceInterval object as DTO
     * @return updated ServiceInterval DTO
     */
    ServiceIntervalDTO update(ServiceIntervalDTO serviceInterval);

}