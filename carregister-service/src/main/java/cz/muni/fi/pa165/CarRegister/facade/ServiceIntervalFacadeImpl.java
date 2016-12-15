/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalCreateDTO;
import cz.muni.fi.pa165.CarRegister.dto.ServiceIntervalDTO;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import cz.muni.fi.pa165.CarRegister.service.BeanMappingService;
import cz.muni.fi.pa165.CarRegister.service.CarService;
import cz.muni.fi.pa165.CarRegister.service.ServiceIntervalService;
import cz.muni.fi.pa165.exception.CarRegisterDataAccessException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author robha
 */
@Service("serviceIntervalFacade")
public class ServiceIntervalFacadeImpl implements ServiceIntervalFacade {

    @Inject
    private ServiceIntervalService serviceIntervalService;
    @Inject
    private CarService carService;
    @Inject
    private BeanMappingService beanMappingService;
    
    @Override
    public ServiceIntervalDTO createServiceInterval(ServiceIntervalCreateDTO serviceInterval) {
       try {
        ServiceInterval interval = new ServiceInterval();
        interval.setCar(carService.findById(serviceInterval.getCarId()));
        interval.setBeginLong(serviceInterval.getBegin().getTime());
        interval.setEndLong(serviceInterval.getEnd().getTime());
        interval.setVisitedLong(serviceInterval.getVisited().getTime());
        
        ServiceInterval created = serviceIntervalService.create(interval);
        return beanMappingService.mapTo(created, ServiceIntervalDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot create service interval",e);
        }
    }

    @Override
    public List<ServiceIntervalDTO> findAll() {
         try {
            return beanMappingService.mapTo(serviceIntervalService.findAll(), ServiceIntervalDTO.class);
         } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find all service intervals",e);
        }
    }

    @Override
    public ServiceIntervalDTO findById(Long id) {
        try {
            ServiceInterval interval = serviceIntervalService.findById(id);
            return (interval == null) ? null : beanMappingService.mapTo(interval, ServiceIntervalDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find service interval by id",e);
        }
    }

    @Override
    public void remove(ServiceIntervalDTO serviceInterval) {
        try {
            ServiceInterval interval = beanMappingService.mapTo(serviceInterval, ServiceInterval.class);
            serviceIntervalService.delete(interval);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot remove service interval",e);
        }
    }

    @Override
    public ServiceIntervalDTO update(ServiceIntervalDTO serviceInterval) {
        try {
            ServiceInterval interval = beanMappingService.mapTo(serviceInterval, ServiceInterval.class);
            ServiceInterval updated = serviceIntervalService.update(interval);
            return beanMappingService.mapTo(updated, ServiceIntervalDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot update service interval",e);
        }
    }
    
}
