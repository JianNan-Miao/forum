package com.cheer.service;

import com.cheer.domain.Blog;

import java.util.List;

public interface BlogService {

     void insertBlog(Blog blog);

     List<Blog> getBlog();

     Blog findBlog(Integer blogid);

    void updateBlog(Blog blog);

     List<Blog> searchBlog(String username);

     void delBlog(Integer blogid);

    List<Blog> likeQueryBlog(String theme);
}
