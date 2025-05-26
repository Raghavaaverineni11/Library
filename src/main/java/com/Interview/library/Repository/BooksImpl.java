package com.Interview.library.Repository;


import com.Interview.library.Model.Books;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BooksImpl implements BooksDao {

    @PersistenceContext
    private EntityManager e;


    // Book methods
    @Override
    public void createBook(Books book) {
        e.persist(book);
    }

    @Override
    public Books getBookById(Integer id) {
        return e.find(Books.class, id);
    }

    @Override
    public void updateBook(Books book) {
        e.merge(book);
    }

    @Override
    public void deleteBook(Integer id) {
        Books book = e.find(Books.class, id);
        if (book != null) e.remove(book);
    }

    @Override
    public List<Books> getBooksByUserId(Integer userId) {
        return e.createQuery("FROM Books b WHERE b.user.id = :userId", Books.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Books> getAllBooks(){
        return e.createNativeQuery("SELECT * FROM books", Books.class).getResultList();
    }







}
