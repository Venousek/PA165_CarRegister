package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.dao.UserDao;
import cz.muni.fi.pa165.CarRegister.entities.User;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author Sevo001
 */


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Inject
    private UserDao userDao;

    public void setUserDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(User user) {
        userDao.create(user);
        return user;
    }

    @Override
    public User update(User user) {
        userDao.update(user);
        return user;
    }

    @Override
    public void delete(User user) {
        User foundUser = findById(user.getId());
        
        userDao.delete(foundUser);        
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }
}
