package cz.muni.fi.pa165.CarRegister.dao;

import cz.muni.fi.pa165.CarRegister.entities.User;
import java.util.List;

/**
 *
 * @author robha
 */
public interface UserDao {
        /**
     * Creates new user in DB.
     * 
     * @param user to create
     */
    void create(User user);
    
    /**
     * Retrieves user with specified ID from DB.
     * 
     * @param id
     * @return user with specified ID
     */
    User findById(Long id);
    
    /**
     * Retrieves user with specified Login from DB.
     * 
     * @param Login
     * @return user with specified Login
     */
    User findByLogin(String login);
    
    /**
     * Retrieves all users from DB.
     * 
     * @return all users existing in DB
     */
    List<User> findAll();
    
    /**
     *  Updates users record in DB.
     * 
     * @param user to update
     */
    void update(User user);
    
    /**
     * Removes user record from DB.
     * 
     * @param user to remove
     */
    void delete(User user);    
}
