package com.Interview.library.Repository;

import com.Interview.library.Model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserImpl implements UserDao{


    @PersistenceContext
    private EntityManager en;

    @Override
    public void createUser(User user) {
        en.persist(user);
    }

    @Override
    public User getUserById(Integer id) {
        return en.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        en.merge(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = en.find(User.class, id);
        if (user != null) en.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return en.createQuery("FROM User", User.class).getResultList();
    }
}




