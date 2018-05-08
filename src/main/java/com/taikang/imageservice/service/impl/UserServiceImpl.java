package com.taikang.imageservice.service.impl;

import com.taikang.imageservice.mapper.UserMapper;
import com.taikang.imageservice.pojo.User;
import com.taikang.imageservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll()==null?null:userMapper.selectAll();
    }
}
