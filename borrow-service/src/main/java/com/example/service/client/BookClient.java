package com.example.service.client;

import com.example.entity.Book;
import com.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("bookservice")
public interface BookClient {
    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid);
}
