package com.helloworld.demo.service;

import com.helloworld.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    int addUser(User user);
    int deleteUser(User user);
}
