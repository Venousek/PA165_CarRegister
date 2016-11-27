/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;
import cz.muni.fi.pa165.CarRegister.dao.ServiceIntervalDao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import  cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.exception.CarRegisterDataAccessException;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author robha
 */
@Service
@Transactional
public class ServiceIntervalServiceImpl implements ServiceIntervalService {

    @Inject
    private ServiceIntervalDao serviceIntervalDao;

    @Inject
    private CarService carService;
    
    public void setServiceIntervalDAO(ServiceIntervalDao intervalDao) {
        this.serviceIntervalDao = intervalDao;
    }
    
    @Override
    public ServiceInterval create(ServiceInterval interval) {
        
        if (interval == null || interval.getCar() == null)
        {
            throw new CarRegisterDataAccessException("interval or car is null.");
        }

        Car foundCar = carService.findById(interval.getCar().getId());

        if (foundCar == null)
        {
            throw new CarRegisterDataAccessException("Car not found");
        }

        interval.setCar(foundCar);
        
        serviceIntervalDao.create(interval);
        return interval;
    }

    @Override
    public ServiceInterval update(ServiceInterval interval) {
        
        if (interval == null || interval.getCar() == null)
        {
            throw new CarRegisterDataAccessException("interval or car is null.");
        }

        Car foundCar = carService.findById(interval.getCar().getId());

        if (foundCar == null)
        {
            throw new CarRegisterDataAccessException("Car not found");
        }

        interval.setCar(foundCar);
        
        serviceIntervalDao.update(interval);
        return interval;
    }

    @Override
    public void delete(ServiceInterval interval) {
        ServiceInterval foundInterval = findById(interval.getId());
        
        serviceIntervalDao.delete(foundInterval); 
    }

    @Override
    public List<ServiceInterval> findAll() {
        return serviceIntervalDao.findAll();
    }

    @Override
    public ServiceInterval findById(Long id) {
        return serviceIntervalDao.findById(id);
    }
    
}
