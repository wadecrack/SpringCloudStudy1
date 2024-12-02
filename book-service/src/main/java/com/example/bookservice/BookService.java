package com.example.bookservice;


import com.example.entity.Book;
import org.springframework.stereotype.Service;


public interface BookService {
    Book getBookById(int bid);
}
