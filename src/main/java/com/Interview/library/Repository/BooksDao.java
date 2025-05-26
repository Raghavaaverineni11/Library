package com.Interview.library.Repository;

import com.Interview.library.Model.Books;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDao {


    void createBook(Books book);
    Books getBookById(Integer id);
    void updateBook(Books book);
    void deleteBook(Integer id);
    List<Books> getBooksByUserId(Integer userId);
    List<Books> getAllBooks();


}
