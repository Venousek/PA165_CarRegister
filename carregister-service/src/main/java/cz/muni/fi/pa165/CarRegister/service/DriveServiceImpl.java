/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.dao.DriveDao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.exception.CarRegisterDataAccessException;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author Henrich
 */
@Service("driveService")
@Transactional
public class DriveServiceImpl implements DriveService
{
    @Inject
    private DriveDao driveDao;
    
    @Inject
    private CarService carService;
    
    @Inject
    private UserService userService;

    public void setCarDAO(DriveDao driveDao) {
        this.driveDao = driveDao;
    }
    
    @Override
    public Drive create(Drive drive)
    {
        if (drive == null || drive.getCar() == null || drive.getUser() == null)
        {
            throw new CarRegisterDataAccessException("Drive, car or user is null.");
        }
        
        Car foundCar = carService.findById(drive.getCar().getId());
       
        if (foundCar == null)
        {
            throw new CarRegisterDataAccessException("Car not found");
        }
        
        User foundUser = userService.findById(drive.getUser().getId());
       
        if (foundUser == null)
        {
            throw new CarRegisterDataAccessException("User not found");
        }
        
        drive.setCar(foundCar);
        drive.setUser(foundUser);
        
        driveDao.create(drive);
        return drive;
    }

    @Override
    public Drive update(Drive drive)
    {
        if (drive == null || drive.getCar() == null || drive.getUser() == null)
        {
            throw new CarRegisterDataAccessException("Drive, car or user is null.");
        }
        
        Car foundCar = carService.findById(drive.getCar().getId());
       
        if (foundCar == null)
        {
            throw new CarRegisterDataAccessException("Car not found");
        }
        
        User foundUser = userService.findById(drive.getUser().getId());
       
        if (foundUser == null)
        {
            throw new CarRegisterDataAccessException("User not found");
        }
        
        drive.setCar(foundCar);
        drive.setUser(foundUser);
        
        driveDao.update(drive);
        return drive;
    }

    @Override
    public void delete(Drive drive)
    {
        Drive foundDrive = findById(drive.getId());
        
        driveDao.delete(foundDrive);
    }

    @Override
    public List<Drive> findAll()
    {
        return driveDao.findAll();
    }

    @Override
    public Drive findById(Long id)
    {
        return driveDao.findById(id);
    }   
    
    @Override
    public Drive startUsingCar(Car car, User user)
    {
        if (car == null)
            throw new NullPointerException("car");
        if (user == null)
            throw new NullPointerException("user");
        
        Car foundCar = carService.findById(car.getId());
       
        if (foundCar == null)
        {
            throw new CarRegisterDataAccessException("Car not found");
        }
        
        List<Drive> drives = driveDao.findAllByCar(car);
         
        if (drives != null && !drives.isEmpty() && drives.get(drives.size() - 1).getEnd() == null)      
        {
            throw new CarRegisterDataAccessException("Car is already on drive");
        }
        
        Drive drive = new Drive();
        drive.setCar(car);
        drive.setUser(user);
        drive.setBegin(DateTime.now());
        drive.setEnd(null);
        drive.setDistance(0);
        
        return this.create(drive);
    }
     
    @Override
    public Drive stopUsingCar(Car car, int distance)
    {     
        if (car == null)
        {
            throw new NullPointerException("car");
        }
                
        Car foundCar = carService.findById(car.getId());
       
        if (foundCar == null)
        {         
            throw new CarRegisterDataAccessException("Car not found");
        }
        
        List<Drive> drives = driveDao.findAllByCar(car);
        
        if (drives == null || drives.isEmpty())
        {   
            throw new CarRegisterDataAccessException("Car has no drives");
        }
        
        Drive drive = drives.get(drives.size() - 1);
        
        if (drive.getEnd() != null)
        {      
            throw new CarRegisterDataAccessException("Car is not on drive");
        }
        
        drive.setEnd(DateTime.now());
        drive.setDistance(distance);
        
        return this.update(drive);
    }
}
