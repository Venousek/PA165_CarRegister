package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import java.util.List;

/**
 *
 * @author blahut
 */
public interface UserFacade {
    
    /**
     * Creates User
     * @param user User object as DTO
     * @return created object
     */
    UserDTO createUser(UserDTO user);

    /**
     * Gets All Users
     * @return list of all Users as DTO objects
     */
    List<UserDTO> findAll();
    
    /**
     * Get Existing user by id
     * @param id User id
     * @return UserDto
     */
    UserDTO findById(Long id);

    /**
     * Delete User by id
     * @param user User object to remove
     */
    void remove(UserDTO user);

    /**
     * Update User object
     * @param user User object as DTO
     * @return updated User DTO
     */
    UserDTO update(UserDTO user);

}