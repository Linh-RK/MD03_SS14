package com.ra.controller;

import com.ra.model.Book;
import com.ra.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {
    //tiem phu thuoc
    @Autowired
    private BookService bookService;

    // show all book
    @GetMapping
    public String index(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/index";
    }

    //add
    @GetMapping("/add")
    public String add(Model model, Book book) {
        model.addAttribute("book", new Book());
        return "/book/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Book book) {
        if (bookService.create(book)) {
            return "redirect:/book";
        }
        return "book/add";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute Book book, Model model, @PathVariable int id) {
        if (bookService.update(book)) {
            model.addAttribute("book", bookService.findById(id));
            return "redirect:/book";
        }
        return "/book/edit/" + id;
    }

    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        bookService.delete(id);
        return "redirect:/book";
    }
}