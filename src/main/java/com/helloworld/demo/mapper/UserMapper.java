package com.helloworld.demo.mapper;

import com.helloworld.demo.entity.User;



import java.util.List;

public interface UserMapper {
    List<User> getAllUser();
    int addUser(User user);
    int deleteUser(User user);
}
