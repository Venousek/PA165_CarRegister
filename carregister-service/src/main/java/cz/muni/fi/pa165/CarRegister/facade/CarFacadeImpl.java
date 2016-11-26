/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.CarDTO;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.service.BeanMappingService;
import cz.muni.fi.pa165.CarRegister.service.CarService;
import cz.muni.fi.pa165.exception.CarRegisterDataAccessException;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author robha
 */
@Service("carFacade")
@Transactional
public class CarFacadeImpl implements CarFacade {
    @Inject
    private CarService carService;

    @Inject
    private BeanMappingService beanMappingService;
    
    @Override
    public CarDTO createCar(CarDTO car) {
     try {
        Car carMapped = beanMappingService.mapTo(car, Car.class);
        Car created = carService.create(carMapped);
        car =  beanMappingService.mapTo(created, CarDTO.class);
        return car;
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot create car",e);
        }
    }

    @Override
    public List<CarDTO> findAll() {
        try {
            return beanMappingService.mapTo(carService.findAll(), CarDTO.class);
         } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find all cars",e);
        }
    }

    @Override
    public List<CarDTO> findAllAvailable() {
         try {
            return beanMappingService.mapTo(carService.findAllAvailable(), CarDTO.class);
         } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find all cars",e);
        }
    }

    @Override
    public CarDTO findById(Long id) {
         try {
            Car carMapped = carService.findById(id);
            if(carMapped == null) 
                return null;
            else 
                return beanMappingService.mapTo(carMapped, CarDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find car by id",e);
        }
    }

    @Override
    public void remove(CarDTO car) {
         try {
            Car carMapped = beanMappingService.mapTo(car, Car.class);
            carService.delete(carMapped);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot remove car",e);
        }
    }

    @Override
    public CarDTO update(CarDTO car) {
         try {
            Car carMapped = beanMappingService.mapTo(car, Car.class);
            
            Car updated = carService.update(carMapped);
            return beanMappingService.mapTo(updated, CarDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot update car",e);
        }
    }
}
