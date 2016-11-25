package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.dao.CarDao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import java.util.List;
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
        carDao.delete(car);        
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
