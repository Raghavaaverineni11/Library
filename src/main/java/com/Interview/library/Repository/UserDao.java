package com.Interview.library.Repository;
import java.util.*;
import com.Interview.library.Model.Books;
import com.Interview.library.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void createUser(User user);
    User getUserById(Integer id);
    void updateUser(User user);
    void deleteUser(Integer id);
    public List<User> getAllUsers();




}

