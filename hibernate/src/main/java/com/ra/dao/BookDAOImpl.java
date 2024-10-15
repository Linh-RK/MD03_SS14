package com.ra.dao;

import com.ra.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory ;

    @Override
    public List<Book> findAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Book",Book.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public Boolean create(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        Book book;
        try (Session session = sessionFactory.openSession();){
            // Truy vấn Book bằng id
        book = session.get(Book.class, id);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
//            Book book = session.get(Book.class, id);
//            if (book != null) {
//                session.delete(book);
//                session.getTransaction().commit();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}