/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.entities.Drive;
import java.util.List;

/**
 *
 * @author henrich
 */
public interface DriveService
{
    Drive create(Drive drive);
    
    Drive update(Drive drive);
    
    void delete(Drive drive);
    
     List<Drive> findAll();      
     
     Drive findById(Long id); 
}
