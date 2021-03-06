package cz.muni.fi.pa165.CarRegister.dao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author robha
 */
@Repository
@Transactional
public class DriveDaoImpl extends HibernateDaoSupport implements DriveDao
{
    @PersistenceContext
    private EntityManager em;

    public DriveDaoImpl() {
    }
    
    public DriveDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Inject
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
    
    @Override
    public void create(Drive drive) {        
        em.persist(drive);        
    }

    @Override
    public Drive findById(Long id) {
        return em.find(Drive.class, id);
    }

    @Override
    public List<Drive> findAll() {
        Query q = em.createQuery("select d from Drive d");
        return q.getResultList();
    }

    @Override
    public List<Drive> findAllByCar(Car car) {
        Query q = em.createQuery("select d from Drive d where d.car.id = :carId order by d.begin");
        q.setParameter("carId", car.getId());
        return q.getResultList();
    }

    @Override
    public void update(Drive drive) {        
        em.merge(drive);        
    }

    @Override
    public void delete(Drive drive) {
        em.remove(drive);     
        em.flush();
    }

    
}
