package com.cheer.service;

import com.cheer.domain.Blog;

import java.util.List;

public interface BlogService {

    public void insertBlog(Blog blog);

    public List<Blog> getBlog();

    public Blog findBlog(Integer blogid);

    public void updateBlog(Blog blog);

    public List<Blog> searchBlog(String username);
}
