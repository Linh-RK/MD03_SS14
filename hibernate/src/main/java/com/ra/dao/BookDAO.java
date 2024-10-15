package com.ra.dao;

import com.ra.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Boolean create(Book book);
    Book findById(int id);
    Boolean update(Book book);
    void  delete(int id);
}
