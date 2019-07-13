package com.cheer.service.impl;

import com.cheer.dao.BlogMapper;
import com.cheer.domain.Blog;
import com.cheer.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public void insertBlog(Blog blog) {
        blogMapper.insertBlog(blog);
    }

    @Override
    public List<Blog> getBlog() {
        List<Blog> blogs = blogMapper.getBlog();
        return blogs;
    }

    @Override
    public Blog findBlog(Integer blogid) {
        Blog blog = blogMapper.findBlog(blogid);
        return blog;
    }

    @Override
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }

    @Override
    public List<Blog> searchBlog(String username) {
        List<Blog> blogList = blogMapper.searchBlog(username);
        return blogList;
    }
}
