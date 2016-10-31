/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import java.util.List;

/**
 *
 * @author robha
 */
public interface ServiceIntervalDao {
                
    /**
     * Creates new service interval in DB.
     * 
     * @param serviceInterval to create
     */
    void create(ServiceInterval serviceInterval);
    
    /**
     * Retrieves service interval with specified ID from DB.
     * 
     * @param id
     * @return service interval with specified ID
     */
    ServiceInterval findById(Long id);
    
    /**
     * Retrieves all service intervals from DB.
     * 
     * @return all service intervals existing in DB
     */
    List<ServiceInterval> findAll();
    
    /**
     *  Updates service interval record in DB.
     * 
     * @param serviceInterval to update
     */
    void update(ServiceInterval serviceInterval);
    
    /**
     * Removes service interval record from DB.
     * 
     * @param serviceInterval to remove
     */
    void delete(ServiceInterval serviceInterval);    
}
