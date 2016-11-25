package cz.muni.fi.pa165.CarRegister.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import cz.muni.fi.pa165.CarRegister.entities.Car;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author henrich
 */
@Repository
@Transactional
public class CarDaoImpl extends HibernateDaoSupport implements CarDao
{

    @PersistenceContext
    private EntityManager em;

    public CarDaoImpl() {
        
    }
    
    public CarDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Inject
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public void create(Car car) {    
        em.persist(car);
    }

    @Override
    public Car findById(Long id) {
        return em.find(Car.class, id);
    }

    @Override
    public List<Car> findAll() {
        Query q = em.createQuery("select c from Car c");
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
        
    @Override
    public List<Car> findAllAvailable() {
        Query q = em.createQuery("select c from Car c where c.mileage < 300000"
                + " and not exists (from Drive d where d.car = c and d.end not null)");
        return q.getResultList();
    }

}
