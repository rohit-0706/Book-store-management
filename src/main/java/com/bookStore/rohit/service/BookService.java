package com.bookStore.rohit.service;

import com.bookStore.rohit.entity.Book;
import com.bookStore.rohit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class BookService {

    @Autowired
    private BookRepository bRepo;
    public void save(Book b){
        bRepo.save(b);

    }

    public List<Book> getAllBook(){
        return bRepo.findAll();
    }


}
