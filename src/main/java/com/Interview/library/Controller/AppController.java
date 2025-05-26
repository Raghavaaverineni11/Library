package com.Interview.library.Controller;


import com.Interview.library.Model.Books;
import com.Interview.library.Model.User;
import com.Interview.library.Service.bookService;
import com.Interview.library.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    private final userService userService;
    private final bookService bookService;

    public AppController(userService userService, bookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    // ====== User endpoints ======

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User created successfully";
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return "User updated successfully";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ====== Book endpoints ======

    @PostMapping("/books")
    public String createBook(@RequestBody Books book) {
        bookService.createBook(book);
        return "Book created successfully";
    }

    @GetMapping("/books/all")
    public List<Books> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Books getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public String updateBook(@PathVariable Integer id, @RequestBody Books book) {
        book.setId(id);
        bookService.updateBook(book);
        return "Book updated successfully";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }

    @GetMapping("/users/{userId}/books")
    public List<Books> getBooksByUserId(@PathVariable Integer userId) {
        return bookService.getBooksByUserId(userId);
    }
}

