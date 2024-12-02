package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid) {
        return userService.getUserById(uid);

    }
}
