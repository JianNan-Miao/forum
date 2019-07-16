package com.cheer.service;

import com.cheer.domain.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface UserService {
     List<User> getUserList();

     void insertUser(User user);

     User getUser(@Param("username") String username, @Param("password") String password);

     User getUserByUsername(String username);
}
