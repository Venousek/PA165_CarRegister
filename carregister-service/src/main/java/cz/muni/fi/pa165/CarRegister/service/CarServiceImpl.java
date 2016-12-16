package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.dao.CarDao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import cz.muni.fi.pa165.CarRegister.entities.ServiceInterval;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author blahut
 */
@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {
    
    @Inject
    private CarDao carDao;
    
    @Inject
    private ServiceIntervalService serviceIntervalService;
    
    @Inject
    private DriveService driveService;

    public void setCarDAO(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car create(Car car) {
        carDao.create(car);
        return car;
    }

    @Override
    public Car update(Car car) {
        carDao.update(car);
        return car;
    }

    @Override
    public void delete(Car car) {
        Car foundCar = findById(car.getId());
        
        List<ServiceInterval> intervals = serviceIntervalService.findAll();
        for (ServiceInterval interval : intervals)
        {
           if (Objects.equals(interval.getCar().getId(), foundCar.getId()))
           {
               serviceIntervalService.delete(interval);
           }
        }
        
        List<Drive> drives = driveService.findAll();
        for (Drive drive : drives)
        {
           if (Objects.equals(drive.getCar().getId(), foundCar.getId()))
           {
               driveService.delete(drive);
           }
        }
        
        carDao.delete(foundCar);        
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public List<Car> findAllAvailable() {
        return carDao.findAllAvailable();
    }

    @Override
    public Car findById(Long id) {
        return carDao.findById(id);
    }
}
