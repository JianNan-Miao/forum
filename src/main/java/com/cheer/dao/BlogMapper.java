package com.cheer.dao;

import com.cheer.domain.Blog;

import java.util.List;

public interface BlogMapper {

    public void insertBlog(Blog blog);

    public List<Blog> getBlog();

    public Blog findBlog(Integer blogid);

    public void updateBlog(Blog blog);

    public List<Blog> searchBlog(String username);
}
