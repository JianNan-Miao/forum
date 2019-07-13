package com.cheer.service;

import com.cheer.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> getUserList();

    public void insertUser(User user);

    public User getUser(@Param("username") String username, @Param("password") String password);
}
