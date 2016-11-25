package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.DriveDTO;
import java.util.List;

/**
 *
 * @author blahut
 */
public interface DriveFacade {
    
    /**
     * Creates Drive
     * @param drive Drive object as DTO
     * @return created object
     */
    DriveDTO createDrive(DriveDTO drive);

    /**
     * Gets All Drives
     * @return list of all Drives as DTO objects
     */
    List<DriveDTO> findAll();
    
    /**
     * Get Existing drive by id
     * @param id Drive id
     * @return DriveDto
     */
    DriveDTO findById(Long id);

    /**
     * Delete Drive by id
     * @param drive Drive object to remove
     */
    void remove(DriveDTO drive);

    /**
     * Update Drive object
     * @param drive Drive object as DTO
     * @return updated Drive DTO
     */
    DriveDTO update(DriveDTO drive);

}