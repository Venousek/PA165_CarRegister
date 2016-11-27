package cz.muni.fi.pa165.CarRegister.dao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import java.util.List;

/**
 *
 * @author robha
 */
public interface DriveDao {
                
    /**
     * Creates new drive in DB.
     * 
     * @param drive to create
     */
    void create(Drive drive);
    
    /**
     * Retrieves drive with specified ID from DB.
     * 
     * @param id
     * @return drive with specified ID
     */
    Drive findById(Long id);
    
    /**
     * Retrieves all drives from DB.
     * 
     * @return all drives existing in DB
     */
    List<Drive> findAll();
    
    /**
     * Retrieves all drives from DB for defined car.
     * 
     * @return all car's drives existing in DB
     */
    List<Drive> findAllByCar(Car car);
    
    /**
     *  Updates drive record in DB.
     * 
     * @param drive to update
     */
    void update(Drive drive);
    
    /**
     * Removes drive record from DB.
     * 
     * @param drive to remove
     */
    void delete(Drive drive);    
    
}
