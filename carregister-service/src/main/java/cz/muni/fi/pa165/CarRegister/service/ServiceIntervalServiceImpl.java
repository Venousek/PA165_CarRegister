/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;
import cz.muni.fi.pa165.CarRegister.dao.ServiceIntervalDao;
import  cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author robha
 */
@Service("serviceIntervalService")
@Transactional
public class ServiceIntervalServiceImpl implements ServiceIntervalService {

    @Inject
    private ServiceIntervalDao serviceIntervalDao;
    
    public void setServiceIntervalDAO(ServiceIntervalDao intervalDao) {
        this.serviceIntervalDao = intervalDao;
    }
    
    @Override
    public ServiceInterval create(ServiceInterval interval) {
        serviceIntervalDao.create(interval);
        return interval;
    }

    @Override
    public ServiceInterval update(ServiceInterval interval) {
        serviceIntervalDao.update(interval);
        return interval;
    }

    @Override
    public void delete(ServiceInterval interval) {
        serviceIntervalDao.delete(interval); 
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
