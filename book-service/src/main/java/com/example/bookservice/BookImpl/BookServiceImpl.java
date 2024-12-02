package com.example.bookservice.BookImpl;

import com.example.bookmapper.BookMapper;
import com.example.bookservice.BookService;
import com.example.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public Book getBookById(int bid){
        return  bookMapper.getBookById(bid);
    }

}
