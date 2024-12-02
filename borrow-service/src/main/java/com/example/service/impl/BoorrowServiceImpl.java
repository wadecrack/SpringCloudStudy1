package com.example.service.impl;

import com.example.entity.Book;
import com.example.entity.Borrow;
import com.example.entity.User;
import com.example.entity.UserBorrowDetails;
import com.example.mapper.BorrowMapper;
import com.example.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoorrowServiceImpl  implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Override
    public UserBorrowDetails getUserBorrowDetailByUid(int uid){

        List<Borrow> borrow=borrowMapper.getBorrowsByUid(uid);
        RestTemplate template = new RestTemplate();
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = template.getForObject("http://localhost:8201/user/"+uid, User.class);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://localhost:8101/book/"+b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetails(user, bookList);

    }
}
