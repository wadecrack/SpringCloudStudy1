package com.example.controller;


import com.example.entity.UserBorrowDetails;
import com.example.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;
    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetails getUserBorrowDetails(@PathVariable("uid") int uid){
        System.out.println("开始向其他服务获取信息");
        return borrowService.getUserBorrowDetailByUid(uid);
    }

    UserBorrowDetails onError(int uid){
        System.out.println("降级");
        return new UserBorrowDetails(null, Collections.emptyList());
    }

}
