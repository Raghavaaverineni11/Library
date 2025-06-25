package com.Interview.library;


import com.Interview.library.Model.User;
import com.Interview.library.Repository.BooksDao;
import com.Interview.library.Repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceTest {


    @Autowired
    private  BooksDao d;

    @Autowired
    private UserDao a;

     @Test
     public void getbyid(){
         assertNotNull(d.getBookById(7));
     }

    @Test
    public void testGetUserById_ReturnsCorrectUser() {
        // Arrange
        Integer userId = 3;  // Make sure this user exists in your test DB

        // Act
        User actualUser = a.getUserById(userId);

        // Assert
        assertNotNull(actualUser, "User should not be null");
        assertEquals(userId, actualUser.getId(), "User ID should match");
        assertEquals("ajay", actualUser.getUsername(), "Username should match");
        assertEquals("Admin", actualUser.getRole(), "Role should match");

        // Optionally test books list is not null (or empty)
        assertNotNull(actualUser.getBooks(), "Books list should not be null");
    }






}
