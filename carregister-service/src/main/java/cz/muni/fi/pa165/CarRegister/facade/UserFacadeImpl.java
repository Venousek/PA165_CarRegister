/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.facade;

import cz.muni.fi.pa165.CarRegister.dto.UserDTO;
import cz.muni.fi.pa165.CarRegister.entities.User;
import cz.muni.fi.pa165.CarRegister.service.BeanMappingService;
import cz.muni.fi.pa165.CarRegister.service.UserService;
import cz.muni.fi.pa165.exception.CarRegisterDataAccessException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Henrich
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade
{
    @Inject
    private UserService userService;
    
    @Inject
    private BeanMappingService beanMappingService;
    
    @Override
    public UserDTO createUser(UserDTO user)
    {
        try {
        User user1 = beanMappingService.mapTo(user, User.class);
        User user2 = userService.create(user1);
        return beanMappingService.mapTo(user2, UserDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot create new user", e);
        }
    }

    @Override
    public List<UserDTO> findAll()
    {
        try {
            return beanMappingService.mapTo(userService.findAll(), UserDTO.class);
         } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find all users", e);
        }
    }

    @Override
    public UserDTO findById(Long id)
    {
        try {
            User user = userService.findById(id);
            return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot find user id", e);
        }
    }

    @Override
    public void remove(UserDTO user)
    {
        try {
            User mappedUser = beanMappingService.mapTo(user, User.class);
            userService.delete(mappedUser);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot remove user",e);
        }
    }

    @Override
    public UserDTO update(UserDTO user)
    {
        try {
            User user1 = beanMappingService.mapTo(user, User.class);
            User user2 = userService.update(user1);
            return beanMappingService.mapTo(user2, UserDTO.class);
        } catch (Exception e) {
            throw new CarRegisterDataAccessException("cannot update user",e);
        }
    }
    
}
