package com.Interview.library.Service;

import com.Interview.library.Model.User;
import com.Interview.library.Repository.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class userService {

    private final UserDao userDao;

    // Constructor injection for UserDao
    public userService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(User user) {
        // Add any business logic if needed (e.g., password hashing)
        userDao.createUser(user);
    }


    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }


    public void updateUser(User user) {
        userDao.updateUser(user);
    }


    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    public List<User> getAllUsers(){
       return userDao.getAllUsers();
    }


}
