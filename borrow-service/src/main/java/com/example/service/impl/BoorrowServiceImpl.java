package com.example.service.impl;

import com.example.entity.Book;
import com.example.entity.Borrow;
import com.example.entity.User;
import com.example.entity.UserBorrowDetails;
import com.example.mapper.BorrowMapper;
import com.example.service.BorrowService;
import com.example.service.client.BookClient;
import com.example.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoorrowServiceImpl  implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;
   @Resource
    UserClient userClient;
   @Resource
    BookClient bookClient;
    @Override
    public UserBorrowDetails getUserBorrowDetailByUid(int uid){

        List<Borrow> borrow=borrowMapper.getBorrowsByUid(uid);

        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = userClient.getUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetails(user, bookList);

    }
}
