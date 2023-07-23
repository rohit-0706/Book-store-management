package com.bookStore.rohit.controller;

import com.bookStore.rohit.entity.Book;
import com.bookStore.rohit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }


    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book>list=service.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book",list);
        return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }

}
