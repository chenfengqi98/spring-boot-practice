package com.helloworld.demo.controller;

import com.helloworld.demo.entity.User;
import com.helloworld.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        System.out.println(user.toString());
        return userService.addUser(user);
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public  int deleteUser(@RequestBody User user){
        System.out.println(user.toString());
        return userService.deleteUser(user);
    }
}

