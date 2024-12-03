package com.example.controller;

import com.example.bookservice.BookService;
import com.example.entity.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid, HttpServletRequest request){
        System.out.println(request.getHeader("TEST"));
        return bookService.getBookById(bid);
    }
}
