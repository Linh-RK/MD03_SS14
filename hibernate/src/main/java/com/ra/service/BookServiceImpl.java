package com.ra.service;

import com.ra.dao.BookDAO;
import com.ra.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Boolean create(Book book) {
        return bookDAO.create(book);
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public Boolean update(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public void delete(int id) {
        bookDAO.delete(id);
    }
}
