package cz.muni.fi.pa165.CarRegister.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.User;

/**
 *
 * @author henrich
 */
public class CarDaoImpl implements CarDao
{
	//@Inject
    //@PersistenceContext
    private EntityManager em;

    public CarDaoImpl() {
        
    }
    
    public CarDaoImpl(EntityManager em) {
        this.em = em;
    }
    
	@Override
	public void create(Car car) {    
        em.persist(car);
	}

	@Override
	public Car findById(Long id) {
        Query q = em.createQuery("select c from Car u where c.id = :id", Car.class);
        q.setParameter("id", id);
        return (Car) q.getSingleResult();
	}

	@Override
	public List<Car> findAll() {
        Query q = em.createQuery("select c from Car c", Car.class);
        return q.getResultList();
	}

	@Override
	public void update(Car car) {
		em.merge(car);
	}

	@Override
	public void delete(Car car) {
		em.remove(car);
	}

}
