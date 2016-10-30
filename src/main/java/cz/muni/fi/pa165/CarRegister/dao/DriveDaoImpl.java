package cz.muni.fi.pa165.CarRegister.dao;
import cz.muni.fi.pa165.CarRegister.entities.Car;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author robha
 */
public class DriveDaoImpl implements DriveDao
{
    //@Inject
    //@PersistenceContext
    private EntityManager em; 

    public DriveDaoImpl() {
    }
    
    public DriveDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void create(Drive drive) {
        if(drive!=null) {
            em.persist(drive);
        }
    }

    @Override
    public Drive findById(Long id) {
        Query q = em.createQuery("select d from Drive u where d.id = :id", Drive.class);
        q.setParameter("id", id);
        return (Drive) q.getSingleResult();
    }

    @Override
    public List<Drive> findAll() {
        Query q = em.createQuery("select d from Drive u", Drive.class);
        return q.getResultList();
    }

    @Override
    public void update(Drive drive) {
        if(drive!=null) {
            em.merge(drive);
        }
    }

    @Override
    public void delete(Drive drive) {
        if(drive!=null) {
            em.remove(drive);
        }
    }

    
}
