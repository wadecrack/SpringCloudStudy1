package com.example.controller;


import com.example.entity.UserBorrowDetails;
import com.example.service.BorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetails getUserBorrowDetails(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowDetailByUid(uid);
    }

}
