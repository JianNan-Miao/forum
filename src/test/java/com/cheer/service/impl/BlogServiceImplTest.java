package com.cheer.service.impl;

import com.cheer.domain.Blog;
import com.cheer.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {
    @Autowired
    private BlogService blogService;

    @Test
    public void likeQueryBlog() {
        List<Blog> blogs = blogService.likeQueryBlog("咸鱼");
        System.out.println(blogs);
    }
}