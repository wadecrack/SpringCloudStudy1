package com.example.service.impl;


import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimp implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUserById(int uid) {
       return userMapper.getUserById(uid);
    }


}
