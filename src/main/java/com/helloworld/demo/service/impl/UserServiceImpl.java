package com.helloworld.demo.service.impl;

import com.helloworld.demo.entity.User;
import com.helloworld.demo.mapper.UserMapper;
import com.helloworld.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
@Primary
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreatedTime(form.format(new Date()));
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
