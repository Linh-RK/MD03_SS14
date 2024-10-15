package com.ra.service;

import com.ra.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Boolean create(Book book);
    Book findById(int id);
    Boolean update(Book book);
    void delete(int id);
}
