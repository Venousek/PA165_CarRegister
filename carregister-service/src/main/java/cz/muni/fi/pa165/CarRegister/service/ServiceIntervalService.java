/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;
import  cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;

import java.util.List;

/**
 *
 * @author robha
 */
public interface ServiceIntervalService {
    /**
     * Adds Service interval entry to the database and returns added entry.
     * 
     * @param interval  Service interval data to add.
     * @return ServiceInterval Entry that has been added to the database.
     */
    ServiceInterval create(ServiceInterval interval);
    
    /**
     * Updates/changes data of an entry in the database.
     * 
     * @param interval      ServiceInterval to modify.
     * @return  ServiceInterval  Modified Service interval.
     */
    ServiceInterval update(ServiceInterval interval);
    
    /**
     * Removes Service interval entry from the database.
     * 
     * @param interval  Service interval to be deleted.
     */
    void delete(ServiceInterval interval);
    
    /**
     * Returns all Service intervals from the database.
     * @return List<ServiceInterval>   Collection of Service interval objects.
     */
    List<ServiceInterval> findAll(); 
   
    /**
     * Returns certain Service interval identified by its id.
     * If given id is not present in the database returns null.
     * 
     * @param id Unique identifier generated by database.
     * @return Service interval object with given id or null if such entry does not exist.
     */
    ServiceInterval findById(Long id);
        
}
