package com.cheer.dao;

import com.cheer.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> getUserList();

    public void insertUser(User user);

    public User getUser(@Param("username") String username,@Param("password") String password);
}
