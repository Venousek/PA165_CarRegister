/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.DriveCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.DriveDTO;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.service.BeanMappingService;
import cz.muni.fi.pa165.CarRegister.service.CarService;
import cz.muni.fi.pa165.CarRegister.service.DriveService;
import cz.muni.fi.pa165.CarRegister.service.UserService;
import cz.muni.fi.pa165.exception.CarRegisterDataAccessException;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author henrich
 */
@Service("driveFacade")
@Transactional
public class DriveFacadeImpl implements DriveFacade
{
    @Inject
    private DriveService driveService;
    @Inject
    private CarService carService;
    @Inject
    private UserService userService;
    @Inject
    private BeanMappingService beanMappingService;
    
    @Override
    public DriveDTO createDrive(DriveCreateDTO drive)
    {
        try {
        Drive drive1 = new Drive();
        drive1.setCar(carService.findById(drive.getCarId()));
        drive1.setBeginDate(drive.getBeginDate());
        drive1.setEndDate(drive.getEndDate());
        drive1.setDistance(drive.getDistance());
        
        Drive created = driveService.create(drive1);
        return beanMappingService.mapTo(created, DriveDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot create drive",e);
        }
    }



    @Override
    public List<DriveDTO> findAll()
    {
        try
        {
            return beanMappingService.mapTo(driveService.findAll(), DriveDTO.class);
        }
        catch (Exception e)
        {
            throw new CarRegisterDataAccessException("cannot find all drives", e);
        }
    }
    

    @Override
    public DriveDTO findById(Long id)
    {
        try {
            Drive driveMapped = driveService.findById(id);
            
            if(driveMapped == null) 
                return null;
            else 
                return beanMappingService.mapTo(driveMapped, DriveDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find drive by id", e);
        }
           
    }
    
    @Override
    public void remove(DriveDTO drive)
    {
        try {
            Drive carMapped = beanMappingService.mapTo(drive, Drive.class);
            driveService.delete(carMapped);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot remove drive", e);
        }
    }

    @Override
    public DriveDTO update(DriveDTO drive)
    {
        try {
            Drive driveMapped = beanMappingService.mapTo(drive, Drive.class);       
            Drive updated = driveService.update(driveMapped);
            
            return beanMappingService.mapTo(updated, DriveDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot update drive",e);
        }
    }
}
