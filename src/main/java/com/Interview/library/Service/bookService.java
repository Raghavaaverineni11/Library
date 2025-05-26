package com.Interview.library.Service;

import com.Interview.library.Model.Books;
import com.Interview.library.Repository.BooksDao;
import com.Interview.library.Repository.BooksImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class bookService {


    private final BooksDao booksDao;

    // Constructor injection (recommended)
    public bookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }


    public void createBook(Books book) {
        // you can add business logic here before creating a book
        booksDao.createBook(book);
    }


    public Books getBookById(Integer id) {
        return booksDao.getBookById(id);
    }


    public void updateBook(Books book) {
        booksDao.updateBook(book);
    }


    public void deleteBook(Integer id) {
        booksDao.deleteBook(id);
    }


    public List<Books> getBooksByUserId(Integer userId) {
        return booksDao.getBooksByUserId(userId);
    }


    public List<Books> getAllBooks(){
             return booksDao.getAllBooks();
    }

}
