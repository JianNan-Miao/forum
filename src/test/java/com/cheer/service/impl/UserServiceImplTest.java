package com.cheer.service.impl;

import com.cheer.domain.User;
import com.cheer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserList() {
        List<User> userList = userService.getUserList();
        System.out.println(userList.size());
    }

    @Test
    public void insertUser() {
        User user=new User(1,"n","j","j","oo");
        userService.insertUser(user);
    }
}